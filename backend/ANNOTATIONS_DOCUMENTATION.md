# Spring Annotations Documentation - MovieTix Backend

This document provides a comprehensive overview of all Spring annotations used in the MovieTix backend microservices project, their purposes, and the consequences of their removal.

## Table of Contents
1. [Core Spring Framework Annotations](#core-spring-framework-annotations)
2. [Spring Boot Annotations](#spring-boot-annotations)
3. [Spring Web MVC Annotations](#spring-web-mvc-annotations)
4. [Spring Data JPA Annotations](#spring-data-jpa-annotations)
5. [Spring Security Annotations](#spring-security-annotations)
6. [Spring Cloud Annotations](#spring-cloud-annotations)
7. [Bean Validation Annotations](#bean-validation-annotations)
8. [Lombok Annotations](#lombok-annotations)
9. [OpenAPI/Swagger Annotations](#openapi-swagger-annotations)
10. [JPA/Hibernate Annotations](#jpa-hibernate-annotations)

---

## Core Spring Framework Annotations

### @Component
**Purpose:** Marks a class as a Spring-managed component, making it eligible for dependency injection.

**What happens if removed:** 
- The class will not be registered as a Spring bean
- Dependency injection will fail
- Other components cannot autowire this class

### @Service
**Purpose:** Specialization of @Component that indicates the class contains business logic.

**Used in:**
- `UserService.java`
- `MovieService.java`
- `TheaterService.java`
- `BookingService.java`
- `JwtService.java`

**What happens if removed:**
- Class won't be recognized as a Spring service bean
- Business logic layer won't be available for dependency injection
- Application context will fail to wire dependent beans

### @Repository
**Purpose:** Specialization of @Component for data access layer, provides exception translation.

**Used in:**
- `UserRepository.java`
- `MovieRepository.java`
- `TheaterRepository.java`
- `BookingRepository.java`

**What happens if removed:**
- Repository won't be managed by Spring
- No automatic exception translation from database exceptions to Spring exceptions
- Dependency injection of repositories will fail

### @Configuration
**Purpose:** Indicates that a class contains bean definitions and configuration.

**Used in:**
- `SecurityConfig.java`
- `JpaConfig.java`

**What happens if removed:**
- Configuration class won't be processed by Spring
- Bean definitions inside the class won't be registered
- Application configuration will be incomplete

### @Bean
**Purpose:** Indicates that a method produces a bean to be managed by Spring container.

**Used in:**
- `SecurityConfig.java` (for PasswordEncoder, SecurityFilterChain)

**What happens if removed:**
- Method won't create a Spring-managed bean
- Other components cannot autowire the returned object
- Application may fail to start due to missing bean dependencies

---

## Spring Boot Annotations

### @SpringBootApplication
**Purpose:** Convenience annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.

**Used in:**
- All main application classes (UserServiceApplication, MovieServiceApplication, etc.)

**What happens if removed:**
- Spring Boot auto-configuration won't work
- Component scanning won't occur
- Application won't start properly
- Need to manually configure all three annotations separately

### @Value
**Purpose:** Injects values from properties files into fields.

**Used in:**
- `JwtService.java` for JWT secret and expiration values

**What happens if removed:**
- Property values won't be injected
- Fields will have default/null values
- Application behavior may be incorrect

---

## Spring Web MVC Annotations

### @RestController
**Purpose:** Combines @Controller and @ResponseBody, indicating REST API controller.

**Used in:**
- `AuthController.java`
- `UserController.java`
- `MovieController.java`
- `AdminMovieController.java`
- `TheaterController.java`
- `AdminTheaterController.java`
- `ShowtimeController.java`
- `AdminShowtimeController.java`
- `BookingController.java`

**What happens if removed:**
- Class won't be recognized as a web controller
- HTTP endpoints won't be accessible
- REST API functionality will be lost

### @RequestMapping
**Purpose:** Maps HTTP requests to handler methods or classes.

**Used in:**
- All controller classes to define base paths

**What happens if removed:**
- Controller won't have a base URL mapping
- Endpoints may conflict or become inaccessible
- URL structure will be broken

### @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
**Purpose:** Specialized versions of @RequestMapping for specific HTTP methods.

**Used extensively across all controllers**

**What happens if removed:**
- Specific HTTP endpoints won't be accessible
- REST API operations will fail
- Client applications won't be able to communicate with endpoints

### @RequestBody
**Purpose:** Binds HTTP request body to method parameters.

**What happens if removed:**
- Request body won't be deserialized to Java objects
- API methods won't receive data from clients
- POST/PUT operations will fail

### @PathVariable
**Purpose:** Extracts values from URI path segments.

**What happens if removed:**
- Path parameters won't be extracted
- Methods requiring resource IDs will fail
- RESTful URL patterns won't work

### @RequestParam
**Purpose:** Extracts query parameters from HTTP requests.

**What happens if removed:**
- Query parameters won't be accessible
- Methods requiring optional parameters will fail
- API flexibility will be reduced

### @RequestHeader
**Purpose:** Extracts HTTP header values.

**Used in:**
- `UserController.java` for X-User-Id header

**What happens if removed:**
- Header values won't be accessible
- Authentication/authorization information may be lost
- Cross-service communication may fail

---

## Spring Data JPA Annotations

### @Transactional
**Purpose:** Defines transaction boundaries for methods or classes.

**Used in:**
- All service classes
- Specific methods requiring different transaction settings

**What happens if removed:**
- Operations won't be wrapped in database transactions
- Data consistency issues may occur
- Rollback functionality will be lost
- Database integrity may be compromised

### @EnableJpaAuditing
**Purpose:** Enables JPA auditing functionality.

**Used in:**
- `JpaConfig.java` classes
- Main application classes

**What happens if removed:**
- Automatic auditing (created/updated timestamps) won't work
- @CreatedDate and @LastModifiedDate annotations will be ignored
- Audit trail functionality will be lost

---

## Spring Security Annotations

### @EnableWebSecurity
**Purpose:** Enables Spring Security configuration.

**Used in:**
- `SecurityConfig.java`

**What happens if removed:**
- Spring Security won't be configured
- Custom security settings won't be applied
- Default security behavior may not meet requirements

### @EnableMethodSecurity
**Purpose:** Enables method-level security annotations.

**What happens if removed:**
- @PreAuthorize and similar annotations won't work
- Method-level security will be disabled
- Fine-grained access control will be lost

### @PreAuthorize
**Purpose:** Provides method-level authorization.

**Used in:**
- `UserController.java` for admin operations

**What happens if removed:**
- Method-level authorization checks won't occur
- Unauthorized users may access protected methods
- Security vulnerabilities may be introduced

### @SecurityRequirement
**Purpose:** OpenAPI annotation for documenting security requirements.

**What happens if removed:**
- API documentation won't show security requirements
- Developers may not understand authentication needs
- Documentation will be incomplete

---

## Spring Cloud Annotations

### @EnableEurekaServer
**Purpose:** Enables Eureka service registry server.

**Used in:**
- `EurekaServerApplication.java`

**What happens if removed:**
- Service discovery server won't start
- Microservices won't be able to register/discover each other
- Service communication will fail

### @EnableConfigServer
**Purpose:** Enables Spring Cloud Config Server.

**Used in:**
- `ConfigServerApplication.java`

**What happens if removed:**
- Centralized configuration server won't work
- Services won't be able to fetch external configuration
- Configuration management will be decentralized

### @EnableFeignClients
**Purpose:** Enables Feign declarative REST clients.

**Used in:**
- `BookingServiceApplication.java`
- `ShowtimeServiceApplication.java`

**What happens if removed:**
- Feign clients won't be processed
- Inter-service communication will fail
- Manual HTTP client implementation required

### @FeignClient
**Purpose:** Declares a Feign client interface.

**Used in:**
- `ShowtimeServiceClient.java`
- `UserServiceClient.java`
- `MovieServiceClient.java`
- `TheaterServiceClient.java`

**What happens if removed:**
- Declarative REST client won't work
- Manual HTTP calls required
- Inter-service communication complexity increases

---

## Bean Validation Annotations

### @Valid
**Purpose:** Triggers validation on method parameters or return values.

**What happens if removed:**
- Input validation won't occur automatically
- Invalid data may be processed
- Data integrity issues may arise

### @NotBlank
**Purpose:** Validates that a string is not null and not empty.

**What happens if removed:**
- Empty/blank values will be accepted
- Data quality may deteriorate
- Business logic may fail with invalid inputs

### @NotNull
**Purpose:** Validates that a value is not null.

**What happens if removed:**
- Null values will be accepted
- NullPointerExceptions may occur
- Application stability may be compromised

### @Email
**Purpose:** Validates email format.

**What happens if removed:**
- Invalid email formats will be accepted
- Email functionality may fail
- User communication issues may occur

### @Size
**Purpose:** Validates string length or collection size.

**What happens if removed:**
- Length constraints won't be enforced
- Database constraints may be violated
- Inconsistent data may be stored

### @Positive
**Purpose:** Validates that a number is positive.

**What happens if removed:**
- Negative values will be accepted
- Business logic may fail with invalid inputs
- Data consistency issues may occur

---

## Lombok Annotations

### @Data
**Purpose:** Generates getters, setters, toString, equals, and hashCode methods.

**What happens if removed:**
- Need to manually implement all getter/setter methods
- Code becomes much more verbose
- Maintenance overhead increases significantly

### @NoArgsConstructor
**Purpose:** Generates a no-argument constructor.

**What happens if removed:**
- JPA entities may fail to instantiate
- Framework reflection may break
- Serialization/deserialization may fail

### @AllArgsConstructor
**Purpose:** Generates constructor with all fields as parameters.

**What happens if removed:**
- Need to manually create constructors
- Builder pattern may break
- Object creation becomes more complex

### @RequiredArgsConstructor
**Purpose:** Generates constructor for final fields and fields with constraints.

**What happens if removed:**
- Dependency injection may fail
- Final fields won't be initialized
- Need manual constructor implementation

### @Builder
**Purpose:** Generates builder pattern implementation.

**What happens if removed:**
- Object creation becomes less fluent
- Need manual builder implementation
- Code readability decreases

### @Slf4j
**Purpose:** Generates SLF4J logger field.

**What happens if removed:**
- Need manual logger field declaration
- Logging statements may fail
- Debugging becomes more difficult

---

## OpenAPI/Swagger Annotations

### @Tag
**Purpose:** Groups operations in OpenAPI documentation.

**What happens if removed:**
- API documentation won't be properly grouped
- API documentation becomes less organized
- Developer experience may suffer

### @Operation
**Purpose:** Describes an API operation in documentation.

**What happens if removed:**
- API endpoints won't have descriptions
- API documentation becomes less informative
- Integration becomes more difficult

---

## JPA/Hibernate Annotations

### @Entity
**Purpose:** Marks a class as a JPA entity.

**What happens if removed:**
- Class won't be persisted to database
- ORM mapping will fail
- Database operations won't work

### @Table
**Purpose:** Specifies database table details.

**What happens if removed:**
- Default table naming will be used
- Custom table configurations will be lost
- Database schema may not match expectations

### @Id
**Purpose:** Marks the primary key field.

**What happens if removed:**
- Entity won't have a primary key
- Database operations will fail
- JPA will throw exceptions

### @GeneratedValue
**Purpose:** Specifies primary key generation strategy.

**What happens if removed:**
- Primary keys won't be auto-generated
- Manual key management required
- Potential key conflicts may occur

### @Column
**Purpose:** Specifies column mapping and constraints.

**What happens if removed:**
- Default column mapping will be used
- Database constraints may be lost
- Data integrity may be compromised

### @Enumerated
**Purpose:** Specifies how enum values are persisted.

**What happens if removed:**
- Enum values may be persisted incorrectly
- Database queries may fail
- Data consistency issues may occur

### @CreatedDate, @LastModifiedDate
**Purpose:** Automatically populate audit timestamps.

**What happens if removed:**
- Audit timestamps won't be automatically managed
- Manual timestamp management required
- Audit trail functionality will be lost

### @EntityListeners
**Purpose:** Specifies callback listener classes.

**What happens if removed:**
- JPA auditing won't work
- Lifecycle callbacks won't be triggered
- Audit functionality will be disabled

---

## Global Exception Handling Annotations

### @RestControllerAdvice
**Purpose:** Global exception handling for REST controllers.

**Used in:**
- `GlobalExceptionHandler.java` classes across services

**What happens if removed:**
- Global exception handling won't work
- Unhandled exceptions will return generic error responses
- API error responses become inconsistent

### @ExceptionHandler
**Purpose:** Handles specific exception types.

**What happens if removed:**
- Specific exceptions won't be handled gracefully
- Generic error responses will be returned
- User experience may deteriorate

---

## Summary

The annotations in this Spring Boot microservices project serve critical functions:

1. **Infrastructure**: Enable core Spring functionality, dependency injection, and service discovery
2. **Web Layer**: Define REST endpoints and handle HTTP requests/responses
3. **Data Layer**: Manage database operations and transactions
4. **Security**: Implement authentication and authorization
5. **Validation**: Ensure data integrity and quality
6. **Documentation**: Generate API documentation
7. **Code Quality**: Reduce boilerplate code and improve maintainability

Removing any of these annotations would significantly impact the application's functionality, requiring manual implementation of the features they provide or causing the application to fail entirely. The annotations work together to create a cohesive, well-structured microservices architecture that follows Spring Boot best practices.