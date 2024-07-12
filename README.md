# Video store technical assesment

## Overview

This project is a simple Spring Boot application that uses an H2 in-memory database. It includes a `data.sql` file for initial data loading. The project currently contains a basic class and hierarchy, which serves as a starting point for further development.

## Project Structure

- **src/main/java**: Contains the Java source files.
    - `tv.alphanetworks.traning`: The base package for the project.
        - `VideoStoreApplication.java`: The main application class.
        - `controller`: Package for REST controllers.
        - `service`: Package for service layer classes.
        - `repository`: Package for repository interfaces.
        - `model`: Package for entity classes.
        - `configuration`: Package for configuration class.
- **src/main/resources**: Contains the application properties and initial data script.
    - `application.yaml`: Configuration file for Spring Boot.
    - `data.sql`: SQL script to load initial data into the H2 database.

## Getting Started

### Prerequisites

- JDK 21
- Maven

### Setup

1. **Clone the repository**

    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```

2. **Build the project**

   Using Maven:

    ```bash
    mvn clean install
    ```

3. **Run the application**

   Using Maven:

    ```bash
    mvn spring-boot:run
    ```

### Configuration

The application is configured to use an H2 in-memory database. You can find the configuration in the `application.yaml` file:

```properties
spring:
  application:
    name: "video_store"
  datasource:
    url: jdbc:h2:mem:video_store
    driver-class-name: org.h2.Driver
    username: h2
    password: password
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    defer-datasource-initialization: true

custom:
  max_duration: 14
  vat : 21.0d
```

### Assessment


