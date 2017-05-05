package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 28-04-2017.
 */

public class FacultyListAdapter extends ArrayAdapter<FacultyDetails> {


    public FacultyListAdapter(Context context, ArrayList<FacultyDetails> details) {
        super(context, 0, details);
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtEmail;
        TextView txtDepartment;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FacultyDetails details = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.faculty_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textView_Faculty_Name);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.textView_Faculty_email);
            viewHolder.txtDepartment = (TextView) convertView.findViewById(R.id.textView_Faculty_depart);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtDepartment.setText(details.getDepartment());
        viewHolder.txtEmail.setText(details.getEmail());
        viewHolder.txtName.setText(details.getName());
        return convertView;
    }


}
