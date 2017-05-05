package com.ideotic.edioticideas.gibbon;

import android.os.Handler;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import LOGIN.UserLogin;
import STUDENT.StuAttendenceCount;
import STUDENT.StuSubjectAttendence;
import STUDENT.StudentProfile;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import Util.RequestedType;

/**
 * Created by Mukul on 07-04-2017.
 */
public class ServerDatabase {

    public static final String ipAddress = "192.168.0.101";
    public static final int portNumber = 8189;
    private Handler handler;
    Thread serverThread = null;
    Thread thread = null;
    Thread validateThread = null;
    public static String userID = null;
    int whichModule = 1;

    //Variables for pie chart data Student
    float present, absent, holidays, total;


    public int validate(final String userName, final String password) {

        validateThread = new Thread() {
            @Override
            public void run() {
                ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                Request request = new Request(null, null, new UserLogin(userName, password), RequestedType.USERLOGIN);
                try {
                    Response response = (Response) connection.read(request);
                    if (response.getTime().equals("1"))
                        whichModule = 0;
                    else if (response.getTime().equals("2"))
                        whichModule = 1;
                    else
                        whichModule = 2;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        validateThread.start();
        while (validateThread.isAlive()) ;
        return whichModule;
    }

    public void getPieData() throws IOException {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request("1111", null, null, RequestedType.STUATTENDENCECOUNT);
                    Response res = (Response) connection.read(req);
                    StuAttendenceCount count = (StuAttendenceCount) res.getRequestedObject();
                    present = count.getPresent();
                    absent = count.getTotal_days() - count.getPresent() - 15;
                    holidays = 15;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        serverThread.start();
        while (serverThread.isAlive()) ;
    }

    ArrayList<StuSubjectAttendence.Attendence> list = null;

    public ArrayList<StuSubjectAttendence.Attendence> getSubjectAttandence() {
        final StudentProfile profile = new StudentProfile(userID);

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, profile, RequestedType.STUSUBJECTATTENDENCE);
                    Response res = (Response) connection.read(req);
                    list = (ArrayList<StuSubjectAttendence.Attendence>) res.getRequestedObject();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        while (thread.isAlive()) ;
        return list;
    }
}
