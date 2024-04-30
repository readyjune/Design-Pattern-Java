package edu.curtin.app.state;

import edu.curtin.app.model.Passenger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodStandingStatus implements PassengerAccountStatus {
    private static final Logger LOGGER = Logger.getLogger(GoodStandingStatus.class.getName());

    @Override
    public void checkAccountStatus(Passenger passenger) {
        try {
            // passenger is in good standing
            // passenger account status will be InDebt status when the current money is less than 5 and more than or equal to 0
            // the reason why there's no way to go to Cancelled is fare will be 3 so there's no way to skip InDebt Status to go to Cancelled.
            if (passenger.getAccountSaving() < 5) {
                passenger.setAccountStatus(new InDebtStatus());
            }
        } catch (IllegalArgumentException ex) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "An illegal argument exception occurred while checking passenger account status.", ex);
            }
            
        }
    }

    // This is for getting current Status as a string.
    @Override
    public String getStatus() {
        return "Good Standing";
    }
}
