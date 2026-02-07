package com.bugtracker.comment;

import com.bugtracker.entity.Ticket;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Comment() {}

    public Comment(String content, Ticket ticket) {
        this.content = content;
        this.ticket = ticket;
    }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Ticket getTicket() { return ticket; }

    public void setContent(String content) { this.content = content; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
