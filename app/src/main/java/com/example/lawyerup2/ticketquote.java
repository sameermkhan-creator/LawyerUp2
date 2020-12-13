package com.example.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
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

    }

}
