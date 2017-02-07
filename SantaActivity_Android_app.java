package com.java21days.santa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SantaActivity extends AppCompatActivity {
    // all activities in AppCompatActivity contain behavior to display screen,
    // receive user input, and save user preferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // when class loads
        super.onCreate(savedInstanceState);                 // calls same method in superclass
        setContentView(R.layout.activity_santa);            // display screen layout method with (instance var)
    }                                                       // activity_santa is resource ID with extension removed

    // R refers to R.java from Android Studio automatically created
    public void processClicks(View display) {             // visual displays object
        Intent action = null;
        int id = display.getId();                       // returns ID of button clicked

        switch (id) {
            case (R.id.imageButton):
                action = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:877-446-6723"));
                break;
            case (R.id.imageButton2):
                action = new Intent(Intent.ACTION_VIEW, Uri.parse("http://noradsanta.org"));
                break;
            case (R.id.imageButton3):
                action = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0, 0?q=101 Saint Nicholas Dr., North Pole, Ak"));
                break;
            default:
                break;
            }
        startActivity(action);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        getMenuInflater().inflate(R.menu.menu_santa, menu);
        return true;
    }

    @Override
    public boolean opOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on Home/Up button, so long as
        // specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
