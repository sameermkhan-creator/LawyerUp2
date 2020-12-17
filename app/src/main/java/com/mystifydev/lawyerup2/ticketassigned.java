package com.mystifydev.lawyerup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ticketassigned extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketassigned);
        t = (TextView)findViewById(R.id.cancel);
        //Go to Main Activity Three
        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        final ListView listview = (ListView) findViewById(R.id.listview1);
        String[] values = new String[] { "Toronto", "Vaughan", "Oakville",
                "Mississauga", "Markham", "Burlington", "Oshawa", "Brampton",
                "Milton", "Richmond Hill", "Ajax", "Pickering", "Whitby", "None" };
// Create a List from String Array elements
        final List<String> values_list = new ArrayList<String>(Arrays.asList(values));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, values_list);
        // DataBind ListView with items from ArrayAdapter
        listview.setAdapter(arrayAdapter);

//Go to Main Activity Three
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        listview.setClickable(true);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selectedFromList = (String) listview.getItemAtPosition(position);
                myEdit.putString(
                        "assigned",
                        selectedFromList);
                myEdit.commit();
next();
            }
        });
    }
    public void next(){
        Intent intent = new Intent(getApplicationContext(), ticketquote.class);
        startActivity(intent);

    }
}