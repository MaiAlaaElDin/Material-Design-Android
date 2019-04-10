package com.example.alllayoutsdesign;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        imageView = findViewById(R.id.chosenImage);
        textView = findViewById(R.id.infoOnImage);
        nextButton = findViewById(R.id.nextButton);

        Intent incomingIntent = getIntent();
        int imagePosition = incomingIntent.getIntExtra("ImagePosition",0);
        int [] images = incomingIntent.getIntArrayExtra("Array");

        imageView.setImageResource(images[imagePosition]);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(1000,1000));
        textView.setText("Keira Christina Knightley, born 26 March 1985) is an English actress. She has worked in both the British and American film industries, and has starred in Broadway and West End theatre productions. She has received an Empire Award and multiple nominations for British Academy, Golden Globe, and Academy Awards." +
                "Her portrayal of Elizabeth Bennet in the 2005 romantic drama film Pride & Prejudice earned her critical acclaim and a Best Actress nomination at the Academy Awards. ");

        nextButton.setOnClickListener((v)->{

            Intent outIntent = new Intent(RelativeActivity.this,ConstraintActivity.class);
            startActivity(outIntent);
        });


    }
}
