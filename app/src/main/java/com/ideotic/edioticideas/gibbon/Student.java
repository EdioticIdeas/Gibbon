package com.ideotic.edioticideas.gibbon;


/**
 * Created by Mukul on 03-05-2017.
 */

public class Student {
    private String name = null;
    private String studentId = null;
    private String cotact = null;
    private String email = null;

    public Student(String name, String email, String contact, String id) {
        this.cotact = contact;
        this.email = email;
        this.name = name;
        this.studentId = id;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCotact() {
        return cotact;
    }

    public String getEmail() {
        return email;
    }
}
