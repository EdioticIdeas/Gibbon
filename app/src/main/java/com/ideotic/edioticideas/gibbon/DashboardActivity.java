package com.ideotic.edioticideas.gibbon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView userName,userId;
    private ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialize();
    }

    public void initialize(){
        userName = (TextView)findViewById(R.id.textView_nav_header_name);
        userId = (TextView)findViewById(R.id.textView_nav_header_userId);
        profilePic = (ImageView)findViewById(R.id.profile_image);
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
            // Handle the camera action
           // SpannableString sAccent = new SpannableString("Profile");
           // sAccent.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, sAccent.length(), 0);
           // item.setTitle(sAccent);

        } else if (id == R.id.nav_attendence) {

            SpannableString s = new SpannableString("Attendance");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        } else if (id == R.id.nav_notice) {

            SpannableString s = new SpannableString("Notice Board");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        } else if (id == R.id.nav_calender) {

            SpannableString s = new SpannableString("Academic Calender");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        } else if (id == R.id.nav_timeTable) {

            SpannableString s = new SpannableString("Time Table");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        } else if (id == R.id.nav_faculty) {

            SpannableString s = new SpannableString("Faculty");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        }else if(id == R.id.nav_fees){

            SpannableString s = new SpannableString("Fees");
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#E84A5F")), 0, s.length(), 0);
            item.setTitle(s);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
