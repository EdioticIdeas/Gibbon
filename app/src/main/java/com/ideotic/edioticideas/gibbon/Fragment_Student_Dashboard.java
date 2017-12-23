package com.ideotic.edioticideas.gibbon;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import STUDENT.StuTimeTable;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Student_Dashboard extends Fragment {

    private static TextView tt_second_faculty;
    private static PieChart pieChart;
    TextView sub1, sub2, sub3, sub4, sub5;
    TextView tea1, tea2, tea3, tea4, tea5;
    TextView room1, room2, room3, room4, room5;
    TextView day, date;
    View view;
    StuTimeTable dayList;
    ArrayList<StuTimeTable.Day> weekDayList;

    public Fragment_Student_Dashboard() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        initializeDailyTimeTable();
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       view = inflater.inflate(R.layout.fragment_fragment__student__dashboard, container, false);
         day = (TextView) view.findViewById(R.id.textView16_WhichDay);
        date = (TextView) view.findViewById(R.id.textView16_WhichDate);
        Calendar calendar = Calendar.getInstance();
        Date newDate = calendar.getTime();
        day.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(newDate.getTime()));
       // String setDate = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
        //date.setText(setDate);



        tt_second_faculty = (TextView)view.findViewById(R.id.student_tt_second_faculty);
        tt_second_faculty.setSelected(true);

        pieChart = (PieChart)view.findViewById(R.id.student_pie_attendance);
        createPieChart();
        init();


        return view;
    }

    public void init(){
        tt_second_faculty.setText("Suman Chandanan");
    }

    public void createPieChart(){
        DashboardActivity act = new DashboardActivity();
        PieData data = act.getPieData();
        pieChart.setData(data);
        // configure pie chart
        pieChart.setUsePercentValues(true);
        pieChart.animateXY(3000,3000);
        pieChart.setCenterText("Your Attendance");
        pieChart.setDescriptionColor(Color.parseColor("#ffffff"));
        pieChart.setCenterTextColor(Color.parseColor("#2A363B"));
        pieChart.setHoleRadius(65);
        pieChart.invalidate();
    }

    public void initializeDailyTimeTable() {
        sub1 = (TextView) view.findViewById(R.id.student_tt_first_subject);
        sub2 = (TextView) view.findViewById(R.id.student_tt_second_subject);
        sub3 = (TextView) view.findViewById(R.id.student_tt_third_subject);
        sub4 = (TextView) view.findViewById(R.id.student_tt_fourth_subject);
        sub5 = (TextView) view.findViewById(R.id.student_tt_fifth_subject);

        tea1 = (TextView) view.findViewById(R.id.student_tt_first_faculty);
        tea2 = (TextView) view.findViewById(R.id.student_tt_second_faculty);
        tea3 = (TextView) view.findViewById(R.id.student_tt_third_faculty);
        tea4 = (TextView) view.findViewById(R.id.student_tt_fourth_faculty);
        tea5 = (TextView) view.findViewById(R.id.student_tt_fifth_faculty);

        room1 = (TextView) view.findViewById(R.id.student_tt_first_room);
        room2 = (TextView) view.findViewById(R.id.student_tt_second_room);
        room3 = (TextView) view.findViewById(R.id.student_tt_third_room);
        room4 = (TextView) view.findViewById(R.id.student_tt_fourth_room);
        room5 = (TextView) view.findViewById(R.id.student_tt_fifth_room);

        day = (TextView) view.findViewById(R.id.textView16_WhichDay);
        date = (TextView) view.findViewById(R.id.textView16_WhichDate);

        //setting the data
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
