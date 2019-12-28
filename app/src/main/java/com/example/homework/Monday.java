package com.example.homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Monday extends AppCompatActivity {
    private static final int REQ_C = 0;
    int amount;
    Button exit, change, cz;
    TextView tws[], tw;
    int[] ids;
    SharedPreferences sPref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        exit = findViewById(R.id.Exit);
        change = findViewById(R.id.changed);
        cz =  findViewById(R.id.editzametki);
        ids = new int[] {R.id.lesson1, R.id.lesson2, R.id.lesson3, R.id.lesson4, R.id.lesson5, R.id.lesson6, R.id.lesson7, R.id.lesson8, R.id.lesson9, R.id.lesson10, R.id.lesson11, R.id.lesson12, R.id.lesson13, R.id.lesson14, R.id.lesson15, R.id.lesson16, R.id.lesson17, R.id.lesson18, R.id.lesson19, R.id.lesson20};
        LoadText();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.changed:
                        i = new Intent(Monday.this, ChangeMonday.class);
                        i.putExtra("amount", amount);
                        for (int j = 0; j < amount; j++){
                            tw = findViewById(ids[j]);
                            i.putExtra("lesson" + j, tw.getText().toString());
                        }
                        startActivityForResult(i, REQ_C);
                        break;
                    case R.id.Exit:
                        finish();
                        break;
                    case R.id.editzametki:
                        i = new Intent(Monday.this, Zametki.class);
                        i.putExtra("log", getIntent().getStringExtra("log"));
                        startActivity(i);
                        break;
                    default:
                        break;
                }
            }
        };
        exit.setOnClickListener(listener);
        change.setOnClickListener(listener);
        cz.setOnClickListener(listener);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                amount =  data.getIntExtra("amount", 1);
                for(int i = 0; i < amount; i++){
                    tw = findViewById(ids[i]);
                    tw.setVisibility(View.VISIBLE);
                    tw.setText(data.getStringExtra(Integer.toString(i)));
                }
                for(int i = amount; i < 20; i++) {
                    tw = findViewById(ids[i]);
                    tw.setVisibility(View.GONE);
                    tw.setText("");
                }
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SaveText();
    }
    void SaveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(getIntent().getStringExtra("log") + "amount", amount);
        for(int i = 0; i < 20; i++) {
            tw = findViewById(ids[i]);
            ed.putString(getIntent().getStringExtra("log") + i, tw.getText().toString());
        }
        ed.commit();
    }
    void LoadText() {
        sPref = getPreferences(MODE_PRIVATE);
        amount = sPref.getInt(getIntent().getStringExtra("log") + "amount", 0);
        for (int j = 0; j < amount; j++) {
            tw = findViewById(ids[j]);
            tw.setVisibility(View.VISIBLE);
            tw.setText(sPref.getString(getIntent().getStringExtra("log") + j, ""));
        }
        for (int j = amount; j < 20; j++) {
            tw = findViewById(ids[j]);
            tw.setVisibility(View.GONE);
            tw.setText(sPref.getString(getIntent().getStringExtra("log") + j, ""));
        }
    }
}
