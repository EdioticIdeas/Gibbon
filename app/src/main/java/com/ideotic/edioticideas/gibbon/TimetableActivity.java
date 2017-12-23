package com.ideotic.edioticideas.gibbon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import STUDENT.StuTimeTable;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import Util.RequestedType;

import static com.ideotic.edioticideas.gibbon.ServerDatabase.ipAddress;
import static com.ideotic.edioticideas.gibbon.ServerDatabase.portNumber;

public class TimetableActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Thread timetableThread = null;
    Response response;
    public static ArrayList<StuTimeTable> list;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        setTitle("Time Table");

        // initializeTimeTable();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chat :) coming soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timetable, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           switch(position){
               case 0:
                   Monday monday = new Monday();
                   return monday;
               case 1:
                   Tuesday tuesday = new Tuesday();
                   return tuesday;
               case 2:
                   Wednesday wednesday = new Wednesday();
                   return wednesday;
               case 3 :
                   Thursday thursday = new Thursday();
                   return thursday;
               case 4:
                   Friday friday = new Friday();
                   return friday;
               case 5:
                   Saturday saturday = new Saturday();
                   return saturday;
               default:
                   return null;
           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Monday";
                case 1:
                    return "Tuesday";
                case 2:
                    return "Wednesday";
                case 3:
                    return "Thursday";
                case 4:
                    return "Friday";
                case 5:
                    return "Saturday";
            }
            return null;
        }
    }

    public void initializeTimeTable() {
        timetableThread = new Thread() {
            @Override
            public void run() {
                ServerConnection connection = new ServerConnection(ipAddress, portNumber);
                Request request = new Request(null, null, null, RequestedType.STUTIMETABLE);
                try {
                    response = (Response) connection.read(request);
                    list = (ArrayList<StuTimeTable>) response.getRequestedObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timetableThread.start();
        while (timetableThread.isAlive()) ;
    }
}
