package com.pluralsight.sales;

public class Customer {
    private String name;
    private String email;


    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
