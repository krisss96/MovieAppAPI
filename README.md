# MovieApp API

Welcome to the backend repository for the MovieApp API—a robust, mood-centric film discovery and management REST API built with Java and Spring Boot. This application allows users to find, categorize, and track movies based on specific moods, feelings, and available streaming platforms, as well as manage personalized watchlists.

# Important Note
This repository is intended for backend development. The application can be found here: [MovieApp Frontend](https://github.com/krisss96/movie_vibe_app). 
# Tech Stack

- Backend Framework: Java 17+ / Spring Boot
- Data Access: Spring Data JPA (Hibernate)
- Build Tool: Maven (Wrapper included)
- Database Management: SQL (Initialization scripts included)
- API Architecture: RESTful API with Mapper-DTO patterns
- Testing & Documentation: Postman Collections

# Project Structure

The project follows a standard N-Tier architecture pattern, keeping concerns cleanly separated between the presentation, service, and data layers:
```
MovieAppAPI/
│
├── .mvn/                            # Maven wrapper files
├── postman/                         # Postman collections & environment files
│   ├── MoviesAPI.postman_collection.json
│   └── MoviesAPI.postman_environment.json
│
├── src/main/java/
│   └── app/project/MoviesAPI/
│       ├── MoviesApiApplication.java # Application Entry Point
│       ├── Entity/                  # Database Domain Models (Movie, Mood, Feeling, etc.)
│       ├── Repository/              # Spring Data JPA Repositories
│       ├── Service/                 # Business Logic Interfaces & Implementations
│       ├── Mapper/                  # Entity-to-DTO structural mappers
│       └── Controller/              # REST Controllers and API Endpoint Resources
│
├── src/main/resources/
│   ├── static/images/               # Static image assets for the frontend
│   │   ├── heroes/                  # Movie background/hero cards
│   │   └── moods/                   # Mood/Feeling contextual icons
│   └── application.properties       # Core application configurations
│
└── pom.xml                          # Maven dependencies file
```
# Key Features & Modules

## 1. Movie Management
Tracks cinematic properties including titles, genres, and associated data, supported by high-quality static hero image resources (e.g., 500 Days of Summer, Dead Poets Society, The Perks of Being a Wallflower).

## 2. Mood & Feeling Categorization
The core differentiator of the platform. Enables dynamic matching of films to complex emotional spaces (e.g., bittersweet) and basic emotional filters to match how a user currently feels.

## 3. Streaming Platform Integration
Maps which movies are hosted on which specific provider platforms (Netflix, HBO Max, Disney+, etc.), making it easy for users to know where to watch.

## 4. Custom User Watchlists
Provides endpoints for creating, updating, and personalizing dynamic lists of movies targeted for future viewing.

# Getting Started

Prerequisites

- Java Development Kit (```JDK 17 or higher```)
- A relational database engine (```MySQL``` / ```PostgreSQL```)
- Maven (or use the provided ```./mvnw wrapper```)

## Configuration
Update the database connection details in ```src/main/resources/application.properties```:
```
spring.datasource.url=jdbc:your-database-url-here
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

# Running the Application

Run the Spring Boot application using the Maven wrapper:

- On macOS/Linux:
```./mvnw spring-boot:run```

- On Windows:
```mvnw.cmd spring-boot:run```

# Testing the API

A complete environment setup is pre-packaged for quick verification:

Import the Postman collection located in the ```/postman``` directory:
```MoviesAPI.postman_collection.json```

Import the companion environment file to handle base URLs effortlessly:
```MoviesAPI.postman_environment.json```

Spin up the application locally and start triggering the predefined endpoints for Movies, Moods, Watchlists, etc.