package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static Character hero;
    public static Story story;
    public EditText ed;
    public TextView tw1, tw2;
    public Button bt, fw, sw, tw;
    public ImageView pic;
    int left, right;
    String st, sj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        ed = (EditText) findViewById(R.id.editText);
        bt = (Button) findViewById(R.id.button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        story = new Story();
                        st = ed.getText().toString();
                        hero = new Character(st);
                        setContentView(R.layout.activity_main);
                        tw1 = (TextView) findViewById(R.id.Subject);
                        tw2 = (TextView) findViewById(R.id.Text);
                        fw = (Button) findViewById(R.id.First_way);
                        sw = (Button) findViewById(R.id.Second_way);
                        tw = (Button) findViewById(R.id.Third_way);
                        tw1.setText(story.current_situation.subject);
                        tw2.setText(story.current_situation.text);
                        fw.setText(story.current_situation.ways[0]);
                        sw.setText(story.current_situation.ways[1]);
                        tw.setText(story.current_situation.ways[2]);
                        left = R.drawable.khulhy;
                        right = R.drawable.venty;
                        View.OnClickListener lr = new View.OnClickListener(){
                            @Override
                            public void onClick(View w) {
                                switch (w.getId()) {
                                    case R.id.First_way:
                                        story.go(1);
                                        setContentView(R.layout.death);
                                        pic = (ImageView) findViewById(R.id.Picture);
                                        pic.setImageResource(left);
                                        tw1 = (TextView) findViewById(R.id.textView2);
                                        tw2 = (TextView) findViewById(R.id.textView3);
                                        tw1.setText(story.current_situation.subject);
                                        tw2.setText(story.current_situation.text);
                                        bt = (Button) findViewById(R.id.button2);
                                        View.OnClickListener l = new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                switch (v.getId()){
                                                    case R.id.button2:
                                                        onRestart();
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                        };
                                        bt.setOnClickListener(l);
                                        break;
                                    case R.id.Second_way:
                                        story.go(2);
                                        if(story.current_situation.direction.length == 0) {
                                            setContentView(R.layout.death);
                                            pic = (ImageView) findViewById(R.id.Picture);
                                            tw1 = (TextView) findViewById(R.id.textView2);
                                            tw2 = (TextView) findViewById(R.id.textView3);
                                            pic.setImageResource(R.drawable.c42);
                                        }
                                        tw1.setText(story.current_situation.subject);
                                        tw2.setText(story.current_situation.text);
                                        left = R.drawable.imgpreview;
                                        right = R.drawable.scp173;
                                        break;
                                    case R.id.Third_way:
                                        story.go(3);
                                        setContentView(R.layout.death);
                                        pic = (ImageView) findViewById(R.id.Picture);
                                        tw1 = (TextView) findViewById(R.id.textView2);
                                        tw2 = (TextView) findViewById(R.id.textView3);
                                        pic.setImageResource(right);
                                        tw1.setText(story.current_situation.subject);
                                        tw2.setText(story.current_situation.text);
                                        bt = (Button) findViewById(R.id.button2);
                                        View.OnClickListener le = new View.OnClickListener(){

                                            @Override
                                            public void onClick(View x) {
                                                switch(x.getId()) {
                                                    case R.id.button2:
                                                        onDestroy();
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                        };
                                        bt.setOnClickListener(le);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        };
                        fw.setOnClickListener(lr);
                        sw.setOnClickListener(lr);
                        tw.setOnClickListener(lr);
                        break;

                }
            }
        };
        bt.setOnClickListener(listener);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

