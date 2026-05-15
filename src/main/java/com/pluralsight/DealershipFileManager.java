package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class DealershipFileManager {
    private String fileName = "inventory.csv";


    //Reads inventory file and makes a dealership
    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Dealership dealership1 = new Dealership(" ", " ", " ");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];
                    dealership1 = new Dealership(name, address, phone);

                } else if (parts.length == 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7].replace(",", ""));

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership1.getInventory().add(vehicle);

                } else {
                    System.out.println("Invaild data");
                }
            }

            reader.close();
            return dealership1;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //loads a write takes the Vehicles in the dealership array and writes over the current file with the new information
    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle v: dealership.getAllVehicles()){
                System.out.println(v);
                writer.write(String.valueOf(v));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to make new dealership file");
        }
    }
}