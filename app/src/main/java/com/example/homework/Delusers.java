package com.example.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Delusers extends AppCompatActivity {
    TextView tw;
    Button bt,exit;
    EditText ed;
    String[] logins, passwords;
    String fortw = "";
    int needed;
    boolean log;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delusers);
        tw = findViewById(R.id.textView2);
        bt = findViewById(R.id.button12);
        exit = findViewById(R.id.button13);
        ed = findViewById(R.id.editText3);
        logins = getIntent().getStringArrayExtra("logins");
        passwords = getIntent().getStringArrayExtra("passwords");
        tw.setText(fortw);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                switch (v.getId()){
                    case R.id.button12:
                        log = false;
                        for (int j = 0; j < logins.length; j++) {
                            if (ed.getText().toString().equals(logins[j])) {
                                log = true;
                                needed = j;
                            }
                        }
                        if(log) {
                            tw.setText(passwords[needed]);
                        }
                        else Toast.makeText(getApplicationContext(),
                                "Такого логина не найдено!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button13:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
        bt.setOnClickListener(listener);
        exit.setOnClickListener(listener);
    }
}
