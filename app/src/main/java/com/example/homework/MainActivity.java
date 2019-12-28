package com.example.homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_C = 0;
    private EditText login, password;
    String[] logins, passwords;
    boolean log = false, pass = false;
    TextView result;
    Button enter, reg, exit, delus, del;
    private SharedPreferences sPref;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logins = new String[] {};
        passwords = new String[] {};
        login = findViewById(R.id.coefficient_a);
        password =  findViewById(R.id.editText9);
        enter = findViewById(R.id.button);
        reg = findViewById(R.id.button11);
        result = findViewById(R.id.result);
        exit = findViewById(R.id.button8);
        delus = findViewById(R.id.button10);
        del = findViewById(R.id.button20);
        LoadText();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()){
                    case R.id.button:
                        log = false;
                        pass = false;
                        for (int j = 0; j < logins.length; j++) {
                            if (logins[j].equals(login.getText().toString())) {
                                log = true;
                                if (passwords[j].equals(password.getText().toString())) {
                                    pass = true;
                                    break;
                                }
                            }
                        }
                        if (log && pass) {
                            result.setTextColor(Color.GREEN);
                            result.setText("Верно");
                            i = new Intent(MainActivity.this, dnevnik.class);
                            i.putExtra("log", login.getText().toString());
                            startActivity(i);
                        }
                        else if (log) {
                            result.setTextColor(Color.MAGENTA);
                            result.setText("Пароль неверный");
                        }
                        else {
                            result.setTextColor(Color.RED);
                            result.setText("Пользователя с данным именем не существует. Не хотели бы вы зарегистрироваться?");
                        }
                        break;
                    case R.id.button11:
                        i = new Intent(MainActivity.this, Registration.class);
                        i.putExtra("logins", logins);
                        i.putExtra("passwords", passwords);
                        startActivityForResult(i,REQ_C);
                        break;
                    case R.id.button8:
                        finish();
                        break;
                    case R.id.button10:
                        i = new Intent(MainActivity.this, Delusers.class);
                        i.putExtra("logins", logins);
                        i.putExtra("passwords", passwords);
                        startActivity(i);
                        break;
                    case R.id.button20:
                        log = false;
                        pass = false;
                        for (int j = 0; j < logins.length; j++){
                            if (logins[j].equals(login.getText().toString())){
                                log = true;
                                if(passwords[j].equals(password.getText().toString())) {
                                    pass = true;
                                    break;
                                }
                            }
                        }
                        if (log && pass) {
                            result.setTextColor(Color.GREEN);
                            result.setText("Пользователь удален!");
                            logins = DelEl(logins, login.getText().toString());
                            passwords = DelEl(passwords, password.getText().toString());
                            removeMemory(login.getText().toString());
                        }
                        else if (log) {
                            result.setTextColor(Color.MAGENTA);
                            result.setText("Пароль неверный");
                        }
                        else {
                            result.setTextColor(Color.RED);
                            result.setText("Пользователя с данным именем не существует.");
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        enter.setOnClickListener(listener);
        reg.setOnClickListener(listener);
        exit.setOnClickListener(listener);
        delus.setOnClickListener(listener);
        del.setOnClickListener(listener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                login.setText(data.getStringExtra("login"));
                password.setText("");
                logins = NewEl(logins, data.getStringExtra("login"));
                passwords = NewEl(passwords, data.getStringExtra("pass"));
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
        ed.putInt("loglen", logins.length);
        for(int i = 0; i < logins.length; i++) {
            String j = Integer.toString(i);
            ed.putString("log" + j, logins[i]);
            ed.putString("pass" + j, logins[i]);
        }
        ed.putString("login", login.getText().toString());
        ed.putString("password",password.getText().toString());
        ed.commit();
    }
    void LoadText() {
        sPref = getPreferences(MODE_PRIVATE);
        logins = new String[sPref.getInt("loglen", 1)];
        passwords = new String[sPref.getInt("loglen", 1)];
        for(int i = 0; i < logins.length; i++) {
            String j = Integer.toString(i);
            logins[i] = sPref.getString("log" + j, "");
            passwords[i] = sPref.getString("pass" + j, "");
        }
        login.setText(sPref.getString("login", ""));
        password.setText(sPref.getString("password", ""));
    }
    String[] NewEl(String[] a, String c) {
        String[] b = new String[a.length + 1];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        b[a.length] = c;
        return b;
    }
    String[] DelEl(String[] a, String c){
        String[] b = new String[a.length - 1];
        int i = 0, j = 0;
        while (i < a.length){
            if(a[i].equals(c)) {
                i++;
            }
            if (i == a.length) break;
            b[j] = a[i];
            j++;
            i++;
        }
        return b;
    }
    void removeMemory(String log) {
        sPref.edit().remove(log);
        sPref.edit().remove(log + "mon" + "amount");
        sPref.edit().remove(log + "mon" + "chet");
        sPref.edit().remove(log + "tue" + "amount");
        sPref.edit().remove(log + "tue" + "chet");
        sPref.edit().remove(log + "wed" + "amount");
        sPref.edit().remove(log + "wed" + "chet");
        sPref.edit().remove(log + "thur" + "amount");
        sPref.edit().remove(log + "thur" + "chet");
        sPref.edit().remove(log + "fri" + "amount");
        sPref.edit().remove(log + "fri" + "chet");
        sPref.edit().remove(log + "sat" + "amount");
        sPref.edit().remove(log + "sat" + "chet");
        sPref.edit().remove(log + "sun" + "amount");
        sPref.edit().remove(log + "sun" + "chet");
        for (int i = 0; i < 20; i++) {
            sPref.edit().remove(log + "mon" + i);
            sPref.edit().remove(log + "mon" + "z" + i);
            sPref.edit().remove(log + "tue" + i);
            sPref.edit().remove(log + "tue" + "z" + i);
            sPref.edit().remove(log + "wed" + i);
            sPref.edit().remove(log + "wed" + "z" + i);
            sPref.edit().remove(log + "thur" + i);
            sPref.edit().remove(log + "thur" + "z" + i);
            sPref.edit().remove(log + "fri" + i);
            sPref.edit().remove(log + "fri" + "z" + i);
            sPref.edit().remove(log + "sat" + i);
            sPref.edit().remove(log + "sat" + "z" + i);
            sPref.edit().remove(log + "sun" + i);
            sPref.edit().remove(log + "sun" + "z" + i);
        }
        sPref.edit().commit();
    }
}
