package edu.curtin.app.model;


import edu.curtin.app.observer.ObserverVehicle;


public class Bus implements ObserverVehicle {

    @Override
    public void update(Passenger passenger) {
        // Perform actions when a passenger's account status is updated
        // You can access passenger.getAccountStatus() to get the updated account status
        System.out.println("\n"+"Bus: Checking passenger account status for " + passenger.getName() + " " + passenger.getAccountStatus().getStatus());
    }

    @Override
    public String getVehicleKind() {
        // getting a vehicle name as a string
        return "bus";
    }
}