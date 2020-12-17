package com.mystifydev.lawyerup2.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mystifydev.lawyerup2.R;
import com.mystifydev.lawyerup2.Where;
import com.mystifydev.lawyerup2.signup;
import com.mystifydev.lawyerup2.ticketwhere;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import static android.view.LayoutInflater.from;

public class DashboardFragment extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore firebaseFirestore;
    String userID;
    Activity context;
    FirestoreRecyclerOptions<model> options;
    private FirestoreRecyclerAdapter adapter;

    private RecyclerView mFirestoreList;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        firebaseFirestore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        context = getActivity();

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mFirestoreList = view.findViewById(R.id.firestore_list);

        //Query
        Query query = firebaseFirestore.collection(userID);
        //Recycler
        options = new FirestoreRecyclerOptions.Builder<model>().setQuery(query, model.class).build();
        adapter = new FirestoreRecyclerAdapter<model, ProductsViewHolder>(options) {


            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_layout, parent, false);
                return new ProductsViewHolder(view1);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull model model) {
               holder.caseNumber.setText(model.getCaseNumber()+" - Case #");
                holder.courtDate.setText(model.getCourtDate());
                holder.assignedWhere.setText(model.getAssigned());
            }
        };

/*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        */
        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFirestoreList.setAdapter(adapter);
        return view;
    }


    private class ProductsViewHolder extends RecyclerView.ViewHolder {
        private TextView caseNumber;
        private TextView courtDate;
        private TextView assignedWhere;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            caseNumber = itemView.findViewById(R.id.textViewCaseNumber);
            courtDate = itemView.findViewById(R.id.textViewCourtDate);
            assignedWhere = itemView.findViewById(R.id.textViewAssignedWhere);

        }
    }

    @Override
    public void onStop() {
        adapter.stopListening();
        super.onStop();
    }

    public void onStart() {
        super.onStart();
        adapter.startListening();
        Button bt = (Button) context.findViewById(R.id.ticketbutton);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //create an Intent object
                Intent intent = new Intent(context, ticketwhere.class);
                //start the second activity
                startActivity(intent);
            }
        });


    }
}
