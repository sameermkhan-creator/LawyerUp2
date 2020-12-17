package com.mystifydev.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class numviolations extends AppCompatActivity {
     int numberofviolations = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numviolations);

        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();

        TextView violationsTV = (TextView)findViewById(R.id.numViolations);
        violationsTV.setText(""+numberofviolations);
        FloatingActionButton add = findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberofviolations+=1;
                violationsTV.setText(""+numberofviolations);
                myEdit.putString(
                        "violations",
                        ""+numberofviolations);
            }
        });

        FloatingActionButton sub = findViewById(R.id.subButton);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberofviolations-=1;
                violationsTV.setText(""+numberofviolations);
                myEdit.putString(
                        "violations",
                        ""+numberofviolations);
            }
        });

        myEdit.putString(
                "violations",
                ""+numberofviolations);

        Button btn4 = findViewById(R.id.violationscontinue);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.commit();
                next();
            }
        });
    }
    public void next(){
        Intent intent = new Intent(getApplicationContext(), aboutticket.class);
        startActivity(intent);
    }
}