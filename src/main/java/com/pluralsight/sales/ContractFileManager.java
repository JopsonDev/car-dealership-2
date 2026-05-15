package com.pluralsight.sales;

import com.pluralsight.Dealership;
import com.pluralsight.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {
    private String fileName = "sales.csv";

    public void saveSale(Contract contract) {
        try {
            String input = "";
            if (contract instanceof LeaseContract) {
                input = "LEASE ";
            }
            else if (contract instanceof SalesContract){
                input = "SALE ";
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
}
