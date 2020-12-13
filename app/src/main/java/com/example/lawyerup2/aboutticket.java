package com.example.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

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
        Button btn4 = findViewById(R.id.aboutcontinue);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketDate=(DatePicker)findViewById(R.id.ticketDate);
                courtDate=(DatePicker)findViewById(R.id.courtDate);
                String test = "Selected Date: " + ticketDate.getDayOfMonth() + "/" + (ticketDate.getMonth() + 1) + "/" + ticketDate.getYear();
                String test2 = "Selected Date: " + courtDate.getDayOfMonth() + "/" + (courtDate.getMonth() + 1) + "/" + courtDate.getYear();
                myEdit.putString(
                        "ticketdate",
                        test);
                myEdit.putString(
                        "courtdate",
                        test2);
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