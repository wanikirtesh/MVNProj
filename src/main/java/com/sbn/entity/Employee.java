package com.sbn.entity;

public class Employee {
    private final String name;
    private final String designation;
    private final String department;
    private final String country;

    public Employee(String name, String designation, String department, String country) {
        this.name =name;
        this.designation = designation;
        this.department = department;
        this.country = country;
    }

    @Override
    public boolean equals(Object employee){
        return true;
    }
}
