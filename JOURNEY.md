**Note on Learning Method:** 
This project was built with the help of Gemini's Guided Learning mode. 
This is an AI-powered tutoring approach based on [LearnLM](https://cloud.google.com/solutions/learnlm) that focuses on 
Socratic questioning and conceptual mastery rather than code generation.

**Personal specified constraints:** `Challenge me`, `Make me struggle`, `Java/Spring focus`, `Don't just write the code`, `Be subtle with your hints`.

## The Goal

This project acts as my personal challenge to learn about **Enterprise Java Architecture** and **Spring Boot**.

I wanted to understand **standard industry practices** like 
strict typing, compilation, Dependency Injection(Spring Boot Style) and stateless REST APIs.


## Key Learnings & Challenges

* **Dependency Injection (IoC):** When it's different to PHP DI.
* **The "Magic" of Annotations:** Understanding how `@RestController` and `@PostMapping` handle web traffic without extra routing files.
* **Strict Typing vs. Duck Typing:** The discipline of defining data structures (DTOs) first, instead of passing loose dictionaries around.
* **Maven Lifecycle:** Moving from `pip install` to the structured Build/Compile/Run lifecycle of the JVM.
---

## Phase 1: Setup
### Java / Spring Boot
Using [start.spring.io](https://start.spring.io/) to create the project (Maven).</br> 
4 dependencies were recommended by Gemini for this project:
* **Spring Web:** REST API
* **Spring Data JPA:** Java to SQL translator
* **H2 Database:** In-memory database
* **Lombok:** Automatically generate common getters/setters etc.

### Python

Used a virtual environment (.venv) to manage dependencies like `requests` safely (respecting [PEP 668](https://peps.python.org/pep-0668/) on Fedora).

Created a small script (`request.post` random Data every 5 seconds) to test the project setup.

```bash
#Server output
Data Received! Speed: 143
Data Received! Speed: 151
Data Received! Speed: 23
Data Received! Speed: 34
```

```bash
#Script output + server response
##############################################################
Loop started. 
Sending data Speed: 126 to http://localhost:8080/api/telemetry
Server response: 200
##############################################################
Server successfully received Data (Speed: 126)
##############################################################
Going to sleep. 
Woke up. 
Repeat loop. 
```

## Phase 2: Architecture & Validation
Moved from simple "Hello World" to 3-tier architecture.

**Layered Architecture:** Refactored logic into a standard separation of concerns:
- **Controller:** Handles HTTP requests and response codes (`ResponseEntity`).
- **Service:** Contains business logic (validation) and is injected via Constructor Injection.
- **Model:** Created a `TelemetryData` DTO (Data Transfer Object) to enforce data structure.

**Data Serialization:** Upgraded from raw text to **JSON**.
- Configured Python `requests` to send dictionaries.
- Leveraged Spring's `Jackson `library to automatically map JSON to Java objects.

**Logic & Validation:** Implemented server-side validation to reject invalid sensor data (negative speed), 
returning HTTP 400 Bad Request to the client.

```bash
Loop started. 
Sending data {'speed': 34} to http://localhost:8080/api/telemetry
Server response: 200
##############################################################
Server successfully received Data ({'speed': 34})
##############################################################
Going to sleep. 
Woke up. 
Repeat loop. 
##############################################################
Loop started. 
Sending data {'speed': -32} to http://localhost:8080/api/telemetry
Server response: 400
##############################################################
Send wrong URL or bad Data.
```

## Phase 3: Technology Evaluation & Conclusion (PoC Completed)

After successfully building the core pipeline (Routing, DI, Data Validation), I decided to conclude this project as a Proof of Concept (PoC).

Why? An architectural realization.
While Spring Boot's "convention over configuration" and heavy use of annotations (@RestController, @Autowired) allow for rapid development, 
I found that it obscures the underlying control flow. The framework "magic" hides the actual wiring of the application.

As a developer who values explicit code execution, clear state management, and transparent data flow(which I heavily utilized in my Event-Driven GameDev architecture), 
the Spring Boot philosophy doesn't align perfectly with my preferred engineering style.

**Takeaway:**
This PoC was successful in its primary goal: It taught me the fundamentals of the JVM ecosystem, REST paradigms, and standard Enterprise patterns. 
However, moving forward, I am shifting my focus to the C#/.NET ecosystem. 
My goal is to leverage C#'s strong object-oriented features to build robust backend logic, while consciously managing framework abstractions rather than blindly relying on them.