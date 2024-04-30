package edu.curtin.app.dependencyinjection;

import edu.curtin.app.model.Passenger;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


//Dependency Injection

public class PassengerInteractionServiceImpl implements PassengerInteractionService {

    private static final Logger LOGGER = Logger.getLogger(PassengerInteractionServiceImpl.class.getName());
    
    @Override
    public void recordEntry(Passenger passenger, LocalDateTime entryTime) {
         // Storing entryTime information in passenger object
         passenger.setEntryTime(entryTime);
         //printing let us double check if we record the time for right person.
         System.out.println(passenger.getName() + " has entered the vehicle at " + entryTime);
         if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, passenger.getName() + " has entered the vehicle at " + entryTime);
         }
         
    }

    @Override
    public void recordExit(Passenger passenger, LocalDateTime exitTime) {
        // Storing entryTime information in passenger object
        passenger.setExitTime(exitTime);
        //printing let us double check if we record the time for right person.
        System.out.println(passenger.getName() + " has exited the vehicle at " + exitTime);
    }
}
