package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NoticeBoard extends Fragment {

    ListView list;
    NoticeAdapter noticeAdapter;
    ArrayList<Notice> notices;

    public Fragment_NoticeBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        notices = new ArrayList<>();
        notices.add(new Notice("Holidays", "Holidays starting from 24 th of june 2017 to 25 of july.", "Oct 24", "12:24 A.M."));
        notices.add(new Notice("Holidays", "Holidays starting from 24 th of june 2017 to 25 of july.", "Oct 24", "12:24 A.M."));
        notices.add(new Notice("Holidays", "Holidays starting from 24 th of june 2017 to 25 of july.", "Oct 24", "12:24 A.M."));

        noticeAdapter = new NoticeAdapter(getActivity(), notices);

        list = new ListView(getActivity());
        list.setAdapter(noticeAdapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__notice_board, container, false);
    }

}
