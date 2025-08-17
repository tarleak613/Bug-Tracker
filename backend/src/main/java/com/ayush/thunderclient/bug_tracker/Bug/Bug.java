package com.ayush.thunderclient.bug_tracker.Bug;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Severity severity; // Low/Med/High

    @Enumerated(EnumType.STRING)
    private Status status;   // New/In Progress/Fixed/Verified

    private Long assigneeId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Enums for severity & status
    public enum Severity { LOW, MEDIUM, HIGH }
    public enum Status { NEW, IN_PROGRESS, FIXED, VERIFIED }
}
