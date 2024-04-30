package edu.curtin.app.dependencyinjection;

import edu.curtin.app.model.Passenger;
import java.time.LocalDateTime;

// for dependency injection
public interface PassengerInteractionService {
    void recordEntry(Passenger passenger, LocalDateTime entryTime);
    void recordExit(Passenger passenger, LocalDateTime exitTime);
}
