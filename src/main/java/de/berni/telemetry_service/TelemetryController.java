package de.berni.telemetry_service;

import de.berni.telemetry_service.service.TelemetryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class TelemetryController {
    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService){
        this.telemetryService = telemetryService;
    }

    @PostMapping("/telemetry")
    public void callTelemetry(@RequestBody String telemetryData){
        this.telemetryService.ingestTelemetry(telemetryData);
    }

}