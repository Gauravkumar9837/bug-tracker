package com.bugtracker.comment;

import com.bugtracker.entity.Ticket;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Comment() {}

    public Comment(String message, Ticket ticket) {
        this.message = message;
        this.ticket = ticket;
    }

    public Long getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Ticket getTicket() { return ticket; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }


    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
