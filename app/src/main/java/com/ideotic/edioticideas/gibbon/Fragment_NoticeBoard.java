package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.NoticeList;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NoticeBoard extends Fragment {

    ListView list;
    NoticeAdapter noticeAdapter;
    ArrayList<Notice> notices;
    ArrayList<NoticeList> listNotice;
    Thread serverThread;

    public Fragment_NoticeBoard() {
        // Required empty public constructor
    }


    View view;

    @Override
    public void onStart() {

        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment__notice_board, container, false);
        list = (ListView) view.findViewById(R.id.listView_notice);

        getNoticeData();

        noticeAdapter = new NoticeAdapter(getActivity(), notices);
        list.setAdapter(noticeAdapter);

        return view;
    }


    public void getNoticeData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, null, RequestedType.NOTICE);
                    Response res = (Response) connection.read(req);
                    listNotice = (ArrayList<NoticeList>) res.getRequestedObject();
                    notices = new ArrayList<>();
                    for (NoticeList notice : listNotice) {
                        String[] datetime = notice.getId().split(",");
                        notices.add(new Notice(notice.getTitle(), notice.getDetails(), datetime[0], datetime[1]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        serverThread.start();
        while (serverThread.isAlive()) ;
    }

}
