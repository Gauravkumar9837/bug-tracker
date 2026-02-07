package com.bugtracker.comment;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/{ticketId}")
    public Comment addComment(@PathVariable Long ticketId, @RequestParam String message) {
        return service.addComment(ticketId, message);
    }

    @GetMapping("/{ticketId}")
    public List<Comment> getComments(@PathVariable Long ticketId) {
        return service.getComments(ticketId);
    }
}
