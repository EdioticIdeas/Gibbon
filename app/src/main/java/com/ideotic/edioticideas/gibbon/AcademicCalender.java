package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicCalender extends Fragment {


    public AcademicCalender() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_academic_calender, container, false);

        CalendarView simpleCalendarView = (CalendarView) view.findViewById(R.id.calendarView); // get the reference of CalendarView
        simpleCalendarView.setDate(System.currentTimeMillis(), false, true);

        return view;
    }

}
