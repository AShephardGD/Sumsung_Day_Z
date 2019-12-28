package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends Activity {
    EditText et2, et1, et3;
    Button bt, exit;
    TextView tw;
    String[] logins, passwords;
    boolean in;
    int needed;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText10);
        et3 = findViewById(R.id.editText11);
        bt = findViewById(R.id.button);
        tw = findViewById(R.id.textView10);
        exit = findViewById(R.id.button9);
        logins = getIntent().getStringArrayExtra("logins");
        passwords = getIntent().getStringArrayExtra("passwords");
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.button:
                        in = false;
                        for (int j = 0; j < logins.length; j++) {
                            if (et1.getText().toString().equals(logins[j])) {
                                in = true;
                                needed = j;
                            }
                        }
                        if(in){
                            tw.setTextColor(Color.MAGENTA);
                            tw.setText("Учетная запись с таким логином уже существует!");
                        }
                        else if(et2.getText().toString().equals(et3.getText().toString())) {
                            tw.setTextColor(Color.GREEN);
                            tw.setText("Учетная запись создана!");
                            Intent i = new Intent();
                            i.putExtra("login", et1.getText().toString());
                            i.putExtra("pass", et2.getText().toString());
                            setResult(RESULT_OK, i);
                            finish();
                        }
                        else {
                            tw.setText("Пароли не совпадают, попробуйте еще раз!");
                            tw.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.button9:
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
