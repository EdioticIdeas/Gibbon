package com.ideotic.edioticideas.gibbon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_StudentDetails extends Fragment {

    String[] semester = {"1", "2", "3", "4", "5", "6", "7", "8"};
    Spinner spinner;
    Button button;
    public static String whichSemester;


    public Fragment_StudentDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__student_details, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner_StudentDetails);
        button = (Button) view.findViewById(R.id.button_StudentDetails);

        ArrayAdapter sem = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, semester);
        sem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(sem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichSemester = spinner.getSelectedItem().toString();
                Intent intent = new Intent(getActivity(), ViewStudentDetailsActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
