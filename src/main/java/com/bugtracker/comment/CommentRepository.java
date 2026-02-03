package com.bugtracker.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Get all comments of a specific issue
    List<Comment> findByIssueId(Long issueId);
}
