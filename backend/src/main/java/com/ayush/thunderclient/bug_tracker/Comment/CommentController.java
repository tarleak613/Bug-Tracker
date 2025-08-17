package com.ayush.thunderclient.bug_tracker.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs/{bugId}/comments")
public class CommentController {
    @Autowired
    private CommentRepo commentRepo;

    // Add comment
    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long bugId, @RequestBody Comment comment) {
        comment.setBugId(bugId);
        return ResponseEntity.ok(commentRepo.save(comment));
    }

    // Get all comments for a bug
    @GetMapping
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long bugId) {
        return ResponseEntity.ok(commentRepo.findByBugId(bugId));
    }
}
