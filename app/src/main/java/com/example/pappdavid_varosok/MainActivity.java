package com.example.pappdavid_varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button list;
    private Button newdata;

    public static String BASE_URL = "https://retoolapi.dev/AAt5jw/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    init();
    list = (Button) findViewById(R.id.list);
    list.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
            finish();
        }
    });

    newdata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, InsertActivity.class));
        }
    });

    }



    private void init(){
    list = findViewById(R.id.list);
    newdata = findViewById(R.id.newdata);

    }
}