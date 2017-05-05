package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 01-05-2017.
 */

public class TeacherViewAttendanceAdapter extends ArrayAdapter<Attendance_data> {

    public TeacherViewAttendanceAdapter(Context context, ArrayList<Attendance_data> data) {
        super(context, 0, data);
    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtId;
        TextView txtAttendance;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Attendance_data attendance_data = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.student_attendance_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textView_teacherViewAttendance_name);
            viewHolder.txtId = (TextView) convertView.findViewById(R.id.textView_teacherViewAttendance_id);
            viewHolder.txtAttendance = (TextView) convertView.findViewById(R.id.textView_teacherViewAttendance_attendance);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtAttendance.setText(attendance_data.getStudentAttendance());
        viewHolder.txtId.setText(attendance_data.getStudentId());
        viewHolder.txtName.setText(attendance_data.getStudentName());
        return convertView;
    }

}
