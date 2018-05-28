package com.example.aleksas.vestuvinisprojektas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText TextEmailAddress;
    private EditText TextPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextEmailAddress = findViewById(R.id.TextEmailAddress);
        TextPassword = findViewById(R.id.TextPassword);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnRegUser_Click(View v) {
    final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Please wait...", "Process...", true);
    (firebaseAuth.createUserWithEmailAndPassword(TextEmailAddress.getText().toString(), TextPassword.getText().toString()))
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();

                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registracija sėkminga", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                    else {
                        Log.e("Error", task.getException().toString());
                        Toast.makeText(RegisterActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });
}
}
