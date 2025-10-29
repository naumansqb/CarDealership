package com.pluralsight;

public class Vehicle {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }


    public String getMake() {
        return make;
    }


    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getColor() {
        return color;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-8d | %4d | %-10s | %-14s | %-6s | %-10s | %,8d | $%,9.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}
