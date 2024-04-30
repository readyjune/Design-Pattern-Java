package edu.curtin.app;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.curtin.app.factory.VehicleFactory;
import edu.curtin.app.model.Passenger;
import edu.curtin.app.model.PassengerManager;
import edu.curtin.app.observer.ObserverVehicle;

public class MenuFirst {
    private static final Logger LOGGER = Logger.getLogger(MenuFirst.class.getName());


    public void runApp(Scanner scanner) {
       
        //Create VehicleFactory Object for factory pattern
        // this will help us to create vehicle(bus and train) with the name.
        VehicleFactory vehicleFactory = new VehicleFactory();

        // list of passenger will be stored and will be observed.
        PassengerManager passengerManager = new PassengerManager();

        // create a passenger object
        Passenger passenger1 = new Passenger("Josh", 7, false);
        Passenger passenger2 = new Passenger("Mary", 10, false);


        //After creating a vehicle through factory pattern, This vehicles will be observing the passengers
        ObserverVehicle bus = vehicleFactory.createObject("bus");
        ObserverVehicle train = vehicleFactory.createObject("train");

        passengerManager.attach(bus);
        passengerManager.attach(train);

        passengerManager.addPassenger(passenger1);
        passengerManager.addPassenger(passenger2);

        //Getting an input from the user
        //Scanner scanner = new Scanner(System.in);
        int userInput, secondInput;
        userInput = 0;

        System.out.println("\n - Program is started - " + "\n"
                + " This program has a default objects " + "\n"
                + " Passenger Object - 'Josh' and 'Mary'" + "\n"
                + " Vehicle Object - 'Train' and 'Bus'" + "\n\n");

        while (userInput != 3) {
            System.out.println(" \nChoose the name for Passenger Object from 1 -2 or 3 terminate the program" + "\n"
                    + " 1. Josh" + "\n"
                    + " 2. Mary" + "\n"
                    + " 3. End\n");
                
            try {         
                userInput = scanner.nextInt();
  
                
                // we have a 3 options to choose so this if statement will be executed only when user enters right numbers.
                // otherwise it will print message to users.
                if (userInput < 1 || userInput > 3) {
                    System.out.println("\nInvalid input. Please enter a valid integer choice.\n");
                    continue;
                }

                // switch statement.
                // this will be changed depend on what user enters.
                switch (userInput) {
                    case 1:
                        System.out.println("\nSelect the menu\n"
                                + "1. Passenger Detail\n"
                                + "2. Get on the bus\n"
                                + "3. Get on the train\n"
                                + "4. Get off the bus\n"
                                + "5. Get off the train\n"
                                + "6. Recharge Saving\n");

                        secondInput = scanner.nextInt();

                        // Also this will check if user enters the right number which is on the menu options.
                        if (secondInput < 1 || secondInput > 6) {
                            if (LOGGER.isLoggable(Level.WARNING)) {
                                LOGGER.log(Level.WARNING, "User input was not in the range of 1-5: " + secondInput);
                            }
                            
                            System.out.println("\nInvalid input. Please enter a valid integer choice.\n");
                            continue;
                        }

                        // this is for passenger 1 specific detail menu part because it gets variable 'passenger1'
                        MenuSecond.selectUser(secondInput, passenger1, passengerManager, vehicleFactory, bus, train);
                        
                        break;
                    case 2:
                        //Same as above explanation.
                        System.out.println("\nSelect the menu\n"
                                + "1. Passenger Detail\n"
                                + "2. Get on the bus\n"
                                + "3. Get on the train\n"
                                + "4. Get off the bus\n"
                                + "5. Get off the train\n"
                                + "6. Recharge Saving\n");

                        secondInput = scanner.nextInt();

                        if (secondInput < 1 || secondInput > 6) {
                            if (LOGGER.isLoggable(Level.WARNING)) {
                                LOGGER.log(Level.WARNING, "User input was not in the range of 1-5: " + secondInput);
                            }
                            
                            System.out.println("\nInvalid input. Please enter a valid integer choice.\n");
                            continue;
                        }

                        MenuSecond.selectUser(secondInput, passenger2, passengerManager, vehicleFactory, bus, train);
                        break;
                    case 3:
                        System.out.println("You selected to finish the program");
                        break;
                    default:
                        if (LOGGER.isLoggable(Level.WARNING)) {
                            LOGGER.log(Level.WARNING, "User input was not a recognized option: " + userInput);
                        }
                        System.out.println("\ndefault: Invalid input. Please enter a valid integer choice.\n");
                        continue;
                }
                
                
      
            } catch (InputMismatchException e) {
                if (LOGGER.isLoggable(Level.WARNING)) {
                    LOGGER.log(Level.WARNING, "User input was not an integer: ");
                }
                // Error handling for InputMismatch when user press wrong button or character.

                System.out.println("\n catch: Invalid input. Please enter a valid integer choice.\n");
                
                scanner.nextLine(); // Consume the invalid input
            }
            
        }
        //scanner.close();
        System.out.println("PROGRAM END");
    }
}
