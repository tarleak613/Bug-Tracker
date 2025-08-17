# 🐞 Bug Tracker - Assignment 2

A simple bug tracking application built as part of the Thunder Client technical assignment.  
The project consists of a **React frontend** and a **Spring Boot backend** with a **PostgreSQL database**, deployed on **Railway**.

---

## 🚀 Live Deployment

- **Frontend**: [Live Bug Tracker UI](https://bug-tracker-frontend-production.up.railway.app)  
- **Backend API**: [Bug Tracker API](https://bug-tracker-production-ce38.up.railway.app)
- **Swagger UI**: [Bug Tracker Swagger UI](https://bug-tracker-production-ce38.up.railway.app/swagger-ui/index.html#/)  

---

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot, Spring Security (JWT), Spring Data JPA, PostgreSQL  
- **Frontend**: React, Axios, React Router, Tailwind CSS (if used)  
- **Hosting**: Railway (frontend + backend + database)  

---

## ⚙️ Setup Instructions

### Clone Repository
```bash
git clone https://github.com/tarleak613/bug-tracker.git
cd bug-tracker
```

## 🔧 Backend Setup

1. Go to backend folder:
```
cd backend
``` 
2. Configure environment variables in application.properties:
```
spring.datasource.url=jdbc:postgresql://<DB_HOST>:<DB_PORT>/<DB_NAME>
spring.datasource.username=<DB_USERNAME>
spring.datasource.password=<DB_PASSWORD>
jwt.secret=<YOUR_SECRET>
```

3. Run with Maven:
```
mvn spring-boot:run
```

4. Backend runs at: http://localhost:8080

## 🎨 Frontend Setup

1. Go to frontend folder:

```
cd frontend
```

2. Install dependencies:

```
npm install
```

3. Start React:
```
npm start
```

4. Frontend runs at: http://localhost:3000

## 📂 Database Schema

### Users

id (PK)
email
passwordHash

### Bugs

id (PK)
title
description
severity (Low/Medium/High)
status (New/In Progress/Fixed/Verified)
assigneeId (FK → Users.id)
createdAt
updatedAt

### Comments

id (PK)
bugId (FK → Bugs.id)
authorId (FK → Users.id)
body
createdAt

##🔌 API Endpoints
Auth

POST /api/auth/register → Register new user
POST /api/auth/login → Login & get JWT

Bugs

POST /api/bugs → Create bug
GET /api/bugs → List bugs (supports filters: severity, status)
GET /api/bugs/{id} → Get bug details
PUT /api/bugs/{id} → Update bug (status, assignee, etc.)
DELETE /api/bugs/{id} → Delete bug

Comments

POST /api/bugs/{id}/comments → Add comment to bug
GET /api/bugs/{id}/comments → List comments for bug


## 🐛 Features Implemented

1. User authentication (JWT-based)
2. Create, update, delete bugs
3. Assign bugs to users
4. Status change workflow: New → In Progress → Fixed → Verified
5. Add & view comments per bug
6. Filter by severity + status

## 📌 Tradeoffs & Future Improvements

1. Currently minimal UI; could be improved with better styling and UX.
2. No file attachments for bug reports (future enhancement).
3. Role-based authorization (Admin/Tester) could be added.
4. Email notifications on bug assignment would improve usability.

## 👨‍💻 Author

Tarleak (GitHub)
