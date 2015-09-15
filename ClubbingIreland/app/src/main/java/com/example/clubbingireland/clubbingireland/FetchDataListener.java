package com.example.clubbingireland.clubbingireland;

import java.util.List;

/**
 * Created by SCHOLES on 27/04/2015.
 */
public interface FetchDataListener {
    public void onFetchComplete(List<Application> data);
    public void onFetchFailure(String msg);
}
