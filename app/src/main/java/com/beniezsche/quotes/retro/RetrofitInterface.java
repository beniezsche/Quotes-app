package com.beniezsche.quotes.retro;

import com.beniezsche.quotes.Model.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("random")
    public Call<Quote> getAllPost();
}
