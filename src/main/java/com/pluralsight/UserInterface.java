package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    //initializes the dealership and assigns value to it
    private void init() {
        DealershipFileManager file = new DealershipFileManager();
        dealership = file.getDealership();
    }

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please Select an Option Below:");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> processGetVehiclesByPrice(scanner);
                case 2 -> processGetVehiclesByMakeModel(scanner);
                case 3 -> processGetVehiclesByYear(scanner);
                case 4 -> processGetVehiclesByColor(scanner);
                case 5 -> processGetVehiclesByMileage(scanner);
                case 6 -> processGetVehicleByType(scanner);
                case 7 -> processGetAllVehicles();
                case 8 -> {
                    dealership.addVehicle(makeVehicle(scanner));

                    //updates file
                    DealershipFileManager file = new DealershipFileManager();
                    file.saveDealership(dealership);
                }
                case 9 -> {
                    dealership.removeVehicle(scanner);

                    //updates file
                    DealershipFileManager file = new DealershipFileManager();
                    file.saveDealership(dealership);
                }
                case 99 -> {
                    System.out.println("Thank you! Have a nice day.");
                    return;
                }
                default -> System.out.println("invalid input");
            }
        }
    }

    //gather certain information insert what info is needed in parameters and then ask for that info separates and returns an array
    private String[] askInfo(String string, Scanner scanner) {
        while (true) {
            System.out.println("Please enter the " + string + ": ");
            String[] parts = scanner.nextLine().trim().split(" ");

            switch (parts.length) {
                case 1 -> {
                    return new String[]{parts[0], ""};
                }
                case 2 -> {
                    return parts;
                }
                default -> System.out.println("Sorry entry not valid");
            }
        }
    }

    //ask the user for all information needed to creat a vehicle object
    private Vehicle makeVehicle(Scanner scanner) {
        System.out.println("Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Make: ");
        String make = scanner.nextLine();

        System.out.println("Model: ");
        String model = scanner.nextLine();

        System.out.println("Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Color: ");
        String color = scanner.nextLine();

        System.out.println("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }

    //all process methods gather information needed for search load it into the dealership methods and display the results
    public void processGetVehiclesByPrice(Scanner scanner){
        while(true) {
            String[] info = getMinMax("price", scanner);
            try {
                //using displayVehicles method to print out correct vehicles | parsing an array to double to use for getVehiclesByPrice method
                displayVehicles(dealership.getVehiclesByPrice(Double.parseDouble(info[0]), Double.parseDouble(info[1])));
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public void processGetVehiclesByMakeModel(Scanner scanner){
        System.out.println("Please enter the make:");
        String make = scanner.nextLine();

        System.out.println("Please enter the model:");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetVehiclesByYear(Scanner scanner){
        String[] info = getMinMax("year", scanner);
        displayVehicles(dealership.getVehiclesByYear(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
    }

    public void processGetVehiclesByColor(Scanner scanner){
        String[] info = askInfo("color", scanner);
        displayVehicles(dealership.getVehiclesByColor(info[0]));
    }

    public void processGetVehiclesByMileage(Scanner scanner){
        String[] info = getMinMax("mileage", scanner);
        displayVehicles(dealership.getVehiclesByMileage(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
    }

    public void processGetVehicleByType(Scanner scanner){
        String[] info = askInfo("vehicle type", scanner);
        displayVehicles(dealership.getVehiclesByType(info[0]));

    }

    public void processGetAllVehicles(){
        displayVehicles(dealership.getAllVehicles());

    }

    //without other methods will simply print the list of current vehicles
    void displayVehicles(ArrayList<Vehicle> inventory){
        for (Vehicle v: inventory){
            System.out.println(v);
        }
    }

    //ask the user for a min and a max, assigns values and the return it though an array for later use
    private String[] getMinMax(String string, Scanner scanner){
        String[] parts = new String[2];

        System.out.println("Please enter the min " + string);
        parts[0] = scanner.nextLine().trim();
        if(parts[0].isEmpty()){
            parts[0] = "0";
        }

        System.out.println("Please enter the max " + string);
        parts[1] = scanner.nextLine().trim();
        if(parts[1].isEmpty()){
            parts[1] = "999999999";
        }

        return parts;
    }
}
