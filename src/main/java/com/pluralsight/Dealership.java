package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public boolean removeVehicleByVin(int vin) {
        return false;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getPrice()>=min && vehicle.getPrice()<=max){
                list.add(vehicle);
            }
        }
        return list;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                list.add(vehicle);
            }
        }
        return list;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getYear()>=min && vehicle.getYear()<=max){
                list.add(vehicle);
            }
        }
        return list;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getColor().equalsIgnoreCase(color)){
                list.add(vehicle);
            }
        }
        return list;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getOdometer()>=min && vehicle.getOdometer()<=max){
                list.add(vehicle);
            }
        }
        return list;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> list= new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(type)){
                list.add(vehicle);
            }
        }
        return list;
    }
}
