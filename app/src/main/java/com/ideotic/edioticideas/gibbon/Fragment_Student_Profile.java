package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import STUDENT.StudentProfile;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Student_Profile extends Fragment {

    View view;
    public static String userid = null;
    boolean complete = false;
    StudentProfile stu;
    TextView branch, sem, email, contact, dob, addmission, address, gender, category, gaurdian, name, stid;
    Thread serverThread;

    public Fragment_Student_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment__student__profile, container, false);
        init();
        getProfileData();

        //Set data
        name.setText(stu.getSt_name());
        stid.setText(stu.getRollno());
        branch.setText(stu.getDepartment_id());
        sem.setText(stu.getAddmission_date());
        email.setText(stu.getEmail());
        contact.setText(stu.getMobile());
        dob.setText(stu.getDOB());
        addmission.setText(stu.getAddmission_date());
        address.setText(stu.getPer_address());
        gender.setText(stu.getSex());
        category.setText(stu.getCatgry());

        return view;
    }

    public void init() {
        branch = (TextView) view.findViewById(R.id.textView_studentProfile_branch);
        sem = (TextView) view.findViewById(R.id.textView_studentProfile_sem);
        email = (TextView) view.findViewById(R.id.textView_student_profile_email);
        contact = (TextView) view.findViewById(R.id.textView_student_profile_contact);
        dob = (TextView) view.findViewById(R.id.textView_student_profile_dob);
        addmission = (TextView) view.findViewById(R.id.textView_student_profile_addmdate);
        address = (TextView) view.findViewById(R.id.textView_student_profile_address);
        gender = (TextView) view.findViewById(R.id.textView_profiel_student_gender);
        category = (TextView) view.findViewById(R.id.textView_profile_student_category);
        gaurdian = (TextView) view.findViewById(R.id.textView_student_profile_gaurdian);
        name = (TextView) view.findViewById(R.id.textView_name_student_profile);
        stid = (TextView) view.findViewById(R.id.textView_student_profile_id);
    }

    public void getProfileData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                Request request = new Request(null, null, new StudentProfile(userid), RequestedType.STUDENTPROFILE);
                try {
                    Response response = (Response) connection.read(request);
                    stu = (StudentProfile) response.getRequestedObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        serverThread.start();
        while (serverThread.isAlive()) ;
    }

}
