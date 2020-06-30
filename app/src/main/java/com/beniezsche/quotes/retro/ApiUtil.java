package com.beniezsche.quotes.retro;

public class ApiUtil {

    private static final String BASE_URL = "https://api.quotable.io/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}