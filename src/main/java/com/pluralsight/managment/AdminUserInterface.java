package com.pluralsight.managment;

import com.pluralsight.sales.ContractFileManager;

import java.util.Scanner;

public class AdminUserInterface {
    ContractFileManager c = new ContractFileManager();

    public int login(Scanner scanner){
        while(true) {
            System.out.print("Please enter employee pin or 0 to go back(Raymond its 1234): ");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1234) {
                return 1;
            } else if (input == 0){
                return 0;
            } else {
                System.out.println("Invalid pin");
            }
        }
    }

    public void checkAccess(int num, Scanner scanner){
        if (num == 1){
            fileSearch(scanner);
        } else {
            System.out.println("Returning thank you");
        }
    }

    public void fileSearch(Scanner scanner){
        while(true) {
            System.out.println("WELCOME!");
            System.out.println("Please make a selection");
            System.out.println("1 - View all contracts");
            System.out.println("2 - View last 10 contracts");
            System.out.println("3 - List all SALES");
            System.out.println("4 - List all Leases");
            System.out.println("99 - return");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input){
                case 1 -> c.readFile("+");
                case 2 -> c.read10File();
                case 3 -> c.readFile("+SALE");
                case 4 -> c.readFile("+LEASE");
                case 99 -> {
                    return;
                }
            }
        }
    }

}
