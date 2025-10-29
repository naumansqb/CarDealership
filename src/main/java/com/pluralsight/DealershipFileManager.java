package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    public static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No dealership file found. \n You will be prompted to enter details about your dealership very soon <3.");
            return new Dealership("", "", "");
        }

        Dealership ds;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = "";
            int lineNumber = 2;

            String dealershipInfo = reader.readLine();
            if (dealershipInfo == null) {
                ds = new Dealership("", "", "");
            } else {
                String[] dealershipTokens = dealershipInfo.split("\\|");
                if (dealershipTokens.length != 3) {
                    ds = new Dealership("", "", "");
                } else {
                    ds = new Dealership(dealershipTokens[0], dealershipTokens[1], dealershipTokens[2]);
                }
            }
            while ((line = reader.readLine()) != null) {
                String[] vehicleTokens = line.split("\\|");
                if (vehicleTokens.length == 8) {
                    try {
                        int vin = Integer.parseInt(vehicleTokens[0]);
                        int year = Integer.parseInt(vehicleTokens[1]);
                        String make = vehicleTokens[2];
                        String model = vehicleTokens[3];
                        String vehicleType = vehicleTokens[4];
                        String color = vehicleTokens[5];
                        int odometer = Integer.parseInt(vehicleTokens[6]);
                        double price = Double.parseDouble(vehicleTokens[7]);

                        Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                        ds.addVehicle(v);
                    } catch (NumberFormatException e) {
                        System.out.println("Error processing vehicle on line " + lineNumber + " - Skipping this vehicle.");
                    }
                } else {
                    System.out.println("Invalid vehicle format on line " + lineNumber +
                            " (expected 8 fields, got " + vehicleTokens.length + ")");
                }
                lineNumber++;
            }
            reader.close();
            return ds;
        } catch (Exception e) {
            System.out.println("Error reading from file. ");
            e.printStackTrace();
            return new Dealership(null, null, null);
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving dealership to file");
            e.printStackTrace();
        }
    }
}
