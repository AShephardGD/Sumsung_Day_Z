package com.example.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeMonday extends AppCompatActivity {
    Button back, change, ChangeNum, exit;
    EditText num, ed;
    int[] ids;
    int amount;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_schedule);
        amount = getIntent().getIntExtra("amount", 0);
        ids = new int[] {R.id.el1, R.id.el2, R.id.el3, R.id.el4, R.id.el5, R.id.el6, R.id.el7, R.id.el8, R.id.el9, R.id.el10, R.id.el11, R.id.el12, R.id.el13, R.id.el14, R.id.el15, R.id.el16, R.id.el17, R.id.el18, R.id.el19, R.id.el20};
        change = findViewById(R.id.Change);
        back = findViewById(R.id.ClearAll);
        ChangeNum = findViewById(R.id.ChangeLessons);
        num = findViewById(R.id.editText2);
        exit = findViewById(R.id.button14);
        for (int j = 0; j < amount; j++) {
            ed = findViewById(ids[j]);
            ed.setVisibility(View.VISIBLE);
            ed.setText(getIntent().getStringExtra("lesson" + j));
        }
        for (int j = amount; j < 20; j++) {
            ed = findViewById(ids[j]);
            ed.setVisibility(View.GONE);
        }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                switch (view.getId()) {
                    case R.id.Change:
                        for (int j = 0; j < amount; j++){
                            ed = findViewById(ids[j]);
                            i.putExtra(Integer.toString(j), ed.getText().toString());
                        }
                        i.putExtra("amount", amount);
                        setResult(RESULT_OK, i);
                        finish();
                        break;
                    case R.id.ClearAll:
                        for (int j = 0; j < amount; j++) {
                            ed = findViewById(ids[j]);
                            ed.setText("");
                        }
                        break;
                    case R.id.ChangeLessons:
                        if (Integer.parseInt(num.getText().toString()) <= 20 && Integer.parseInt(num.getText().toString()) > -1) {
                            amount = Integer.parseInt(num.getText().toString());
                            for (int j = 0; j < amount; j++) {
                                ed = findViewById(ids[j]);
                                ed.setVisibility(View.VISIBLE);
                            }
                            for (int j = amount; j < 20; j++) {
                                ed = findViewById(ids[j]);
                                ed.setVisibility(View.GONE);
                            }
                        }
                        else Toast.makeText(getApplicationContext(),
                                "Выберите другое число, от 0 до 20", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button14:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
        change.setOnClickListener(listener);
        back.setOnClickListener(listener);
        ChangeNum.setOnClickListener(listener);
        exit.setOnClickListener(listener);
    }
}
