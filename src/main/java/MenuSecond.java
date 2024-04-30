package edu.curtin.app;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.curtin.app.factory.VehicleFactory;
import edu.curtin.app.model.Passenger;
import edu.curtin.app.model.PassengerManager;
import edu.curtin.app.observer.ObserverVehicle;

public class MenuSecond {
    private static final Logger LOGGER = Logger.getLogger(MenuSecond.class.getName());

    public static void selectUser(int secondInput, Passenger passenger, PassengerManager passengerManager, VehicleFactory vehicleFactory, ObserverVehicle bus, ObserverVehicle train) {
        try {
            if (secondInput == 1) {
                //This will print detail of passenger's information
                passenger.displayPassengerDetails(passenger);
            } else if (secondInput == 2) {
                // This let passenger ride a bus and deduct the money
                passengerManager.passengerRidesVehicle(passenger, bus);
            } else if (secondInput == 3) {
                // This let passenger ride a train and deduct the money
                passengerManager.passengerRidesVehicle(passenger, train);
            } else if (secondInput == 4) {
                // This let passenger get off the bus only when passenger is on board from bus
                passengerManager.passengerGetOffVehicle(passenger, bus);
            } else if (secondInput == 5) {
                // This let passenger get off the train only when passenger is on board from train
                passengerManager.passengerGetOffVehicle(passenger, train);
            } else if (secondInput == 6) {
                // This let passenger recharge their money and after changing it will change passenger's status
                System.out.println("+4 will be recharged to your account.");
               
                passengerManager.rechargeSaving(passenger);

                
            } else {
                System.out.println("Invalid input. Please select a number between 1 and 5.");
                if (LOGGER.isLoggable(Level.WARNING)) {
                    LOGGER.log(Level.WARNING, "Invalid input: " + secondInput);
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input mismatch");
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.log(Level.WARNING, "Input mismatch: " + secondInput, e);
            }
            
        } 
    }
}
