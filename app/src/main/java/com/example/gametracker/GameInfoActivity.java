package com.example.gametracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GameInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameinfoscreen);

        //Intent intent = getIntent();
        //String game = intent.getStringExtra("game");
        String game = "Test Game";
        getSupportActionBar().setTitle(game);
    }
}