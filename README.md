# IoT Telemetry Service (Java/Spring Boot Learning Project)

Read about my Learning Journey & Challenges here: [JOURNEY.md](JOURNEY.md)

## Architecture

I built a simulation of a connected car system. It sends real-time telemetry data to a cloud backend.

* **Client (The "Car"):** A Python script (`/scripts`) that creates fake sensor data (Speed, Battery) and sends it via HTTP.
* **Server (The Backend):** A Spring Boot 3 application (Java 17) that receives and processes the stream.

## Tech Stack & Tools

* **Language:** Java 17 (Temurin Distribution)
* **Framework:** Spring Boot 3 (Web MVC)
* **Build Tool:** Maven (mvnw wrapper)
* **Simulation:** Python 3 + `requests` (running in a local `.venv`)
* **Environment:** Fedora Linux (Zsh, strict environment variable management)

## How to Run

### 1. Start the Backend

```bash
# Uses the Maven Wrapper (no global install needed)
./mvnw spring-boot:run
```

### 2. Start the Car Simulation

```bash
# Set up the Python virtual environment
python3 -m venv .venv
source .venv/bin/activate
pip install requests

# Send simulated data to the server
python3 scripts/car_simulation.py
```