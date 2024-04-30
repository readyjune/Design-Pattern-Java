package edu.curtin.app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            // Run the app
            // Starting point
            MenuFirst appRunner = new MenuFirst();
            appRunner.runApp(input);
        } catch (InputMismatchException e) {
            // Handle InputMismatchException
            System.out.println("Invalid input. Please enter a valid integer choice.");
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            System.out.println("Input not found. Please enter a valid input.");
        }
    }
}
