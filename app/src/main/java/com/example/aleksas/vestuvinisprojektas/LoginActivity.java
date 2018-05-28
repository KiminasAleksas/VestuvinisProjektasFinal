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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText TextEmailAddressLogin;
    private EditText TextPasswordLogin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextEmailAddressLogin = findViewById(R.id.TextEmailAddressLogin);
        TextPasswordLogin = findViewById(R.id.TextPasswordLogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnLoginUser_Click(View v)
    {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please wait...", "Process...", true);

        (firebaseAuth.signInWithEmailAndPassword(TextEmailAddressLogin.getText().toString(), TextPasswordLogin.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Sėkmingai prisijungta!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
                    startActivity(i);
                }
                else {
                    Log.e("Error", task.getException().toString());
                    Toast.makeText(LoginActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

