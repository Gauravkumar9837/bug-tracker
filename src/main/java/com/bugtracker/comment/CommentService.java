package com.bugtracker.comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Long ticketId, String message);
    List<Comment> getComments(Long ticketId);
}
