package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 20-04-2017.
 */

public class NoticeAdapter extends ArrayAdapter<Notice> {

    TextView date, time, noticeTitle, noticeBody;

    public NoticeAdapter(Context context, ArrayList<Notice> notices) {
        super(context, 0, notices);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Notice notice = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notice_row, parent, false);

            date = (TextView) convertView.findViewById(R.id.textView_Notice_date);
            time = (TextView) convertView.findViewById(R.id.textView_Notice_time);
            noticeTitle = (TextView) convertView.findViewById(R.id.textView_Notice_title);
            noticeBody = (TextView) convertView.findViewById(R.id.textView_Notice_body);
        }

        date.setText(notice.getDate());
        time.setText(notice.getTime());
        noticeTitle.setText(notice.getTitle());
        noticeBody.setText(notice.getBody());

        return convertView;
    }
}
