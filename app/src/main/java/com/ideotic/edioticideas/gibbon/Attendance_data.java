package com.ideotic.edioticideas.gibbon;

/**
 * Created by Mukul on 01-05-2017.
 */

public class Attendance_data {

    private String studentName = null;
    private String studentAttendance = null;
    private String studentId = null;

    public Attendance_data(String name, String attendance, String id) {
        this.studentAttendance = attendance;
        this.studentId = id;
        this.studentName = name;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentAttendance() {
        return studentAttendance;
    }

    public String getStudentId() {
        return studentId;
    }
}
