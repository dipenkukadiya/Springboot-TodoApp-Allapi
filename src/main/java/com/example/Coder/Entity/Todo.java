package com.example.Coder.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

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

    @OneToOne
    @JoinColumn(name = "created_by_id") // Change to a different name, e.g., created_by_id
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id") // Change to a different name, e.g., assigned_to_id
    private User assignedTo;

    @Column(name = "assigned_date")
    private String assignedDate;

    @Column(name = "estimated_hours")
    private String estimatedHours;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;
}
