package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){}

    public void display() {
        init();
        userMenu();
    }

    public void userMenu(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Welcome to "+dealership.getName());
        boolean isRunning=true;
        while(isRunning) {
            System.out.println("Please chose from the following option");
            System.out.println("1. Find vehicles within a price range\n" +
                    "2. Find vehicles by make/model\n" +
                    "3. Find vehicles by year range\n" +
                    "4. Find vehicles by color\n" +
                    "5. Find vehicles by mileage range\n" +
                    "6. Find vehicles by type(car,truck,SUV,van)\n" +
                    "7. List ALL Vehicles\n" +
                    "8. Add a vehicle\n" +
                    "9. Remove a vehicle\n" +
                    "99.Quit\n");
            System.out.println("Enter choice: ");
            try {
                int userChoice= scan.nextInt();
                switch (userChoice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByTypeRequest();
                        break;
                    case 7:
                        processAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 99:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a choice from the options provided");
                }
            } catch (InputMismatchException e) {
                System.out.println("Numerical value was not entered. Please enter a correct value or enter 99 to exit");
                scan.nextLine();
            }
        }


    }
    private void displayVehicles(){
    }
    private void processGetByPriceRequest() {}
    private void processGetByMakeModelRequest() {}
    private void processGetByYearRequest() {}
    private void processGetByColorRequest() {}
    private void processGetByMileageRequest() {}
    private void processGetByTypeRequest() {}
    private void processAllVehiclesRequest() {}
    private void processAddVehicleRequest() {}
    private void processRemoveVehicleRequest() {}

}
