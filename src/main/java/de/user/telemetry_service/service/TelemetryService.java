package de.user.telemetry_service.service;

import de.user.telemetry_service.model.TelemetryData;
import de.user.telemetry_service.repository.TelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryService {
    private final TelemetryRepository repository;
    public TelemetryService(TelemetryRepository repository){this.repository = repository;}

    public Boolean ingestTelemetry(TelemetryData telemetryData) {
        double speed = telemetryData.getSpeed();
        if (speed >= 0.0 && speed <= 400.0) {
            System.out.println("Data Received! " + speed + " Test");
            this.repository.save(telemetryData);
            System.out.println("Database now has " + this.repository.count() + " entries!");
            return true;
        }
        else {
            System.out.println("Bad Data.");
            System.out.println(this.getAllTelemetryData());
            // ArrayList<TelemetryData> data = (ArrayList<TelemetryData>) this.getAllTelemetryData();
            // System.out.print(data);
            return false;
        }
    }

    public List<TelemetryData> getAllTelemetryData(){
        return this.repository.findAll();
    }

    public List<TelemetryData> getFilteredTelemetryData(){
        return this.repository.findTelemetryDataBySpeedGreaterThan(double speed);
    }
}
