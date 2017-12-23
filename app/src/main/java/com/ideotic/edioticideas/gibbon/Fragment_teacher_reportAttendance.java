package com.ideotic.edioticideas.gibbon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import STUDENT.StuSubjectAttendence;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_teacher_reportAttendance extends Fragment {

    Spinner spinner1, spinner2, spinner3;
    String whichDepartment, whichSem, whichSub;
    Button submit;
    String[] department = {"cse", "it", "me", "ce", "ec"};
    String[] semester = {"01", "02", "03", "04", "05", "06", "07", "08"};
    String[] subject = {"DBMS", "CN", "TOC", "OS", "ADA"};
    Thread serverThread;


    public Fragment_teacher_reportAttendance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_teacher_take_attendance, container, false);

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        submit = (Button) view.findViewById(R.id.button_viewAttendnece);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter depart = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, department);
        ArrayAdapter sem = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, semester);
        ArrayAdapter sub = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, subject);

        depart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(depart);
        spinner2.setAdapter(sem);
        spinner3.setAdapter(sub);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity(), "Database Empty", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ViewAttendanceActivity.class);
                startActivity(intent);
            }
        });

        whichDepartment = spinner1.getSelectedItem().toString();
        whichSem = spinner2.getSelectedItem().toString();
        getSpineerData();

        return view;
    }

    public void getSpineerData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                Request request = new Request(null, null, whichSem + "," + whichDepartment, RequestedType.STUDENT_REPORT);
                try {
                    Response response = (Response) connection.read(request);
                    ArrayList<StuSubjectAttendence.Attendence> list = (ArrayList<StuSubjectAttendence.Attendence>) response.getRequestedObject();
                    for (StuSubjectAttendence.Attendence attendence : list) {
                        ViewAttendanceActivity.list.add(new Attendance_data(attendence.getSubject(), attendence.getPresentCount(), attendence.getTotalClasses()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        serverThread.start();
        while (serverThread.isAlive()) ;
    }

}
