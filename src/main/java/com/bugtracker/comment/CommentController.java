package com.bugtracker.comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // ➕ Add comment to issue
    @PostMapping("/{issueId}")
    public Comment addComment(@PathVariable Long issueId,
                              @RequestBody Comment comment) {
        return commentService.addComment(issueId, comment);
    }
//    @PostMapping("/{issueId}")
//    public Comment addComment(
//            @PathVariable Long issueId,
//            @RequestBody CommentRequest request) {
//
//        return commentService.addComment(issueId, request);
//    }


    // 📄 Get all comments of an issue
    @GetMapping("/{issueId}")
    public List<Comment> getComments(@PathVariable Long issueId) {
        return commentService.getCommentsByIssue(issueId);
    }
}
