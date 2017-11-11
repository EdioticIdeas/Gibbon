package com.ideotic.edioticideas.gibbon;

/**
 * Created by Mukul on 28-04-2017.
 */

public class FacultyDetails {
    private String name = null;
    private String email = null;
    private String department = null;

    public FacultyDetails(String name, String email, String department) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDepartment() {
        return this.department;
    }
}
