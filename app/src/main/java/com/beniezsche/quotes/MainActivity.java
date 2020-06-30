package com.beniezsche.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.beniezsche.quotes.Model.Quote;
import com.beniezsche.quotes.retro.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private TextView contentTextView, authorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentTextView = findViewById(R.id.content);
        authorTextView = findViewById(R.id.author);

        refresh();

    }

    @Override
    protected void onResume() {
        super.onResume();

        refresh();
    }

    public void refresh(){

        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<Quote>() {

            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if(response.isSuccessful()){
                    Quote postQuote = response.body();
                    Log.d(TAG, "Response received successfully");
                    contentTextView.setText('"' + postQuote.getContent() + '"');
                    authorTextView.setText("-" + postQuote.getAuthor());

                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API");
            }

        });




    }
}
