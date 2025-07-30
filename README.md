SkillSync Microservices Architecture
1. Auth Service
Signup/Login for users (Admin, Team Lead, Member)

JWT Token-based authentication

Role-based access

2. User Service
Manage user profile and roles

Fetch all users/team members

Update profile

3. Project Service
Create/Update/Delete projects

Assign users to projects

Fetch project details by user or ID

4. Task Service
Add/Update/Delete tasks

Assign tasks to users

Change task status (To Do, In Progress, Done)

5. Chat Service
Real-time chat between project members (WebSocket)

Store chat history

6. Notification Service
Send email or in-app notifications for task updates, assignments

7. API Gateway
Route requests to respective services

Handle security

8. Eureka Discovery Server
Register and discover microservices

9. Config Server (Optional but Recommended)
Centralized configuration



 Project Structure
skillsync-backend/
├── api-gateway/
├── auth-service/
├── user-service/
├── project-service/
├── task-service/
├── chat-service/
├── notification-service/
├── discovery-server/
├── config-server/
└── common-utils/ (shared DTOs, Feign clients)


Tools & Tech Stack
Spring Boot

Spring Security + JWT

Spring Cloud Gateway

Spring Cloud Eureka

Spring WebSocket (for chat)

Spring Mail

Spring Scheduling

MySQL/PostgreSQL

Lombok, MapStruct

OpenFeign
