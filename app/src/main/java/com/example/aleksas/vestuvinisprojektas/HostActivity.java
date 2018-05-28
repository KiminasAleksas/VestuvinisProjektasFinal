package com.example.aleksas.vestuvinisprojektas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HostActivity extends AppCompatActivity {

    RecyclerView mRecycleView;
    FirebaseDatabase mFireDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Vedėjas");

        mRecycleView = findViewById(R.id.FotoList);
        mRecycleView.setHasFixedSize(true);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mFireDatabase = FirebaseDatabase.getInstance();
        mRef = mFireDatabase.getReference("Vedėjas");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getVardas(), model.getAprašas(), model.getNuotrauka(), model.getPaštas());
                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(HostActivity.this, LetterActivity.class);
                                startActivity(i);
                            }
                        });
                    }
                };
        mRecycleView.setAdapter(firebaseRecyclerAdapter);
    }
}
