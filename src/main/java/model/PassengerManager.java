package edu.curtin.app.model;

import edu.curtin.app.observer.ObserverVehicle;
import edu.curtin.app.dependencyinjection.PassengerInteractionService;
import edu.curtin.app.dependencyinjection.PassengerInteractionServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class PassengerManager {
    private static final Logger LOGGER = Logger.getLogger(PassengerManager.class.getName());

    // this is for storing passenger information
    private List<Passenger> passengers;
    // this is for storing vehicle information
    private List<ObserverVehicle> observers;
    // this is for dependency injection
    private PassengerInteractionService passengerInteractionService = new PassengerInteractionServiceImpl();
   

    public PassengerManager() {
        passengers = new ArrayList<>();
        observers = new ArrayList<>();
       
    }
    // adding vehicle in the list for observer
    public void attach(ObserverVehicle observer) {
        observers.add(observer);
    }
    // removing vehicle in the list
    public void detach(ObserverVehicle observer) {
        observers.remove(observer);
    }

    // adding passenger in the list
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
  
    }

    // this is for checking passenger's account status after passenger gets on the vehicle
    public void notifyObservers(Passenger passenger) {
        for (ObserverVehicle observer : observers) {
            observer.update(passenger);
        }
    }

    // this method is for checking passenger's account status before passenger gets on the vehicle
    // and after getting on board, this will deduct passenger's account saving 3 and then update accountStatus
    public void passengerRidesVehicle(Passenger passenger, ObserverVehicle vehicle) {

        // Perform necessary operations for passenger riding a vehicle
        // For example, deduct the fare from the passenger's account
        int fare = 3; // Fare amount to deduct

        if (passenger.getOnBoard() == false) {
                
             // Check if the passenger has enough balance in their account at least not 0 or not cancelled status.
            // if (passenger.getAccountStatus().getStatus() != "Cancelled") {
             if("Good Standing".equals(passenger.getAccountStatus().getStatus()) || "In Debt".equals(passenger.getAccountStatus().getStatus())) {
                
                // Deduct the fare from the passenger's account balance
                int updatedBalance = passenger.getAccountSaving() - fare;
                passenger.setAccountSaving(updatedBalance);

                // setting which vehicle(bus or train) passenger is currently on
                passenger.setVehicleKind(vehicle.getVehicleKind());

                System.out.println("\n"+passenger.getName() + " is on board now");
                if (LOGGER.isLoggable(Level.INFO)) {

                    LOGGER.log(Level.INFO, passenger.getName() + " is on board now");
                }
                
                passenger.setOnBoard(true);
    
                // Notify the passenger about the fare deduction
                System.out.println("Fare of $" + fare + " deducted from "+ passenger.getName() + "'s account.");
                if (LOGGER.isLoggable(Level.INFO)) {
                    // Notify the passenger about the fare deduction
                    LOGGER.log(Level.INFO, "Fare of $" + fare + " deducted from " + passenger.getName() + "'s account.");
                }
                
                

                // Notify the passenger current account balance
                System.out.println("Current "+ passenger.getName() +" account balance is $" + passenger.getAccountSaving());

                 // Record the current time as the entry time
                LocalDateTime entryTime = LocalDateTime.now();
                // Record the entry time
                passengerInteractionService.recordEntry(passenger, entryTime);
           

            
    
                // Notify the observers (vehicles) about the passenger's status change
                System.out.println("\nthis is notifying the vehicle observer that passenger's status.");
                if (LOGGER.isLoggable(Level.INFO)) {
                    // Notify the observers (vehicles) about the passenger's status change
                    LOGGER.log(Level.INFO, "Notifying the vehicle observer about the passenger's status.");
                }
                
                notifyObservers(passenger);


                
            } else {
                // If the passenger doesn't have enough balance, handle the scenario accordingly
                System.out.println("Please top up before riding.");
                if (LOGGER.isLoggable(Level.WARNING)) {
                    LOGGER.log(Level.WARNING, "Please top up before riding.");
                }    

                
                 
                
            }
        }
        else {
            System.out.println("Passenger is already on board");
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.log(Level.WARNING, "Passenger is already on board");
            }    
            
        
        }

    }

    // this method is for when passenger gets off the vehicle.
    // this will change current passenger's onBoard status to false.
    // and also change vehicle kind to null because passenger is not on the vehicle anymore.
    public void passengerGetOffVehicle(Passenger passenger, ObserverVehicle vehicle) {
        //when passenger is on board.
        if (passenger.getOnBoard() == true) {
            if(passenger.getVehicleKind().equals(vehicle.getVehicleKind())) {
 
                System.out.println(passenger.getName() + " gets off the vehicle");
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, passenger.getName() + " gets off the vehicle");
                }    
                
                passenger.setOnBoard(false);
                passenger.setVehicleKind(null);
                // Record the current time as the entry time
                LocalDateTime entryTime = LocalDateTime.now();
                // Record exit time
                passengerInteractionService.recordExit(passenger, entryTime);
                
            }
            //printing when user is trying to get off from different vehicle
            else {
                System.out.println("You can't get off from different vehicle");
            }
        }

        else {
            System.out.println("passenger is not on board");
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.log(Level.WARNING, "Passenger is not on board");
            }
        }

    }

    // I set this method as you can only recharge +4 everytimes.
    // I can make scanner and get input from user but I think it's better to set as +4 so that we can check the program easily.
    // and also we can check accountStatus Cancelled->InDebt->GoodStanding in a row.
    // this method is for recharging passenger's account.
    
    public void rechargeSaving(Passenger passenger) {    
        int inputAmount = 4;

        // Perform necessary operations for recharging the passenger's account
        passenger.setAccountSaving(passenger.getAccountSaving() + inputAmount);
        System.out.println("\n" + passenger.getName() + "'s account has been recharged with $" + inputAmount);
        System.out.println("\n" + passenger.getName() + "'s current account balance is $" + passenger.getAccountSaving());
        notifyObservers(passenger);
 
      
    }
    

}
