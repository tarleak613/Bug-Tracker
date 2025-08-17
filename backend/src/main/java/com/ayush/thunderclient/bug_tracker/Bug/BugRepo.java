package com.ayush.thunderclient.bug_tracker.Bug;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepo extends JpaRepository<Bug, Long> {
    List<Bug> findBySeverityAndStatus(Bug.Severity severity, Bug.Status status);
    List<Bug> findByAssigneeId(Long assigneeId);
}
