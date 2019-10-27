package ru.samsung.itschool.book.logcat231;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private static final String LOG_TAG = "Main_Activity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "Creating view..");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "View created!");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(LOG_TAG, "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(LOG_TAG, "Options Menu created!");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(LOG_TAG, "onOptionsItemSelected");
        int id = item.getItemId();

        Log.d(LOG_TAG, "getItemId");
        if (id == R.id.action_settings) {
            return true;
        }
        Log.d(LOG_TAG, "id == R.id.action_settings");
        return super.onOptionsItemSelected(item);
    }
}
