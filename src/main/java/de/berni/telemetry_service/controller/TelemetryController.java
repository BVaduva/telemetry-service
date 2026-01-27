package de.berni.telemetry_service.controller;

import de.berni.telemetry_service.model.TelemetryData;
import de.berni.telemetry_service.service.TelemetryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TelemetryController {
    private final TelemetryService telemetryService;
    public TelemetryController(TelemetryService telemetryService){
        this.telemetryService = telemetryService;
    }

    @PostMapping("/telemetry")
    public ResponseEntity<Void> callTelemetry(@RequestBody TelemetryData telemetryData){
        boolean response = this.telemetryService.ingestTelemetry(telemetryData);

        if (response) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/telemetry")
    public List<TelemetryData> listAllTeleDataAsJson() {
        return this.telemetryService.getAllTelemetryData();
    }

    public List<TelemetryData> listFilteredTeleDataAsJson(@RequestParam TelemetryData telemetryData) {
        return this.telemetryService.getFilteredTelemetryData();
    }
}