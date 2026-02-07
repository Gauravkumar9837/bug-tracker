//package com.bugtracker.issue;
//import java.util.List;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.http.HttpStatus;
//
//import com.bugtracker.issue.IssueRepository;
//import com.bugtracker.issue.IssueStatus;
//
//
//
//@Service
//public class IssueService {
//
//    private final IssueRepository issueRepository;
//
//    // Constructor injection
//    public IssueService(IssueRepository issueRepository) {
//        this.issueRepository = issueRepository;
//    }
//
//    public Issue updateStatus(Long issueId, String newStatus) {
//
//        Issue issue = issueRepository.findById(issueId)
//                .orElseThrow(() -> new RuntimeException("Issue not found"));
//
//        issue.setStatus(IssueStatus.valueOf(newStatus));
//
//
//        return issueRepository.save(issue);
//    }
//
//
//    public Issue createIssue(IssueRequest request) {
//
//        Issue issue = new Issue();
//        issue.setTitle(request.getTitle());
//        issue.setDescription(request.getDescription());
//        issue.setPriority(request.getPriority());
//        issue.setAssignedTo(request.getAssignedTo());
//
//        // Default status when issue is created
//        issue.setStatus(IssueStatus.TODO);
//
//
//        return issueRepository.save(issue);
//
//    }
//    public List<Issue> getAllIssues() {
//        return issueRepository.findAll();
//    }
//
//    public List<Issue> getIssuesByStatus(String status) {
//        IssueStatus issueStatus = IssueStatus.valueOf(status.toUpperCase());
//        return issueRepository.findByStatus(issueStatus);
//    }
//
//    public List<Issue> getIssuesByPriority(String priority) {
//        return issueRepository.findByPriority(priority.toUpperCase());
//    }
//    public List<Issue> getIssuesByAssignee(String assignee) {
//        return issueRepository.findByAssignedTo(assignee);
//    }
//    public List<Issue> searchByTitle(String keyword) {
//        return issueRepository.findByTitleContainingIgnoreCase(keyword);
//    }
//
//    public List<Issue> filterByStatusAndPriority(IssueStatus status, String priority) {
//        return issueRepository.findByStatusAndPriority(status, priority);
//    }
//
////    public Issue updateIssue(Long id, IssueRequest request) {
////
////        Issue issue = issueRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Issue not found"));
////
////        // Authorization check
////        if (!issue.getAssignedTo().equals(loggedInUser)) {
////            throw new RuntimeException("You are not allowed to edit this issue");
////        }
////        issue.setTitle(request.getTitle());
////        issue.setDescription(request.getDescription());
////        issue.setPriority(request.getPriority());
////        issue.setAssignedTo(request.getAssignedTo());
////        issue.setStatus(updatedIssue.getStatus());
////
////        return issueRepository.save(issue);
////    }
//public Issue updateIssue(Long id, Issue updatedIssue, String loggedInUser) {
//
//    Issue issue = issueRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Issue not found"));
//
//    // Only assigned user can edit
//    if (!issue.getAssignedTo().equalsIgnoreCase(loggedInUser)) {
//        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not allowed to update this issue");
//
//    }
//
//    issue.setTitle(updatedIssue.getTitle());
//    issue.setDescription(updatedIssue.getDescription());
//    issue.setStatus(updatedIssue.getStatus());
//    issue.setPriority(updatedIssue.getPriority());
//
//    return issueRepository.save(issue);
//}
//
//
//    public void deleteIssue(Long id, String role) {
//
//        if (!role.equals("ADMIN")) {
//            throw new RuntimeException("Only admin can delete issues");
//        }
//
//        issueRepository.deleteById(id);
//    }
//
//
//
//
//}
