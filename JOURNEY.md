**Note on Learning Method:** 
This project was built with the help of Gemini's Guided Learning mode. 
This is an AI-powered tutoring approach based on [LearnLM](https://cloud.google.com/solutions/learnlm) that focuses on 
Socratic questioning and conceptual mastery rather than code generation.

**Personal specified constraints:** `Challenge me`, `Make me struggle`, `Java/Spring focus`, `Don't just write the code`.

## The Goal

This project acts as my personal challenge to learn about **Enterprise Java Architecture** and **Spring Boot**.

My goal here was not just to write code that works. I wanted to understand **standard industry practices** like 
strict typing, compilation, Dependency Injection(Spring Boot Style) and stateless REST APIs.


## Key Learnings & Challenges

* **Dependency Injection (IoC):** While I heavily used DI in my final exam project(CakePHP),
* **The "Magic" of Annotations:** Understanding how `@RestController` and `@PostMapping` handle web traffic without extra routing files.
* **Strict Typing vs. Duck Typing:** The discipline of defining data structures (DTOs) first, instead of passing loose dictionaries around.
* **Maven Lifecycle:** Moving from `pip install` to the structured Build/Compile/Run lifecycle of the JVM.
---

## Phase 1: Setup
### Java / Spring Boot
Using [start.spring.io](https://start.spring.io/) to create the project (Maven). 4 dependencies were recommended
by Gemini for this project:
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
