package com.mystifydev.lawyerup2.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mystifydev.lawyerup2.MainActivity;
import com.mystifydev.lawyerup2.R;
import com.mystifydev.lawyerup2.ticketwhere;
import com.mystifydev.lawyerup2.ui.home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;


public class SettingsFragment extends Fragment {
    Activity context;
    private SettingsViewModel settingsViewModel;
    private Button logoutBtn;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    FirebaseAuth fAuth;
    private static final String USERS = "users";
    String userID;
  // public String email2;
  TextView fullName, fullEmail;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();
        fAuth = FirebaseAuth.getInstance();
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        fullName = view.findViewById(R.id.profileEmailAddress);
        fullEmail = view.findViewById(R.id.profileFullName);
        //email2 = "test123456@gmail.com";
        String email2= fAuth.getCurrentUser().getEmail();
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(USERS);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    userID = fAuth.getCurrentUser().getUid();


                    if(ds.child("email").getValue().equals(email2)){
                        fullEmail.setText(ds.child("email").getValue(String.class));
                        fullName.setText(ds.child("name").getValue(String.class));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        return view;
    }




    public void logout() {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(this.getContext(), MainActivity.class));
    }

    public void onStart() {
        super.onStart();
        Button bt = (Button) context.findViewById(R.id.logoutButton);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //create an Intent object
        logout();
            }
        });


    }
}



