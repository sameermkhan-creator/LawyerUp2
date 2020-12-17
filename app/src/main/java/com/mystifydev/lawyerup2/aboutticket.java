package com.mystifydev.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.ToggleButton;

public class aboutticket extends AppCompatActivity {
    DatePicker ticketDate;
    DatePicker courtDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutticket);
        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        ToggleButton accidentButton = (ToggleButton) findViewById(R.id.accidentButton);
        myEdit.putString("accident", "NO");
        accidentButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myEdit.putString(
                            "accident",
                            "YES");
                } else {
                    myEdit.putString(
                            "accident",
                            "NO");              }
            }
        });

        ToggleButton driverButton = (ToggleButton) findViewById(R.id.driverButton);
        myEdit.putString("driver", "NO");
        driverButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myEdit.putString(
                            "driver",
                            "YES");
                } else {
                    myEdit.putString(
                            "driver",
                            "NO");              }
            }
        });

        ticketDate=(DatePicker)findViewById(R.id.ticketDate);
        courtDate=(DatePicker)findViewById(R.id.courtDate);
        courtDate.setVisibility(View.INVISIBLE);
        String test2 = "No Scheduled Date";
        myEdit.putString(
                "courtdate",
                test2);
        Switch sw = (Switch) findViewById(R.id.courtSwitch);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    courtDate.setVisibility(View.VISIBLE);
                    String test2 = courtDate.getDayOfMonth() + "/" + (courtDate.getMonth() + 1) + "/" + courtDate.getYear();
                    myEdit.putString(
                            "courtdate",
                            test2);
                } else {
                    courtDate.setVisibility(View.INVISIBLE);
                    myEdit.putString(
                            "courtdate",
                            test2);
                }
            }
        });

        Button btn4 = findViewById(R.id.aboutcontinue);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String test = ticketDate.getDayOfMonth() + "/" + (ticketDate.getMonth() + 1) + "/" + ticketDate.getYear();

                myEdit.putString(
                        "ticketdate",
                        test);

                myEdit.commit();
                next();
            }
        });
    }

    public void next(){
        Intent intent = new Intent(getApplicationContext(), ticketassigned.class);
        startActivity(intent);
    }
}