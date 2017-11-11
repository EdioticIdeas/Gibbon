package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Mukul on 20-04-2017.
 */

public class NoticeAdapter extends ArrayAdapter<Notice> {

    TextView date, time, noticeTitle, noticeBody;
    String timeAndDate[];

    public NoticeAdapter(Context context, ArrayList<Notice> notices) {
        super(context, 0, notices);
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtDate;
        TextView txtTime;
        TextView txtNoticeTitle;
        TextView txtNoticeBody;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Notice notice = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.notice_row, parent, false);

            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.textView_Notice_date);
            viewHolder.txtTime = (TextView) convertView.findViewById(R.id.textView_Notice_time);
            viewHolder.txtNoticeBody = (TextView) convertView.findViewById(R.id.textView_Notice_body);
            viewHolder.txtNoticeTitle = (TextView) convertView.findViewById(R.id.textView_Notice_title);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtDate.setText(notice.getDate());
        viewHolder.txtTime.setText(notice.getTime());
        viewHolder.txtNoticeTitle.setText(notice.getTitle());
        viewHolder.txtNoticeBody.setText(notice.getBody());

        return convertView;
    }
}
