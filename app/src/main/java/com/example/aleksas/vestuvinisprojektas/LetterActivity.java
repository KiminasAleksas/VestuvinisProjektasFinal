package com.example.aleksas.vestuvinisprojektas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class LetterActivity extends AppCompatActivity {
    private EditText To;
    private EditText Subject;
    private EditText Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);

        To = findViewById(R.id.paslaugosEmail);
        Subject = findViewById(R.id.Tema);
        Message = findViewById(R.id.žinutė);

        Button btnSend = findViewById(R.id.Button_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String RecipientList = To.getText().toString();
                String[] recipients = RecipientList.split(",");
                String sub = Subject.getText().toString();
                String mes = Message.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, mes);

                intent.setType("message/rfc822");
                startActivity(intent.createChooser(intent, "Choose an email client"));
            }
        });
    }
}
