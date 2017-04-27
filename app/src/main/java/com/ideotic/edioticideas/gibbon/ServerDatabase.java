package com.ideotic.edioticideas.gibbon;

import android.os.AsyncTask;
import android.os.Handler;

import java.io.IOException;

import STUDENT.StuAttendenceCount;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import Util.RequestedType;

/**
 * Created by Mukul on 07-04-2017.
 */
public class ServerDatabase {

    public static final String ipAddress = "192.168.1.5";
    public static final int portNumber = 8189;
    private Handler handler;
    Thread serverThread = null;

    //Variables for pie chart data Student
    float present,absent,holidays,total;

    public int validate(String userName, String password){
        return 0;
    }

    public void getPieData() throws IOException{
        serverThread = new Thread(){
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress,8189);
                    Request req = new Request("1111",null,null, RequestedType.STUATTENDENCECOUNT);
                    Response res = (Response)  connection.read(req);
                    StuAttendenceCount count =(StuAttendenceCount) res.getRequestedObject();
                    present = count.getPresent();
                    absent = count.getTotal_days()-count.getPresent()-15;
                    holidays = 15;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

    serverThread.start();
    while(serverThread.isAlive());
    }


}
