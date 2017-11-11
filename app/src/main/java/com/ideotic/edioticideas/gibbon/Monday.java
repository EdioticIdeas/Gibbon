package com.ideotic.edioticideas.gibbon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import STUDENT.StuTimeTable;

/**
 * Created by Mukul on 23-04-2017.
 */

public class Monday extends Fragment {

    TextView sub1, sub2, sub3, sub4, sub5;
    TextView tea1, tea2, tea3, tea4, tea5;
    TextView room1, room2, room3, room4, room5;
    View rootView;
    StuTimeTable dayList;
    ArrayList<StuTimeTable.Day> weekDayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_monday, container, false);
        init();
        return rootView;
    }

    public void init() {
        sub1 = (TextView) rootView.findViewById(R.id.textView_TT_subject_monday);
        sub2 = (TextView) rootView.findViewById(R.id.textView_TT_subject2_monday);
        sub3 = (TextView) rootView.findViewById(R.id.textView_TT_subject3_monday);
        sub4 = (TextView) rootView.findViewById(R.id.textView_TT_subject4_monday);
        sub5 = (TextView) rootView.findViewById(R.id.textView_TT_subject5_monday);

        tea1 = (TextView) rootView.findViewById(R.id.textView_TT_faculty_monday);
        tea2 = (TextView) rootView.findViewById(R.id.textView_TT_faculty2_monday);
        tea3 = (TextView) rootView.findViewById(R.id.textView_TT_faculty3_monday);
        tea4 = (TextView) rootView.findViewById(R.id.textView_TT_faculty4_monday);
        tea5 = (TextView) rootView.findViewById(R.id.textView_TT_faculty5_monday);

        room1 = (TextView) rootView.findViewById(R.id.textView_TT_room);
        room2 = (TextView) rootView.findViewById(R.id.textView_TT_room2);
        room3 = (TextView) rootView.findViewById(R.id.textView_TT_room3);
        room4 = (TextView) rootView.findViewById(R.id.textView_TT_room4);
        room5 = (TextView) rootView.findViewById(R.id.textView_TT_room5);


        dayList = TimetableActivity.list.get(0);
        weekDayList = dayList.getTimetable();

        //set the data
        sub1.setText(weekDayList.get(0).getSubjectName());
        sub2.setText(weekDayList.get(1).getSubjectName());
        sub3.setText(weekDayList.get(2).getSubjectName());
        sub4.setText(weekDayList.get(3).getSubjectName());
        sub5.setText(weekDayList.get(4).getSubjectName());

        tea1.setText(weekDayList.get(0).getTeacher());
        tea2.setText(weekDayList.get(1).getTeacher());
        tea3.setText(weekDayList.get(2).getTeacher());
        tea4.setText(weekDayList.get(3).getTeacher());
        tea5.setText(weekDayList.get(4).getTeacher());

        room1.setText(weekDayList.get(0).getRoom());
        room2.setText(weekDayList.get(1).getRoom());
        room3.setText(weekDayList.get(2).getRoom());
        room4.setText(weekDayList.get(3).getRoom());
        room5.setText(weekDayList.get(4).getRoom());

    }

}
