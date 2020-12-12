package com.example.lawyerup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    EditText personEmail, personPassword, personName;
    Button registerAccountBtn, loginAccountbtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        t = (TextView)findViewById(R.id.login);
        //Go to Main Activity Three

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        personEmail = findViewById(R.id.Email);
        personPassword = findViewById(R.id.Password);
        personName = findViewById(R.id.fullName);
        registerAccountBtn = findViewById(R.id.signupbutton);
        loginAccountbtn = findViewById(R.id.loginbutton);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        registerAccountBtn.setOnClickListener(v -> {
            String email = personEmail.getText().toString().trim();
            String password = personPassword.getText().toString().trim();


            if (TextUtils.isEmpty(email)) {
                personEmail.setError("Email Required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                personPassword.setError("Password Required");
            }
            if (password.length() < 6) {
                personPassword.setError("Password must be >= 6 Characters");
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });


    }
}














