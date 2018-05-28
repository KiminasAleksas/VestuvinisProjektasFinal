package com.example.aleksas.vestuvinisprojektas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenuActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        auth = FirebaseAuth.getInstance();
    }
    public void btnPhoto_Click(View v){
        Intent i = new Intent(MainMenuActivity.this, PhotographerActivity.class);
        startActivity(i);
    }

    public void btnVestViet_Click(View v){
        Intent i = new Intent(MainMenuActivity.this, PlaceActivity.class);
        startActivity(i);
    }

    public void btnVedej_Click(View v){
        Intent i = new Intent(MainMenuActivity.this, HostActivity.class);
        startActivity(i);
    }

    public void btnVart_Click(View v){
        Intent i = new Intent(MainMenuActivity.this, AccountActivity.class);
        startActivity(i);
    }
}
