package com.example.clubbingireland.clubbingireland;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


public class VenueList extends ListActivity implements FetchDataListener  {
    private ProgressDialog dialog;
    public String county;
    //public String url;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_list);
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        county = sharedPreferences.getString("name","");
        //Toast.makeText(this,county+"is the county",Toast.LENGTH_LONG).show();
        if (county.equals("Longford"))
            initView1();
        if (county.equals("Offaly"))
            initView2();
        if (county.equals("Roscommon"))
            initView3();
        if (county.equals("Westmeath"))
            initView4();


 }



    private void initView1(){

        String url =  "http://52.16.232.185/countylongford.php";
        dialog = ProgressDialog.show(this,"","Loading...");
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }

    private void initView2(){

        String url =  "http://52.16.232.185/countyoffaly.php";
        dialog = ProgressDialog.show(this,"","Loading...");
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }

    private void initView3(){

        String url =  "http://52.16.232.185/countyroscommon.php";
        dialog = ProgressDialog.show(this,"","Loading...");
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }

    private void initView4(){

        String url =  "http://52.16.232.185/countywestmeath.php";
        dialog = ProgressDialog.show(this,"","Loading...");
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }
    public void onFetchComplete(List<Application> data){
        if(dialog != null) dialog.dismiss();
        ApplicationAdapter adapter = new ApplicationAdapter(this,data);
        setListAdapter(adapter);

    }

    public void onFetchFailure(String msg){
        if (dialog != null) dialog.dismiss();
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_venue_list, menu);
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
