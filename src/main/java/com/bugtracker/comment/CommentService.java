package com.bugtracker.comment;

import com.bugtracker.issue.Issue;
import com.bugtracker.issue.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;

    public CommentService(CommentRepository commentRepository,
                          IssueRepository issueRepository) {
        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
    }

    // Add comment to an issue
    public Comment addComment(Long issueId, Comment comment) {

        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        comment.setIssue(issue);

        return commentRepository.save(comment);
    }
//    public Comment addComment(Long issueId, CommentRequest request) {
//
//        Issue issue = issueRepository.findById(issueId)
//                .orElseThrow(() -> new RuntimeException("Issue not found"));
//
//        Comment comment = new Comment();
//        comment.setContent(request.getContent());
//        comment.setIssue(issue);
//
//        return commentRepository.save(comment);
//    }


    // Get comments of an issue
    public List<Comment> getCommentsByIssue(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}
