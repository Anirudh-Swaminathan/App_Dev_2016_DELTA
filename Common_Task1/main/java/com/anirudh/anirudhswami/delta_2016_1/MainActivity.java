package com.anirudh.anirudhswami.delta_2016_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int a;
    int color;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null && savedInstanceState.containsKey("color") && savedInstanceState.containsKey("counter")){
            color = savedInstanceState.getInt("color");
            a = savedInstanceState.getInt("counter");

            TextView tv = (TextView) findViewById(R.id.count);
            tv.setText(Integer.toString(a));

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            if (width < height) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutRel);
                relativeLayout.setBackgroundColor(color);
            } else {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutLin);
                linearLayout.setBackgroundColor(color);
            }

        }

        ((Button) findViewById(R.id.inc)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.count);
                String s = tv.getText().toString();
                a = Integer.parseInt(s);
                a++;
                s = Integer.toString(a);
                tv.setText(s);

                //Colour Changing Part
                Random rnd = new Random();
                color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                //Checking for the current orientation
                //Display getOri = getWindowManager().getDefaultDisplay();

                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int height = displaymetrics.heightPixels;
                int width = displaymetrics.widthPixels;

                if (width < height) {
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutRel);
                    relativeLayout.setBackgroundColor(color);
                } else {
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutLin);
                    linearLayout.setBackgroundColor(color);
                }
            }
        });
        ((Button) findViewById(R.id.reset)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.count);
                tv.setText(Integer.toString(0));
                a = 0;
            }
        });
        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        a = sharedPref.getInt("a",0);
        color = sharedPref.getInt("color",0);
        ((TextView) findViewById(R.id.count)).setText(Integer.toString(a));
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        if (width < height) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutRel);
            relativeLayout.setBackgroundColor(color);
        } else {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutLin);
            linearLayout.setBackgroundColor(color);
        }
    }

    //Implementing the save when rotate function

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        outState.putInt("counter",a);
        outState.putInt("color", color);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("a",a);
        editor.putInt("color",color);
        editor.apply();

        Toast.makeText(MainActivity.this,"Saved!!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}