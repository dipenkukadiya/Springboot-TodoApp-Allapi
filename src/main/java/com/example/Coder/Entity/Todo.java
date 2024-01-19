// package com.example.Coder.Entity;
// import java.sql.Date;

// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;



// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
// import lombok.Data;

// @Data
// @Entity
// public class Todo {
//     @Id
//     @Column(name = "todo_id")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "todo_name")
//     private String name;

//     @Column(name = "todo_description")
//     private String description;

//     @Column(name = "todo_key")
//     private String TodoKey;

//     @Column(name = "is_archived")
//     private Boolean archived;

//     @ManyToOne
//     @JoinColumn(name = "card_id")
//     private Card card;

//     @OneToOne
//     @JoinColumn(name = "user_id")
//     private User CratedBy;

//     @ManyToOne
//     @JoinColumn(name ="user_id")
//     private User AssignTo;
    
//     @Column(name = "assigned_date")
//     private String assignedDate;

//     @Column(name = "estimated_hours")
//     private String estimatedHours;

//     @Column(name = "start_date")
//     private String startDate;

//     @Column(name = "end_date")
//     private String endDate;

//     @CreatedDate @Column(name = "created_date")
//     private Date createdDate;
    
//     @LastModifiedDate @Column(name = "updated_date")
//     private Date updatedDate;
// }
