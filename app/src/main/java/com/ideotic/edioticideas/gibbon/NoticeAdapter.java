package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 20-04-2017.
 */

public class NoticeAdapter extends BaseAdapter{

    TextView date, time, noticeTitle, noticeBody;
    ArrayList<Notice> notices;
    Context context;

    public NoticeAdapter(Context context, ArrayList<Notice> notices) {
        this.context = context;
        this.notices = notices;
    }

    @Override
    public int getCount() {
        return notices.size();
    }

    @Override
    public Object getItem(int position) {
        return notices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Notice notice = notices.get(position);



            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.notice_row, null, false);
            date = (TextView) convertView.findViewById(R.id.textView_Notice_date);
            time = (TextView) convertView.findViewById(R.id.textView_Notice_time);
            noticeTitle = (TextView) convertView.findViewById(R.id.textView_Notice_title);
            noticeBody = (TextView) convertView.findViewById(R.id.textView_Notice_body);


        date.setText(notice.getDate());
        time.setText(notice.getTime());
        noticeTitle.setText(notice.getTitle());
        noticeBody.setText(notice.getBody());

        return view;
    }
}
