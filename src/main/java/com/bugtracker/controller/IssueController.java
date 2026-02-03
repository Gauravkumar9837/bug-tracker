package com.bugtracker.controller;
import java.util.List;
import com.bugtracker.issue.Issue;
import com.bugtracker.issue.IssueRequest;
import com.bugtracker.issue.IssueService;
import com.bugtracker.issue.IssueStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public Issue createIssue(@RequestBody IssueRequest request) {
        return issueService.createIssue(request);
    }

    @GetMapping
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/filter/status")
    public List<Issue> filterByStatus(@RequestParam String value) {
        return issueService.getIssuesByStatus(value);
    }


    @PutMapping("/{id}/status")
    public Issue updateIssueStatus(
            @PathVariable Long id,
            @RequestParam String value) {

        return issueService.updateStatus(id, value);
    }

    @GetMapping("/priority/{priority}")
    public List<Issue> getByPriority(@PathVariable String priority) {
        return issueService.getIssuesByPriority(priority);
    }

    @GetMapping("/filter/assignee")
    public List<Issue> filterByAssignee(@RequestParam String value) {
        return issueService.getIssuesByAssignee(value);
    }


    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id,
                             @RequestBody Issue issue,
                             @RequestParam String user) {
        return issueService.updateIssue(id, issue, user);
    }

    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Long id,
                              @RequestParam String role) {

        issueService.deleteIssue(id, role);
        return "Issue deleted successfully";
    }


    @GetMapping("/search")
    public List<Issue> searchIssues(@RequestParam String title) {
        return issueService.searchByTitle(title);
    }

    @GetMapping("/filter")
    public List<Issue> filterIssues(
            @RequestParam IssueStatus status,
            @RequestParam String priority) {

        return issueService.filterByStatusAndPriority(status, priority);
    }


    @GetMapping("/status/{status}")
    public List<Issue> getByStatus(@PathVariable String status) {
        return issueService.getIssuesByStatus(status);
    }




//    @GetMapping("/test")
//    public String testIssueApi() {
//        return "Issue API is working";
//    }

}
