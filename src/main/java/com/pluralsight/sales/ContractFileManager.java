package com.pluralsight.sales;

import com.pluralsight.Dealership;
import com.pluralsight.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {
    private String fileName = "sales.csv";

    public void saveLease(LeaseContract contract) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("LEASE " + contract);
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to make new dealership file");
        }
    }

    public void saveSale(Contract contract) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("LEASE " + contract);
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to make new dealership file");
        }
    }
}
