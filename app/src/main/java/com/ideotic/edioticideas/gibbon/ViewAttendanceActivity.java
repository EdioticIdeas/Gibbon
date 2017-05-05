package com.ideotic.edioticideas.gibbon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAttendanceActivity extends AppCompatActivity {

    ListView listView;
    TeacherViewAttendanceAdapter adapter;
    public static ArrayList<Attendance_data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Attendance Report");
        setContentView(R.layout.activity_view_attendance);

        listView = (ListView) findViewById(R.id.listView_viewAttendance);

        adapter = new TeacherViewAttendanceAdapter(this, list);
        listView.setAdapter(adapter);

    }
}
