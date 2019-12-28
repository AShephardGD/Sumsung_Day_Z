package com.example.homework;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zametki extends AppCompatActivity {
    int[] ids = new int[] {R.id.zam1, R.id.zam2, R.id.zam3, R.id.zam4, R.id.zam5, R.id.zam6, R.id.zam7, R.id.zam8, R.id.zam9, R.id.zam10, R.id.zam11, R.id.zam12, R.id.zam13, R.id.zam14, R.id.zam15, R.id.zam16, R.id.zam17, R.id.zam18, R.id.zam19, R.id.zam20};;
    Button exit, add, red;
    EditText edit;
    SharedPreferences sPref;
    int chet;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zameto4ka);
        add = findViewById(R.id.button15);
        red = findViewById(R.id.button16);
        exit = findViewById(R.id.button17);

        LoadText();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.button15:
                        if (chet < 20) {
                            edit = findViewById(ids[chet]);
                            edit.setVisibility(View.VISIBLE);
                            chet++;
                        }
                        else Toast.makeText(getApplicationContext(),
                                "Вы не можете больше прибавить заметок", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button16:
                        if(chet > 0) {
                            chet--;
                            edit = findViewById(ids[chet]);
                            edit.setText("");
                            edit.setVisibility(View.INVISIBLE);
                        }
                        else Toast.makeText(getApplicationContext(),
                                "Вы не можете больше удалить заметки", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button17:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
        add.setOnClickListener(listener);
        red.setOnClickListener(listener);
        exit.setOnClickListener(listener);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        SaveText();
    }
    void SaveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(getIntent().getStringExtra("log") + "chet", chet);
        for(int i = 0; i < 20; i++) {
            edit = findViewById(ids[i]);
            ed.putString(getIntent().getStringExtra("log")+ "z" + i, edit.getText().toString());
        }
        ed.commit();
    }
    void LoadText() {
        sPref = getPreferences(MODE_PRIVATE);
        chet = sPref.getInt(getIntent().getStringExtra("log") + "chet", 0);
        for (int j = 0; j < chet; j++) {
            edit = findViewById(ids[j]);
            edit.setVisibility(View.VISIBLE);
            edit.setText(sPref.getString(getIntent().getStringExtra("log") + "z" + j, ""));
        }
        for (int j = chet; j < 20; j++) {
            edit = findViewById(ids[j]);
            edit.setVisibility(View.GONE);
            edit.setText(sPref.getString(getIntent().getStringExtra("log") + "z" + j, ""));
        }
    }
}
