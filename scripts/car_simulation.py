import requests
import time
import random

SERVER_URL = "http://localhost:8080/api/telemetry"

def calc_speed():
    return {"speed": random.randint(-50, 500)}

loop = True

while loop:
    print("##############################################################")
    generated_speed = calc_speed()
    print("Loop started. ")
    response = requests.post(url = SERVER_URL, json = generated_speed)
    print(f"Sending data {generated_speed} to {SERVER_URL}")
    print(f"Server response: {response.status_code}")
    print("##############################################################")

    if response.status_code in range(200, 300):
        print(f"Server successfully received Data ({generated_speed})")
    elif response.status_code in range(400, 500):
        print("Send wrong URL or bad Data.")
        break
    elif response.status_code in range(500, 600):
        print("Server Error.")
        break
    print("##############################################################")

    print("Going to sleep. ")
    time.sleep(2)
    print("Woke up. ")
    print("Repeat loop. ")
