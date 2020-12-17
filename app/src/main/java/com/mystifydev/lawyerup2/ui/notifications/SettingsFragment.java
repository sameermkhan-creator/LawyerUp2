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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mystifydev.lawyerup2.MainActivity;
import com.mystifydev.lawyerup2.R;
import com.mystifydev.lawyerup2.ticketwhere;
import com.mystifydev.lawyerup2.ui.home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {
    Activity context;
    private SettingsViewModel settingsViewModel;
    private Button logoutBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        context = getActivity();
        settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);


        settingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {


            @Override


            public void onChanged(@Nullable String s) {

            }
        });
        return root;
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



