package edu.curtin.app.observer;

import edu.curtin.app.model.Passenger;

//For observer pattern
public interface ObserverVehicle {
    void update(Passenger passenger);
    String getVehicleKind();

}
