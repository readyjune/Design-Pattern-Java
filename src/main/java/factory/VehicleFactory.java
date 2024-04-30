package edu.curtin.app.factory;

import edu.curtin.app.observer.ObserverVehicle;
import edu.curtin.app.model.Bus;
import edu.curtin.app.model.Train;

import java.util.logging.Level;
import java.util.logging.Logger;




public class VehicleFactory {
    private static final Logger LOGGER = Logger.getLogger(VehicleFactory.class.getName());

    public ObserverVehicle createObject(String type) {
        try {
            // the object is created as a hard code.
            // because I want to simplify the code as much as possible and try to show the pattern.
            // So this will create Train object
            if (type.equalsIgnoreCase("train")) {
                return new Train();
                //this will create bus object.
            } else if (type.equalsIgnoreCase("bus")) {
                return new Bus();
            } else {
                throw new IllegalArgumentException("Invalid vehicle type: " + type);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Failed to create vehicle object due to an invalid argument.", e);
            throw e;
        } 
    }
}
