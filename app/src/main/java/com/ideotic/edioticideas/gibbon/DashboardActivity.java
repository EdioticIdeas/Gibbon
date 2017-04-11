package com.ideotic.edioticideas.gibbon;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;


public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView userName, userId;
    private ImageView profilePic;
    NavigationView navigationView = null;
    Toolbar toolbar = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Setting Fragment initially.
        Fragment_Student_Dashboard stuDash = new Fragment_Student_Dashboard();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,stuDash);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chat :) Coming soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialize();
    }

    public void initialize() {
        userName = (TextView) findViewById(R.id.textView_nav_header_name);
        userId = (TextView) findViewById(R.id.textView_nav_header_userId);
        profilePic = (ImageView) findViewById(R.id.profile_image);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Fragment_Student_Profile stuProf = new Fragment_Student_Profile();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,stuProf);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_attendence) {


        } else if (id == R.id.nav_notice) {


        } else if (id == R.id.nav_calender) {


        } else if (id == R.id.nav_timeTable) {


        } else if (id == R.id.nav_faculty) {


        } else if (id == R.id.nav_fees) {


        }else if(id == R.id.nav_dashboard){
            Fragment_Student_Dashboard stuDash = new Fragment_Student_Dashboard();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,stuDash);
            fragmentTransaction.commit();

        }else if(id == R.id.nav_library){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Pie Chart Code
    public PieData getPieData(){

        ServerDatabase databse = new ServerDatabase();
        databse.getPieData();

        // Data axis for Pie Chart
         float[] yData = {databse.present,databse.absent,databse.holidays};
         String[] xData = {"Present %","Absent %","Holidays %"};


        ArrayList<Entry> yVals1 = new ArrayList<>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        // create pie data set
        PieDataSet dataSet = new PieDataSet(yVals1,"");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);


        // add many colors
        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#c6ff00"));
        colors.add(Color.parseColor("#f44336"));
        colors.add(Color.parseColor("#18ffff"));

        dataSet.setColors(colors);

        PieData pieData = new PieData(xVals,dataSet);
        return pieData;
    }
}
