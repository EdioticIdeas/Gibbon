package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 03-05-2017.
 */

public class ViewStudentDetailsAdapter extends ArrayAdapter<Student> {

    public ViewStudentDetailsAdapter(Context context, ArrayList<Student> details) {
        super(context, 0, details);
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtEmail;
        TextView txtStudentId;
        TextView txtContact;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Student details = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.student_row_forteachers, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textView_Student_name);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.textView_Student_email);
            viewHolder.txtContact = (TextView) convertView.findViewById(R.id.textView_Student_contact);
            viewHolder.txtStudentId = (TextView) convertView.findViewById(R.id.textView_Student_id);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtStudentId.setText(details.getStudentId());
        viewHolder.txtEmail.setText(details.getEmail());
        viewHolder.txtName.setText(details.getName());
        viewHolder.txtContact.setText(details.getCotact());

        return convertView;
    }
}
