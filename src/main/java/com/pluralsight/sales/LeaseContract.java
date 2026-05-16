package com.pluralsight.sales;

import com.pluralsight.managment.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
        this.expectedEndingValue = getVehicleSold().getPrice() / 2;
        this.leaseFee = getVehicleSold().getPrice() * .07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return expectedEndingValue + "|" + leaseFee + "|" + getTotalPrice() + "|" + getMonthlyPayment();
    }
}
