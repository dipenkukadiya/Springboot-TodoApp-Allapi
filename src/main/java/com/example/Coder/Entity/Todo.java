package com.example.Coder.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Todo {
    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_description")
    private String description;

    @Column(name = "todo_key")
    private String todoKey;

    @Column(name = "is_archived")
    private Boolean isArchived;

    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private Todolist todolist;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToMany
    @JoinTable(name = "todo_assignees", joinColumns = @JoinColumn(name = "todo_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> assignees = new HashSet<>();
    
    // @Column(name = "assigned_date")
    // private String assignedDate;

    // @Column(name = "estimated_hours")
    // private String estimatedHours;

    // @Column(name = "start_date")
    // private String startDate;

    // @Column(name = "end_date")
    // private String endDate;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
