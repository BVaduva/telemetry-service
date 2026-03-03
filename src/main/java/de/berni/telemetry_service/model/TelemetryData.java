package de.user.telemetry_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TelemetryData {
    @Id
    @GeneratedValue
    private Long id;
    private double speed;
}
