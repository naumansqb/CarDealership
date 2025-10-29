package com.pluralsight;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scan = new Scanner(System.in);
    public UserInterface() {}

    public void display() {
        init();
        userMenu();
    }


    private void userMenu(){
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
                scan.nextLine();
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
                        scan.close();
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

    private void init(){
        DealershipFileManager df= new DealershipFileManager();
        dealership= df.getDealership();
        if((dealership.getName() ==null)||(dealership.getAddress()==null)||(dealership.getPhoneNumber()==null)){
            setUp();
            df.saveDealership(dealership);
            System.out.println("Dealership information was updated successfully");
        }
    }

    private void setUp(){
        if(dealership.getName()==null){
            System.out.println("The name of your dealership was not stored properly\n" +
                    "Please enter the name of your dealership");
            dealership.setName(scan.nextLine());
        }
        if(dealership.getAddress()==null){
            System.out.println("The address of your dealership was not stored properly\n" +
                    "Please enter the address of your dealership");
            dealership.setAddress(scan.nextLine());
        }
        if(dealership.getPhoneNumber()==null){
            System.out.println("The phone number of your dealership was not stored properly\n" +
                    "Please enter the number of your dealership");
            dealership.setPhoneNumber(scan.nextLine());
        }
    }
    private void displayVehicles(List<Vehicle> vehicles){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles found");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
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
