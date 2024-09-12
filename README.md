# Spring Boot Project with MySQL, Spring Data REST, and Layered Architecture

## Overview

This Spring Boot application demonstrates a layered architecture with controller, service, and repository layers. It integrates MySQL for database interactions, exposes data through Spring Data JPA, and includes exception handling, DTO mapping, and OAuth2 security.

## Features

- **Layered Architecture**: Organized into controller, service, and repository layers for clear separation of concerns.
- **Spring Data JPA**: Simplifies database access using repositories and entities.
- **Spring Data REST**: Automatically exposes CRUD operations for your entities through RESTful endpoints.
- **Exception Handling**: Global exception handling with custom error responses.
- **DTO Mapping**: Custom mappers for converting between entities and DTOs.
- **OAuth2 Security**: Secure your API endpoints using OAuth2 authentication and authorization.

## Technologies Used

- **Spring Boot**: Framework for building production-ready applications.
- **Spring Data JPA**: ORM framework for database interactions.
- **Spring Data REST**: Automatically exposes Spring Data repositories as REST endpoints.
- **Spring Security**: Security framework for authentication and authorization.
- **OAuth2**: Open standard for access delegation.
- **MySQL**: Relational database management system.

## Prerequisites

- Java 17 or later
- Maven
- MySQL Database Server
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/WalidChrif/employee-crud.git
cd your-repository
