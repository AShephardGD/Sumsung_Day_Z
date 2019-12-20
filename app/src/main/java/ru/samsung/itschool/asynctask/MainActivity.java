package ru.samsung.itschool.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Stop, Start;
    ProgressBar progressBar;
    TextView text;
    LoadImage abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stop = (Button) findViewById(R.id.Stop);
        Start = (Button) findViewById(R.id.Start);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        text = (TextView) findViewById(R.id.text);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Делаем подсчеты значение", Toast.LENGTH_SHORT).show();
                abc  = new LoadImage();
                abc.execute();
            }
        });
        Stop.setOnClickListener(new View.OnClickListener() {
            boolean i = true;
            @Override
            public void onClick(View view) {
                if (i) {
                    Toast.makeText(MainActivity.this, "Останавливаем подсчет", Toast.LENGTH_SHORT).show();
                    i = false;
                    abc.Pause();
                }
                else{
                    Toast.makeText(MainActivity.this, "Продолжаем подсчет", Toast.LENGTH_SHORT).show();
                    i = true;
                    abc.Resume();
                }
            }
        });
    }
    private class LoadImage extends AsyncTask<Void, Integer, Void> {
        private double sum;
        boolean j = false;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Void... args) {
            for (int i = 0; i < 100; i += 10) {
                try {
                    while (j) {
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);
                    publishProgress(i);
                    sum += Math.random() * 10;
                    while (j) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(100);
            return null;
        }
        protected void onPostExecute(Void image) {
            text.setText("Подсчет завершен:" + sum + "%");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            text.setText("Выполнено : " + values[0] + "/100");
        }
        public void Pause() {
            j = true;
        }
        public void Resume() {
            j = false;
        }
    }
}