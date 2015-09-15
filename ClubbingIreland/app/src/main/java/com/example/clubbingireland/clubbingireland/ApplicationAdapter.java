package com.example.clubbingireland.clubbingireland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SCHOLES on 27/04/2015.
 */
public class ApplicationAdapter extends ArrayAdapter<Application> {
    private List<Application> items;

    public ApplicationAdapter(Context context, List<Application> items) {
        super(context, R.layout.layout, items);
        this.items = items;

    }

    public int getCount() {
        return items.size();

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.layout, null);


        }
        Application app = items.get(position);

        if (app != null) {
            TextView location = (TextView) v.findViewById(R.id.tv_location);
            TextView band = (TextView) v.findViewById(R.id.tv_band);
            TextView date = (TextView) v.findViewById(R.id.tv_date);
            TextView venue = (TextView) v.findViewById(R.id.tv_venue);
            TextView county = (TextView) v.findViewById(R.id.tv_county);

            if (location != null) location.setText("Location: "+app.getLocation());
            if (band != null) band.setText("Band: "+app.getBand());
            if (date != null) date.setText("Date: "+app.getDate());
            if (venue != null) venue.setText(app.getName());
            if (county != null) county.setText("County: "+app.getCounty());

        }
        return v;
    }

}



