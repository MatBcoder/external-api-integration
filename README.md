# External API Integration with Java Spring Boot

## Overview

This project explores how to connect a Java Spring Boot REST API to external REST APIs.

The goal is to understand how external API communication works, including sending HTTP requests, receiving responses, converting JSON into Java objects, passing request parameters, sending data, and handling API authentication.

The project uses public APIs to practise real-world integration concepts without having to build or maintain the external services ourselves.

## Technologies Used

- Java 25
- Spring Boot
- Spring Web
- Maven
- RestClient
- Jackson
- Postman

## External APIs

### 1. JSONPlaceholder

JSONPlaceholder is a free fake REST API that provides sample data for development and testing.

It is used to practise retrieving data and sending requests to an external API.

Documentation: [https://jsonplaceholder.typicode.com/guide/](https://jsonplaceholder.typicode.com/guide/)

### 2. DummyJSON

DummyJSON provides sample REST API endpoints, including authentication functionality.

It is used to practise API authentication, access tokens and HTTP Authorization headers.

Documentation: [https://dummyjson.com/docs](https://dummyjson.com/docs)

##

## Implemented Features

### JSONPlaceholder Integration

| HTTP Method | Endpoint                          | Description                                 |
| ----------- | --------------------------------- | ------------------------------------------- |
| GET         | `/api/external/users`             | Retrieve all users                          |
| GET         | `/api/external/users/{id}`        | Retrieve a specific user                    |
| GET         | `/api/external/posts?userId={id}` | Retrieve posts belonging to a specific user |
| POST        | `/api/external/posts`             | Create a post                               |

### DummyJSON Integration

| HTTP Method | Endpoint                   | Description                                              |
| ----------- | -------------------------- | -------------------------------------------------------- |
| POST        | `/api/external/auth/login` | Authenticate with DummyJSON and retrieve an access token |
| GET         | `/api/external/auth/me`    | Retrieve the authenticated user's details                |

## Key Concepts Covered

- Connecting Java applications to external REST APIs.
- Using Spring RestClient to send HTTP requests.
- Understanding GET and POST requests.
- Working with path variables and query parameters.
- Sending JSON request bodies.
- Receiving and deserializing JSON responses.
- Using DTOs to represent external API data.
- Configuring and reusing RestClient instances.
- Understanding HTTP headers.
- API authentication using Bearer tokens.

## Future Learning Objectives

The following topics will be explored as the project develops:

- Handling external API errors and HTTP status codes.
- Implementing PUT and DELETE requests.
- Working with different response structures.
- Handling API rate limits.
- Configuring connection and response timeouts.
- Managing external API credentials securely.
- Understanding pagination when working with external APIs.
- Exploring more advanced RestClient capabilities.

## Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Ensure Java 25 is configured.
4. Allow Maven to download the project dependencies.
5. Run `ExternalApiIntegrationApplication.java`.
6. Use Postman to test the endpoints.

The application runs locally at:

`http://localhost:8080`

## Project Purpose

This is a practical learning project focused on understanding external API integration using Java and Spring Boot.

The emphasis is on understanding the underlying concepts and implementing them progressively before introducing more advanced abstractions or additional dependencies.
