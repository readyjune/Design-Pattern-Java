package edu.curtin.app.model;

import java.time.LocalDateTime;

import edu.curtin.app.state.GoodStandingStatus;
import edu.curtin.app.state.PassengerAccountStatus;

public class Passenger {
    
    private String name;
    private PassengerAccountStatus accountStatus;
    private int accountSaving;
    private boolean onBoard;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String vehicleKind;


    public Passenger(String name, int accountSaving, boolean onBoard) {
        this.name = name;
        this.accountSaving = accountSaving;
        this.onBoard = onBoard;
        this.accountStatus = new GoodStandingStatus();
    }
    
    // getting passenger name for printing
    public String getName() {
        return name;
    }

    // gettting accountSaving which is how much passenger has in account
    public int getAccountSaving() {
        return accountSaving;
    }

    // setting accountSaving after recharging
    public void setAccountSaving(int accountSaving) {
        this.accountSaving = accountSaving;
        accountStatus.checkAccountStatus(this);
    }
    
    // this is for checking if customer is on the vehicle or no
    public boolean getOnBoard() {
        return onBoard;
    }

    // after customer's on the board, this method will be executed
    public void setOnBoard(boolean setBoard) {
        this.onBoard = setBoard;
        
    }

    // this is checking passenger current account status
    public PassengerAccountStatus getAccountStatus() {
        return accountStatus;
    }

    // this is for State pattern and it will be changing depend on customer's accountSaving
    public void setAccountStatus(PassengerAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    // this method will be executed to access when does passenger get on the vehicle
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    // this method will be executed after pasenger get ob the vehicle
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    // this method will be executed for getting a exit time
    public LocalDateTime getExitTime() {
        return exitTime;
    }

    // this method will be executed after pasenger get off the vehicle
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    // this is for checking if passenger get on the right vehicle (bus or train)
    public String getVehicleKind() {
        return vehicleKind;
    }

    // after getting on the vehilce we can set vehicle kind (bus or train) so that when we print detail of pasenger,
    // we can see which vehicle passenger is currently on.
    public void setVehicleKind(String vehicle) {
        this.vehicleKind = vehicle;
    }


    // displaying passenger details
    public void displayPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Account Saving: " + passenger.getAccountSaving());
        System.out.println("Account Status: " + passenger.getAccountStatus().getStatus());
        System.out.println("Account onBoard: " + passenger.getOnBoard());
        System.out.println("Entry Time: " + passenger.getEntryTime());
        System.out.println("Exit Time: " + passenger.getExitTime());
        System.out.println("Vehicle Kind: " + passenger.getVehicleKind());

    }

}
