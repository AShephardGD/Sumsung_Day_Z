package ru.samsung.itschool.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edA,edB;
    TextView tw;
    Button add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edA = findViewById(R.id.et_a);
        edB = findViewById(R.id.et_b);
        tw = findViewById(R.id.tv_result);
        add = findViewById(R.id.btn_plus);
        sub = findViewById(R.id.btn_minus);
        mul = findViewById(R.id.btn_mult);
        div = findViewById(R.id.btn_div);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btn_plus:
                        tw.setText(" " + (Float.parseFloat(edA.getText().toString()) + Float.parseFloat(edB.getText().toString())));
                        break;
                    case R.id.btn_minus:
                        tw.setText(" " + (Float.parseFloat(edA.getText().toString()) - Float.parseFloat(edB.getText().toString())));
                        break;
                    case R.id.btn_mult:
                        tw.setText(" " + Float.parseFloat(edA.getText().toString()) * Float.parseFloat(edB.getText().toString()));
                        break;
                    case R.id.btn_div:
                        tw.setText(" " + Float.parseFloat(edA.getText().toString()) / Float.parseFloat(edB.getText().toString()));
                        break;
                }
            }
        };
        add.setOnClickListener(listener);
        sub.setOnClickListener(listener);
        mul.setOnClickListener(listener);
        div.setOnClickListener(listener);
    }
}
