package com.example.clubbingireland.clubbingireland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;

public class MainActivity extends ActionBarActivity {

    private Button enterbutton;
    private Button helpbutton;
    private Button aboutbutton;
    private Button contactbutton;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(MainActivity.this, R.raw.bg);
        mp.setLooping(true);
        mp.start();

        enterbutton = (Button) findViewById(R.id.enterbtn);
        enterbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Location_Choose.class);
                startActivityForResult(intent, 0);
            }
        });

        helpbutton = (Button) findViewById(R.id.helpbtn);
        helpbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), Help.class);
                startActivityForResult(intent2, 0);
            }
        });

        aboutbutton = (Button) findViewById(R.id.aboutbtn);
        aboutbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), about.class);
                startActivityForResult(intent3, 0);
            }
        });

        contactbutton = (Button)findViewById(R.id.contactbutton);
        contactbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(v.getContext(), ContactUs.class);
                startActivityForResult(intent4, 0);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   @Override
    protected void onPause(){
        super.onPause();
        mp.release();
        finish();
    }


}
