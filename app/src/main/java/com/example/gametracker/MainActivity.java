package com.example.gametracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int clickCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void testButton(View view) {
        TextView mainText = (TextView)findViewById(R.id.mainText);
        if(clickCount == 0) {
            mainText.setText("Test 1!");
            clickCount = 1;
        } else {
            mainText.setText("Test 2!");
            clickCount = 0;
        }
    }
}