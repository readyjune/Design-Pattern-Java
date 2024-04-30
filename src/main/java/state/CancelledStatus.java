package edu.curtin.app.state;

import edu.curtin.app.model.Passenger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelledStatus implements PassengerAccountStatus {
    private static final Logger LOGGER = Logger.getLogger(CancelledStatus.class.getName());

    @Override
    public void checkAccountStatus(Passenger passenger) {
        try {
            // passenger account status will be good standing when the current money is more than or equal to 5
            if (passenger.getAccountSaving() >= 5) {
                passenger.setAccountStatus(new GoodStandingStatus());
            }
            // passenger account status will be InDebt status when the current money is less than 5 and more than or equal to 0
            else if ((passenger.getAccountSaving() < 5) && (passenger.getAccountSaving() >= 0)) {
                passenger.setAccountStatus(new InDebtStatus());
            }
        } catch (IllegalArgumentException ex) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "An illegal argument exception occurred while checking passenger account status.", ex);
            }
            
        }
    }

    // this method is getting current passenger account status as a string
    @Override
    public String getStatus() {
        return "Cancelled";
    }
}
