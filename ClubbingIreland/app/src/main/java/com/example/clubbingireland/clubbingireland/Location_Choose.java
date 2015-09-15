package com.example.clubbingireland.clubbingireland;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class Location_Choose extends ActionBarActivity implements OnItemSelectedListener {

    Spinner countyspinner;
    Button submitbutton;
    String county,town,genre;
    SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__choose);
        Toast.makeText(getApplicationContext(),county, Toast.LENGTH_LONG).show();
        countyspinner = (Spinner)findViewById(R.id.spinnercounty);
        countyspinner.setOnItemSelectedListener(this);
        submitbutton = (Button)findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VenueList.class);
                startActivityForResult(intent,0);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0,View arg1, int arg2, long arg3){
        String county = String.valueOf(countyspinner.getSelectedItem());
        //Toast.makeText(getApplicationContext(),county,Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",county);
        editor.commit();

}

    public void onNothingSelected(AdapterView<?> arg0){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location__choose, menu);
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
}
