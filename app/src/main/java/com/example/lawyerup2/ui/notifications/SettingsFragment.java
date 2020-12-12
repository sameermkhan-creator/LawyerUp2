package com.example.lawyerup2.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lawyerup2.MainActivity;
import com.example.lawyerup2.R;
import com.example.lawyerup2.ui.home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);



        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {




            @Override



            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    public void  logout(View view){
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(this.getContext(), MainActivity.class));
    }



}



