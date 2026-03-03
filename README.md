# IoT Telemetry Ingestion Service (PoC)

![Java](https://img.shields.io/badge/Java-17_LTS-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Framework-Spring_Boot_3-green?logo=springboot)
![Status](https://img.shields.io/badge/Status-Completed_PoC-blue)

> **Project Goal:** A technical Proof of Concept (PoC) to evaluate Spring Boot 3 for high-performance IoT data ingestion. The core pipeline (Producer -> REST -> Validation) was successfully implemented to assess the framework's architecture.
>
> 📖 **Read about my learning process, the implemented architecture, and why I ultimately concluded this PoC in the [JOURNEY.md](JOURNEY.md).**

## 🏗️ System Architecture
The system simulates a complete IoT data pipeline, decoupled into a Producer (Client) and Consumer (Server).<br/>
*(**Note:** Core logic is implemented and runnable. Extended database routing was scoped out after the PoC evaluation).*

* **Client ("The Car"):** A Python-based simulation engine that generates fluctuating sensor data (Speed, RPM, Battery Level) and streams it via HTTP POST.
* **Server (The Backend):** A Spring Boot 3 REST API designed to receive, validate, and process the incoming telemetry stream.

## Tech Stack

* **Core:** Java 17 (Temurin)
* **Framework:** Spring Boot 3 (Web MVC)
* **Build Automation:** Maven (Wrapper included)
* **Simulation Client:** Python 3 + `requests`
* **Environment:** Developed on Fedora Linux (Zsh)

## How to Run

### 1. Start the Backend Service
The project uses the Maven Wrapper, so no global Maven installation is required.
```bash
./mvnw spring-boot:run
```

### 2. Launch the Car Simulation

Simulate a driving vehicle sending live data:
```Bash

# Setup Python Environment
python3 -m venv .venv
source .venv/bin/activate
pip install requests

# Start Telemetry Stream
python3 scripts/car_simulation.py
```
