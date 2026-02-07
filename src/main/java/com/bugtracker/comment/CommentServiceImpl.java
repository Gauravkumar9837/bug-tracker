package com.bugtracker.comment;

import com.bugtracker.entity.Ticket;
import com.bugtracker.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepo;
    private final TicketRepository ticketRepo;

    public CommentServiceImpl(CommentRepository commentRepo, TicketRepository ticketRepo) {
        this.commentRepo = commentRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Comment addComment(Long ticketId, String content) {
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        Comment comment = new Comment(content, ticket);
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getComments(Long ticketId) {
        return commentRepo.findByTicketId(ticketId);
    }
}
