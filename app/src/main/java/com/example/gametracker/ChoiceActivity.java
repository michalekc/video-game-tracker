package com.example.gametracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoiceActivity extends AppCompatActivity {
    String console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicepage);

        getSupportActionBar().hide();
        Intent intent = getIntent();
        //retrieve the console that was clicked
        console = intent.getStringExtra("console");
    }

    public void openCollectionScreen(View view) {
        Intent intent = new Intent(this, CollectionActivity.class);
        intent.putExtra("console", console);
        startActivity(intent);
    }

    public void openWishlistScreen(View view) {
        Intent intent = new Intent(this, WishlistActivity.class);
        intent.putExtra("console", console);
        startActivity(intent);
    }
}