package com.example.clubbingireland.clubbingireland;

/**
 * Created by SCHOLES on 27/04/2015.
 */
public class Application {
    private String name;
    private String location;
    private String band;
    private String date;
    private String county;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getBand(){
        return band;
    }
    public void setBand(String band){
        this.band = band;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getCounty(){
        return county;
    }

    public void setCounty(String county){
        this.county = county;
    }
}
