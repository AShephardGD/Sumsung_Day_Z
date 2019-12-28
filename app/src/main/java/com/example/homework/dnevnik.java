package com.example.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class dnevnik extends AppCompatActivity {
    Button monday, tuesday, wednesday, thursday, friday,exit, saturday, sunday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnevnik);
        monday = findViewById(R.id.button2);
        tuesday = findViewById(R.id.button3);
        wednesday = findViewById(R.id.button4);
        thursday = findViewById(R.id.button5);
        friday = findViewById(R.id.button6);
        saturday = findViewById(R.id.button18);
        sunday = findViewById(R.id.button19);
        exit = findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()){
                    case R.id.button2:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "mon");
                        startActivity(i);
                        break;
                    case R.id.button3:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "tue");
                        startActivity(i);
                        break;
                    case R.id.button4:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "wed");
                        startActivity(i);
                        break;
                    case R.id.button5:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "thur");
                        startActivity(i);
                        break;
                    case R.id.button6:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "fri");
                        startActivity(i);
                        break;
                    case R.id.button18:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "sat");
                        startActivity(i);
                        break;
                    case R.id.button19:
                        i = new Intent(dnevnik.this, Monday.class);
                        i.putExtra("log", getIntent().getStringExtra("log") + "sun");
                        startActivity(i);
                        break;
                    case R.id.button7:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
        monday.setOnClickListener(listener);
        tuesday.setOnClickListener(listener);
        wednesday.setOnClickListener(listener);
        thursday.setOnClickListener(listener);
        friday.setOnClickListener(listener);
        saturday.setOnClickListener(listener);
        sunday.setOnClickListener(listener);
        exit.setOnClickListener(listener);
    }
}
