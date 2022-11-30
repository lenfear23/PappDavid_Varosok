package com.example.pappdavid_varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button back;
    private Button add;
    private EditText nev;
    private EditText orszag;
    private EditText lakossag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InsertActivity.this, MainActivity.class));
            }
        });

        if (nev.getText().length() < 1){
            add.setEnabled(false);
            Toast.makeText(this,"Név nem lehet üres",Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        back = findViewById(R.id.back);
        add = findViewById(R.id.add);
        nev = findViewById(R.id.nev);
        orszag = findViewById(R.id.orszag);
        lakossag = findViewById(R.id.lakossag);
    }
}