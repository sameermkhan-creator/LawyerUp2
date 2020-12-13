package com.example.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ticketquote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketquote);
        SharedPreferences sh
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        String s1 = sh.getString("where", "");
        TextView err = (TextView)findViewById(R.id.textView14);
        err.setText(s1);
        String s2 = sh.getString("assigned", "");
        TextView err1 = (TextView)findViewById(R.id.textView15);
        err1.setText(s2);
        String ticketDate = sh.getString("ticketdate", "");
        TextView ticketdate = (TextView)findViewById(R.id.ticketDate);
        ticketdate.setText(ticketDate);
        String courtDate = sh.getString("courtdate", "");
        TextView courtdate = (TextView)findViewById(R.id.courtDate);
        courtdate.setText(courtDate);
        Button btn4 = findViewById(R.id.exitCase);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next();
            }
        });

    }

    public void next(){
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
