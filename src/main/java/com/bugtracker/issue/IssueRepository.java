package com.bugtracker.issue;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import com.bugtracker.issue.IssueStatus;



public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findAll();// get all issues
    Optional<Issue> findById(Long id);
    List<Issue> findByStatus(IssueStatus status);
    List<Issue> findByPriority(String priority);
    List<Issue> findByAssignedTo(String assignedTo);
    List<Issue> findByTitleContainingIgnoreCase(String title);
    List<Issue> findByStatusAndPriority(IssueStatus status, String priority);


}
