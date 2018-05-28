package com.example.aleksas.vestuvinisprojektas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

   private EditText n1;
   private EditText n2;
   private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        n1 = findViewById(R.id.naujas);
        n2 = findViewById(R.id.naujas2);
        auth = FirebaseAuth.getInstance();
    }


    public void Button_change(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(AccountActivity.this, "Please wait...", "Process...", true);
            if (n1.getText().toString().equals(n2.getText().toString())) {
                (auth.getCurrentUser().updatePassword(n1.getText().toString())).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(AccountActivity.this, "Sėkmingai pakeistas slaptažodis!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(AccountActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(AccountActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
    }

}

