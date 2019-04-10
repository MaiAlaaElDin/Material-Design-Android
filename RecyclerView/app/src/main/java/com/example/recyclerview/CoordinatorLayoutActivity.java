package com.example.recyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    FloatingActionButton fab;
    FloatingActionButton saveFab;
    FloatingActionButton goFab;
    Animation animation;
    Animation animation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        fab = findViewById(R.id.fab);
        saveFab =findViewById(R.id.savefab);
        goFab = findViewById(R.id.goFab);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);


        fab.setOnClickListener((v)->{
            fab.startAnimation(animation);
//            Intent outIntent = new Intent(CoordinatorLayoutActivity.this,MainActivity.class);
//            startActivity(outIntent);

        });


        saveFab.setOnClickListener((v)->{
            saveFab.startAnimation(animation2);
//            Intent outIntent = new Intent(CoordinatorLayoutActivity.this,MainActivity.class);
//            startActivity(outIntent);

        });

        goFab.setOnClickListener((v)->{
            Intent outIntent = new Intent(CoordinatorLayoutActivity.this,MainActivity.class);
            startActivity(outIntent);

        });



    }
}
