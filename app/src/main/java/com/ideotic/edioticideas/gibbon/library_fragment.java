package com.ideotic.edioticideas.gibbon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.LIBRARY.Books;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class library_fragment extends Fragment {


    Thread serverThread;
    View view;
    ArrayList<IssuedBooks> booklist;
    ArrayList<IssuedBooks> searchResult;
    LibraryAdapter adapter;
    ListView listView;
    EditText searchBook;
    ImageButton search;
    ArrayList<Books> books;

    public library_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_library_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listView_library);
        search = (ImageButton) view.findViewById(R.id.imageButton_search);
        searchBook = (EditText) view.findViewById(R.id.search_book);

        booklist = new ArrayList<>();
        searchResult = new ArrayList<>();
        getLibraryData();


        adapter = new LibraryAdapter(getActivity(), booklist, 1);
        listView.setAdapter(adapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLibrarySearchData();
                adapter = new LibraryAdapter(getActivity(), searchResult, 2);
                listView.setAdapter(adapter);
            }
        });

        return view;
    }

    public void getLibraryData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, LoginActivity.userId, RequestedType.LIBRARYINVENTORY);
                    Response res = (Response) connection.read(req);
                    books = (ArrayList<Books>) res.getRequestedObject();
                    for (Books book : books) {
                        booklist.add(new IssuedBooks(book.getTitle(), book.getDueDate(), book.getIssueDate()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        serverThread.start();
        while (serverThread.isAlive()) ;
    }

    public void getLibrarySearchData() {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                    Request req = new Request(null, null, searchBook.getText().toString(), RequestedType.LIBRARYINVENTORY);
                    Response res = (Response) connection.read(req);
                    books = (ArrayList<Books>) res.getRequestedObject();
                    for (Books book : books) {
                        searchResult.add(new IssuedBooks(null, book.getTitle(), book.getAuthur(), book.getPublisher(), book.getBook_count()));
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
