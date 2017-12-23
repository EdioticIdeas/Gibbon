package com.ideotic.edioticideas.gibbon;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static EditText userName = null, password = null;
    private TextView uName, pass, fPass, signup, gibbon;
    private Button signIn;

    public static String userId = null, passWord = null;
    private static int verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);

        uName = (TextView) findViewById(R.id.textView_username);
        pass = (TextView) findViewById(R.id.textView_password);
        fPass = (TextView) findViewById(R.id.textView_fPass);
        signup = (TextView) findViewById(R.id.textView_signUp);
        gibbon = (TextView) findViewById(R.id.textView_gibbon);

        signIn = (Button) findViewById(R.id.button_signIn);

        final SpannableStringBuilder sb = new SpannableStringBuilder("Gibbon");

        // Span to set text color to some RGB value
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.parseColor("#E84A5F"));

        // Span to make text bold
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

        // Set the text color for characters
        sb.setSpan(fcs, 2, 3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        // make characters bold
        sb.setSpan(bss, 4, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        gibbon.setText(sb);

        userName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                uName.setTextColor(Color.parseColor("#E84A5F"));
                userName.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);

                return false;
            }
        });


        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pass.setTextColor(Color.parseColor("#E84A5F"));
                password.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);

                return false;
            }
        });

        fPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!uName.getText().equals("")) {
                    Toast.makeText(LoginActivity.this, "Password sent to registered email id.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Please enter correct user id.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        signup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(LoginActivity.this, "For Sign Up details please visit administration.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = userName.getText().toString().trim();
                passWord = password.getText().toString().trim();
                if (userId.equals("") || passWord.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter User Name and Password", Toast.LENGTH_SHORT).show();
                } else {
                    Fragment_Student_Profile.userid = userId;
                    ServerDatabase.userID = userId;
                    ServerDatabase checkLogin = new ServerDatabase();
                    verify = checkLogin.validate(userId, passWord);
                    if (verify == 0) {
                        Intent dash = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(dash);
                    } else if (verify == 1) {
                        Intent dash = new Intent(LoginActivity.this, TeacherDashboardActivity.class);
                        startActivity(dash);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid User Name or Password !", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
