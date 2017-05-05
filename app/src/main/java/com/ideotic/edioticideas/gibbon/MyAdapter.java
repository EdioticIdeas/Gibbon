package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import USER.STAFF.AttendenceRow;

/**
 * Created by Mukul on 05-05-2017.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<AttendenceRow> list;
    Context context;

    public MyAdapter(Context context) {
        list = new ArrayList<>();
        list.add(new AttendenceRow("Shubham", "0203cs131044", false));
        list.add(new AttendenceRow("Mukul", "0203cs131026", false));
        list.add(new AttendenceRow("Mrityunjay", "0203cs131025", false));
        list.add(new AttendenceRow("Praveen", "0203cs131033", false));
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_takeattendance, null);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_Roll = (TextView) view.findViewById(R.id.tv_roll);
        TextView tv_init = (TextView) view.findViewById(R.id.tv_init);
        final TextView tv_P = (TextView) view.findViewById(R.id.tv_p);

        LinearLayout li = (LinearLayout) view.findViewById(R.id.li);
        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isPresent()) {

                    list.get(position).present = false;
                    tv_P.setText("A");
                } else {
                    list.get(position).present = true;
                    tv_P.setText("P");
                }
            }
        });

        tv_init.setText(String.valueOf(list.get(position).RollNumber.charAt(0)));
        tv_name.setText(list.get(position).Name);
        tv_Roll.setText(list.get(position).RollNumber);
        if (list.get(position).present) {
            tv_P.setText("P");
        } else {
            tv_P.setText("A");
        }
        //tv_name.setText(a[position]);
        return view;
    }
}
