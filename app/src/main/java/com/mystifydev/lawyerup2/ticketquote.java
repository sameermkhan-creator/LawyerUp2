package com.mystifydev.lawyerup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import io.perfmark.Tag;

public class ticketquote extends AppCompatActivity {
   // EditText personEmail, personPassword, personName;
    Button createTicketBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketquote);

        createTicketBtn = findViewById(R.id.createCase);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
//maybe case number
        final int min = 1;
        final int max = 20000;
        final int random = new Random().nextInt((max - min) + 1) + min;

        SharedPreferences sh
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        String s1 = sh.getString("where", "");
        TextView err = (TextView) findViewById(R.id.textView14);
        err.setText(s1);

        String s2 = sh.getString("assigned", "");
        TextView err1 = (TextView) findViewById(R.id.textView15);
        err1.setText(s2);

        String ticketDate = sh.getString("ticketdate", "");
        TextView ticketdate = (TextView) findViewById(R.id.ticketDate);
        ticketdate.setText(ticketDate);

        String courtDate = sh.getString("courtdate", "");
        TextView courtdate = (TextView) findViewById(R.id.courtDate);
        courtdate.setText(courtDate);

        String accident = sh.getString("accident", "");
        TextView accidentTV = (TextView) findViewById(R.id.accident);
        accidentTV.setText(accident);

        String driver = sh.getString("driver", "");
        TextView driverTV = (TextView) findViewById(R.id.driver);
        driverTV.setText(driver);

        String violations = sh.getString("violations", "");
        TextView violationsTV = (TextView) findViewById(R.id.numOfViolations);
        violationsTV.setText("" + violations);

        createTicketBtn.setOnClickListener(v -> {
            userID = fAuth.getCurrentUser().getUid();
            DocumentReference documentReference = fStore.collection(userID).document(String.valueOf(random));

            Map<String, Object> data = new HashMap<>();
            data.put("Where", s1);
            data.put("Assigned", s2);
            data.put("TicketDate", ticketDate);
            data.put("CourtDate", courtDate);
            data.put("Accident", accident);
            data.put("Driver", driver);
            data.put("Violations", violations);
            data.put("CaseNumber", random);
           // data.put("User ID",userID);

documentReference.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(ticketquote.this, "Congrats your case has been submitted, sit back and relax while our lawyers take a look.", Toast.LENGTH_LONG).show();
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(ticketquote.this, "ERROR", Toast.LENGTH_SHORT).show();
    }
});


next();
        });

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

