# Bug Tracker System (Jira Clone)

A full-stack issue tracking system built with Spring Boot and React.

## 🚀 Features
- JWT Authentication
- Role Based Access (Admin, Manager, Developer)
- Project & Issue Management
- Assign Issues to Users
- Kanban Workflow (TODO → IN_PROGRESS → DONE)
- Comments on Issues
- Search & Filters

## 🛠 Tech Stack
Backend:
- Java 17
- Spring Boot
- Spring Security + JWT
- JPA / Hibernate
- Oracle / MySQL

Frontend:
- React
- Tailwind CSS

## 📌 API Examples
Create Issue:
POST /api/issues

Get Issues:
GET /api/issues

Add Comment:
POST /api/comments/{issueId}
