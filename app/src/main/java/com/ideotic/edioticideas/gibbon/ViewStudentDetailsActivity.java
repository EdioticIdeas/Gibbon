package com.ideotic.edioticideas.gibbon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import STUDENT.StudentProfile;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.LIBRARY.Books;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;

public class ViewStudentDetailsActivity extends AppCompatActivity {

    ListView listView;
    ViewStudentDetailsAdapter adapter;
    ArrayList<Student> list;
    Thread serverThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);
        setTitle("Student Details");

        listView = (ListView) findViewById(R.id.listView_viewStudentDetails);
        list = new ArrayList<>();
        getStudentData();

        adapter = new ViewStudentDetailsAdapter(this, list);
        listView.setAdapter(adapter);
    }

    public void getStudentData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, "cse," + Fragment_StudentDetails.whichSemester, RequestedType.STUDENTLIST);
                    Response res = (Response) connection.read(req);
                    ArrayList<StudentProfile> students = (ArrayList<StudentProfile>) res.getRequestedObject();
                    for (StudentProfile stu : students) {
                        list.add(new Student(stu.getSt_name(), stu.getEmail(), stu.getMobile(), stu.getRollno()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        serverThread.start();
        while (serverThread.isAlive()) ;
    }
}
