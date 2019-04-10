package com.example.alllayoutsdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    int [] images = {R.drawable.lizzy2,R.drawable.darcy2,R.drawable.jane,
                        R.drawable.charles,R.drawable.mrcollins,R.drawable.father,
                        R.drawable.cath,R.drawable.fritz,R.drawable.lizzy2,R.drawable.darcy2
    };
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridViewID);

        MyImageAdapter imageAdapter = new MyImageAdapter(this,images);
        gridView.setAdapter(imageAdapter);


        //Action to be performed on clicking a grid view item
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent outgoingIntent = new Intent(GridActivity.this,RelativeActivity.class);
            outgoingIntent.putExtra("ImagePosition",position);
            outgoingIntent.putExtra("Array",images);
            startActivity(outgoingIntent);
        });


    }
}
