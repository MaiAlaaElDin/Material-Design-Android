package com.example.alllayoutsdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener((v)->{
            Toast.makeText(this, "Going To Grid Layout Activity", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,GridActivity.class));
        });
    }
}
