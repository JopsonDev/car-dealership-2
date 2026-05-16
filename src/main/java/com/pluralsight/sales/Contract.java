package com.pluralsight.sales;

import com.pluralsight.managment.Vehicle;

abstract public class Contract {
    private String date;
    private String name;
    private String email;
    private Vehicle vehicleSold;


    public Contract(String date, String name, String email, Vehicle vehicleSold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;

    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    abstract public double getTotalPrice();

    abstract public double getMonthlyPayment();

}
