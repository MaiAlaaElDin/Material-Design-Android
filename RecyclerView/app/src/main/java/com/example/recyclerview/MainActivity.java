package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    MyAdapter mAdapter;
    public static final String BASE_URL ="http://www.androidbegin.com/";
    ArrayList<Worldpopulation> myDataset = new ArrayList<>();;

    //String[] myDataset ={"Mai","Muhammad","Ahmed","Alaa","Shahy","Hayam","Nermeen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView imageView = findViewById(R.id.profile_image);
        //imageView.setImageResource(R.drawable.wp2069991;

        Intent intent = getIntent();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadJson();

    }


    public void loadJson()
    {
        int cacheSize = 10 * 1024;
        Cache cache = new Cache(getCacheDir(),cacheSize);

        //Caching Images
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface request = retrofit.create(RetrofitInterface.class);
        Call<JsonResponse> call = request.getCountriesList();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response != null) {
                    myDataset= (ArrayList<Worldpopulation>) response.body().getWorldpopulation();
                    // specify an adapter
                    mAdapter = new MyAdapter(myDataset, getApplicationContext());
                    recyclerView.setAdapter(mAdapter);
                    //Toast.makeText(MainActivity.this, data.get(0).getCountry(), Toast.LENGTH_SHORT).show();
                    Log.i("Inside call enqueue", "data is not null");
                }
                else{
                    Log.i("Inside call enqueue", "Data is NULL");
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
            }
        });

    }




}
