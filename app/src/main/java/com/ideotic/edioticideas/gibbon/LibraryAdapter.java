package com.ideotic.edioticideas.gibbon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mukul on 29-04-2017.
 */

public class LibraryAdapter extends ArrayAdapter<IssuedBooks> {

    int a;

    public LibraryAdapter(Context context, ArrayList<IssuedBooks> books, int no) {
        super(context, 0, books);
        a = no;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtDueDate = null;
        TextView txtIssuedDate = null;
        TextView txtBookName = null;
        TextView txtAuthor = null;
        TextView txtNoOfCopies = null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        IssuedBooks issuedBooks = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag

        if (a == 1) {
            if (convertView == null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.book_row, parent, false);
                viewHolder.txtBookName = (TextView) convertView.findViewById(R.id.textView_library_bookName);
                viewHolder.txtDueDate = (TextView) convertView.findViewById(R.id.textView_library_dueDate);
                viewHolder.txtIssuedDate = (TextView) convertView.findViewById(R.id.textView_library_issueDate);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.txtBookName.setText(issuedBooks.getBookName());
            viewHolder.txtDueDate.setText(issuedBooks.getBookReturnDate());
            viewHolder.txtIssuedDate.setText(issuedBooks.getBookIssuedOnDate());
        } else if (a == 2) {
            if (convertView == null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.book_row_search, parent, false);
                viewHolder.txtBookName = (TextView) convertView.findViewById(R.id.textView_library_bookName);
                viewHolder.txtAuthor = (TextView) convertView.findViewById(R.id.textView_library_authorName);
                viewHolder.txtNoOfCopies = (TextView) convertView.findViewById(R.id.textView_library_noOfCopies);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.txtBookName.setText(issuedBooks.getBookName());
            viewHolder.txtAuthor.setText(issuedBooks.getBookAuthor());
            viewHolder.txtNoOfCopies.setText(issuedBooks.getBookCopies());
        }

        return convertView;
    }
}
