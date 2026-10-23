# Skill and Certification Tracker

A beginner-friendly Java full-stack starter project using Spring Boot, Spring Data JPA, MySQL, HTML, CSS and JavaScript.

## Requirements
- JDK 17 or newer
- Maven 3.9+
- MySQL 8+
- VS Code with Extension Pack for Java and Spring Boot Extension Pack

## Database
Create a MySQL database if you prefer to do it manually:
```sql
CREATE DATABASE skill_tracker;
```
The default settings use `localhost:3306`, username `root`, and a blank password. Set `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables if your settings differ. Do not use a blank password outside a local learning environment.

## Run
From the folder containing `pom.xml`, run:
```bash
mvn spring-boot:run
```
Then open http://localhost:8080.

## API
- `GET/POST /api/skills`
- `PUT/DELETE /api/skills/{id}`
- `GET/POST /api/certifications`
- `PUT/DELETE /api/certifications/{id}`

This is a learning starter, not a production-ready app. It has no login/authorization and should not be exposed publicly as-is.
