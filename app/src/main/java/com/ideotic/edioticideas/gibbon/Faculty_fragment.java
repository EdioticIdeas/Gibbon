package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import STUDENT.StuAttendenceCount;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.Staff;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class Faculty_fragment extends Fragment {

    ListView list;
    FacultyListAdapter adapter;
    ArrayList<FacultyDetails> details;
    Thread serverThread;
    ProgressBar marker;

    public Faculty_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {

        getFacultyData();
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_faculty_fragment, container, false);

        marker = (ProgressBar) view.findViewById(R.id.marker_progress);
        details = new ArrayList<>();
        adapter = new FacultyListAdapter(getActivity(), details);

        list = (ListView) view.findViewById(R.id.listView_faculty);
        list.setAdapter(adapter);

        return view;
    }

    private void getFacultyData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    marker.setVisibility(View.VISIBLE);
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, "cse", RequestedType.FACULTYLIST);
                    Response res = (Response) connection.read(req);
                    ArrayList<Staff> list = (ArrayList<Staff>) res.getRequestedObject();
                    for (Staff staff : list)
                        details.add(new FacultyDetails(staff.getS_name(), staff.getS_email(), staff.getDepartment_id()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        serverThread.start();
        while (serverThread.isAlive()) ;
        marker.setVisibility(View.INVISIBLE);
    }
}



