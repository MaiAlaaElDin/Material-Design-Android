package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Worldpopulation> mDataset;
    Context mContext;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_row, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        myViewHolder.view.setText(mDataset[position]);
        TextView rankText = myViewHolder.view.findViewById(R.id.rank);
        TextView nameText = myViewHolder.view.findViewById(R.id.name);
        TextView populationText = myViewHolder.view.findViewById(R.id.population);
        ImageView flagImage = myViewHolder.view.findViewById(R.id.imageView);

        rankText.setText(Integer.toString(mDataset.get(position).getRank()));
        nameText.setText(mDataset.get(position).getCountry());
        populationText.setText(mDataset.get(position).getPopulation());

        //Using Glide Library to load images from web service (adding Glide Library to Retrofit)
        Glide.with(mContext)
                .load(mDataset.get(position).getFlag())
                .override(350,350)
                .into(flagImage);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public MyViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    // Provide a suitable constructor
    public MyAdapter(ArrayList<Worldpopulation> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;

    }

}