package com.ayush.thunderclient.bug_tracker.Bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    @Autowired
    private BugRepo bugRepo;

    // Create bug
    @PostMapping
    public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
        return ResponseEntity.ok(bugRepo.save(bug));
    }

    // Get all bugs with optional filtering
    @GetMapping
    public ResponseEntity<List<Bug>> getBugs(
            @RequestParam(required = false) Bug.Severity severity,
            @RequestParam(required = false) Bug.Status status) {

        if (severity != null && status != null) {
            return ResponseEntity.ok(bugRepo.findBySeverityAndStatus(severity, status));
        } else if (severity != null) {
            return ResponseEntity.ok(
                    bugRepo.findAll().stream().filter(b -> b.getSeverity() == severity).toList()
            );
        } else if (status != null) {
            return ResponseEntity.ok(
                    bugRepo.findAll().stream().filter(b -> b.getStatus() == status).toList()
            );
        } else {
            return ResponseEntity.ok(bugRepo.findAll());
        }
    }

    // Get bug by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bug> getBug(@PathVariable Long id) {
        return bugRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update bug (title, description, severity, status, assignee)
    @PutMapping("/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable Long id, @RequestBody Bug updated) {
        return bugRepo.findById(id).map(bug -> {
            bug.setTitle(updated.getTitle());
            bug.setDescription(updated.getDescription());
            bug.setSeverity(updated.getSeverity());
            bug.setStatus(updated.getStatus());
            bug.setAssigneeId(updated.getAssigneeId());
            return ResponseEntity.ok(bugRepo.save(bug));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Quick status update (used by Actions buttons)
    @PutMapping("/{id}/status")
    public ResponseEntity<Bug> changeStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest request) {
        return bugRepo.findById(id).map(bug -> {
            bug.setStatus(Bug.Status.valueOf(request.getStatus()));
            return ResponseEntity.ok(bugRepo.save(bug));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete bug
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBug(@PathVariable Long id) {
        bugRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    // DTO for status update request
    public static class StatusUpdateRequest {
        private String status;
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}