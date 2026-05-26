# MovieTix - Project Instructions

This project is a modern, full-stack movie ticket booking platform built with a microservices architecture. It features a Spring Boot backend and a Next.js frontend.

## Project Overview

- **Architecture:** Microservices
- **Backend Tech Stack:** Java 17, Spring Boot 3.4.1, Spring Cloud (2024.0.0), Maven, Lombok, MySQL 8.
- **Frontend Tech Stack:** Next.js 15, React 18, TypeScript, Tailwind CSS 4, TanStack Query, Radix UI, Framer Motion, Zod.
- **Core Microservices:**
  - `api-gateway`: Centralized routing and security (Port 8080).
  - `eureka-server`: Service discovery and registration (Port 8761).
  - `config-server`: Externalized configuration management (Port 8888).
  - `user-service`: User and Auth management (Port 8081).
  - `movie-service`: Movie catalog management (Port 8082).
  - `theater-service`: Theater management (Port 8083).
  - `showtime-service`: Showtime scheduling (Port 8084).
  - `booking-service`: Booking and reservations (Port 8085).

## Building and Running

### Prerequisites

- Java 17+
- Maven 3.8+
- Node.js 18+ and `pnpm`
- MySQL 8+
- Docker (optional, but recommended for orchestration)

### Backend

To build the entire backend:
```bash
cd backend
mvn clean install
```

To run all services manually (Windows):
```bash
cd backend
./run-all.bat
```

To run with Docker Compose:
```bash
docker-compose up -d
```

### Frontend

To install dependencies and start the development server:
```bash
cd frontend
pnpm install
pnpm dev
```
The frontend will be available at `http://localhost:3000`.

## Development Conventions

### Backend (Spring Boot)

- **Directory Structure:** Follows standard Maven layout. Inside each service:
  - `com.movietix.[service].config`: Configuration classes.
  - `com.movietix.[service].controller`: REST Controllers.
  - `com.movietix.[service].dto`: Data Transfer Objects.
  - `com.movietix.[service].entity`: JPA Entities.
  - `com.movietix.[service].exception`: Custom exceptions and global exception handler.
  - `com.movietix.[service].repository`: Spring Data JPA Repositories.
  - `com.movietix.[service].service`: Business logic interfaces and implementations.
- **Lombok:** Used extensively for reducing boilerplate (e.g., `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`).
- **Security:** JWT-based authentication handled in `user-service` and validated at the `api-gateway`.
- **API Documentation:** SpringDoc OpenAPI (Swagger) is used. Access via `/[service-path]/v3/api-docs` or UI through the gateway.

### Frontend (Next.js)

- **App Router:** Uses the Next.js App Router (`frontend/app`).
- **Styling:** Tailwind CSS 4 with `lucide-react` for icons.
- **Data Fetching:** TanStack Query (`@tanstack/react-query`) for client-side data management and caching.
- **State Management:** React Context for Auth and global state.
- **Components:** Reusable UI components are located in `frontend/components/ui`.
- **Validation:** Zod is used for schema validation (forms and API responses).

## Database Configuration

The project uses multiple MySQL databases, one for each microservice. When running via Docker Compose, these are automatically set up.

- `mysql-user`: Port 3316
- `mysql-movie`: Port 3307
- `mysql-theater`: Port 3308
- `mysql-showtime`: Port 3309
- `mysql-booking`: Port 3310

Each service connects to its respective database using credentials defined in its `application.yml` or Docker environment variables.
