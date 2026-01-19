package de.berni.telemetry_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TelemetryService {

    public String ingestTelemetry(String telemetryData) {
        System.out.println("Data Received! " + telemetryData);
        return telemetryData;
    }
}
