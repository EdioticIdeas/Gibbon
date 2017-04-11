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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Student_Dashboard extends Fragment {

    private static TextView tt_second_faculty;
    private static PieChart pieChart;

    public Fragment_Student_Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment__student__dashboard, container, false);

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
}
