package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tetitle , tv2 , tvdate ;
    ImageView imageView , tvcalpic, imageView3, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,secondpage.class);
                startActivity(intent);
            }
        });
        init();

    }
    private void init(){
        tetitle = findViewById(R.id.tetitle);
        tv2 = findViewById(R.id.tv2);
        tvdate = findViewById(R.id.tvdate);
        imageView = findViewById(R.id.imageView);
        tvcalpic = findViewById(R.id.tvcalpic);
        imageView3 = findViewById(R.id.imageView3);


    }
}