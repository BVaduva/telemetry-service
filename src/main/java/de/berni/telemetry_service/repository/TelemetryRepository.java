package de.berni.telemetry_service.repository;

import de.berni.telemetry_service.model.TelemetryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelemetryRepository extends JpaRepository<TelemetryData, Long> {
    List<TelemetryData> findTelemetryDataBySpeedGreaterThan(double speed);
}