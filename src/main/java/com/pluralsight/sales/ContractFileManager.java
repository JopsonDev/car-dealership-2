package com.pluralsight.sales;

import com.pluralsight.managment.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ContractFileManager {
    private String fileName = "sales.csv";

    public void saveSale(Contract contract) {
        try {
            String input = "";
            if (contract instanceof LeaseContract) {
                input = "LEASE|";
            }
            else if (contract instanceof SalesContract){
                input = "SALE|";
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            Vehicle v = contract.getVehicleSold();
            writer.write(input + contract.getDate() + "|" + contract.getName() + "|" + contract.getEmail() + "\n" +
                    contract.getVehicleSold() + contract + "\n");
            System.out.println("Thank you for your purchase see details below");
            System.out.println("===============================================");
            System.out.println(input + contract.getDate() + "|" + contract.getName() + "|" + contract.getEmail() + "\n" +
                    contract.getVehicleSold() + contract + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to make new dealership file");
        }
    }

    public void readFile(String type){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sales.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(type)){
                    System.out.println(line);
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Failed to read transactions");
        }
    }

    public void read10File(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sales.csv"));
            String line;
            for (int i = 0; i < 30; i++) {
                if ((line = reader.readLine()) != null){
                    System.out.println(line);
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println("Failed to read transactions");
        }
    }
}
