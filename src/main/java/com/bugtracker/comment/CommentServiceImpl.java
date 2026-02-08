package com.bugtracker.comment;

import com.bugtracker.entity.Ticket;
import com.bugtracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepository commentRepo;
    @Autowired
    private final TicketRepository ticketRepo;

    public CommentServiceImpl(CommentRepository commentRepo, TicketRepository ticketRepo) {
        this.commentRepo = commentRepo;
        this.ticketRepo = ticketRepo;
    }

    public Comment addComment(Long ticketId, String message) {
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        Comment comment = new Comment();
        comment.setMessage(message);   // ✅ THIS IS IMPORTANT
        comment.setTicket(ticket);

        return commentRepo.save(comment);
    }


    @Override
    public List<Comment> getComments(Long ticketId) {
        return commentRepo.findByTicketId(ticketId);
    }
}
