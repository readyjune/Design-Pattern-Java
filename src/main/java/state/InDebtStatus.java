package edu.curtin.app.state;

import edu.curtin.app.model.Passenger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InDebtStatus implements PassengerAccountStatus {
    private static final Logger LOGGER = Logger.getLogger(InDebtStatus.class.getName());

    @Override
    public void checkAccountStatus(Passenger passenger) {
        try {
            // passenger is in debt
            // when passenger recharges their accountSaving and if it's more than 5, it will change to good standing status
            if (passenger.getAccountSaving() >= 5) {
                passenger.setAccountStatus(new GoodStandingStatus());
            //if it's less than 0, the account status will be cancelled.
            } else if (passenger.getAccountSaving() < 0) {
                passenger.setAccountStatus(new CancelledStatus());
            }
        } catch (IllegalArgumentException ex) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "An illegal argument exception occurred while checking passenger account status.", ex);
            }
            
        }
    }

    // this is getting a current status as a string for printing.
    @Override
    public String getStatus() {
        return "In Debt";
    }
}
