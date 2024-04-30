package edu.curtin.app.state;

import edu.curtin.app.model.Passenger;

//for state pattern
public interface PassengerAccountStatus {
     void checkAccountStatus(Passenger passenger);
     String getStatus();

}