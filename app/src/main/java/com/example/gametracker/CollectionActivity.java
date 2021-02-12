package com.example.gametracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CollectionActivity extends AppCompatActivity {
    final int ATARI2600 = 0;
    final int ATARI5200 = 1;
    final int ATARI7800 = 2;
    final int ATARILYNX = 3;
    final int ATARIJAGUAR = 4;
    final int COLECO = 5;
    final int INTELLIVISION = 6;
    final int NES = 7;
    final int SNES = 8;
    final int N64 = 9;
    final int GAMECUBE = 10;
    final int WII = 11;
    final int WIIU = 12;
    final int NSWITCH = 13;
    final int GAMEBOY = 14;
    final int GBC = 15;
    final int GBA = 16;
    final int NDS = 17;
    final int N3DS = 18;
    final int VIRTUALBOY = 19;
    final int PAN3DO = 20;
    final int CDI = 21;
    final int PS1 = 22;
    final int PS2 = 23;
    final int PS3 = 24;
    final int PS4 = 25;
    final int PS5 = 26;
    final int PSP = 27;
    final int PSVITA = 28;
    final int MASTERSYSTEM = 29;
    final int GENESIS = 30;
    final int SEGACD = 31;
    final int SEGA32X = 32;
    final int GAMEGEAR = 33;
    final int SATURN = 34;
    final int DREAMCAST = 35;
    final int TURBOGRAFX = 36;
    final int XBOX = 37;
    final int XBOX360 = 38;
    final int XBONE = 39;
    final int SERIESX = 40;

    ListView collectionListView;

    String gameTitle[] = {"Sega Master System", "Sega Genesis", "Sega CD", "Sega 32X", "Sega Game Gear",
            "Sega Saturn", "Sega Dreamcast", "TurboGrafx-16", "Xbox", "Xbox 360", "Xbox One", "Xbox Series X"};
    String gameDesc[] = {"Sega Master System", "Sega Genesis", "Sega CD", "Sega 32X", "Sega Game Gear",
            "Sega Saturn", "Sega Dreamcast", "TurboGrafx-16", "Xbox", "Xbox 360", "Xbox One", "Xbox Series X"};
    int boxArt[] = {R.drawable.mastersystem,
            R.drawable.genesis, R.drawable.segacd, R.drawable.sega32x,R.drawable.gamegear, R.drawable.saturn,
            R.drawable.dreamcast, R.drawable.turbogfx, R.drawable.xbox,R.drawable.xbox360, R.drawable.xbone,
            R.drawable.xboxseriesx};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectionpage);

        Intent intent = getIntent();
        //retrieve the console that was clicked
        int console = intent.getIntExtra("console", 0);

        collectionListView = findViewById(R.id.collectionListView);
        CollectionActivity.MyAdapter adapter = new CollectionActivity.MyAdapter(this, gameTitle, gameDesc, boxArt);
        collectionListView.setAdapter(adapter);
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String desc[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = desc;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDesc = row.findViewById(R.id.textView2);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDesc.setText(rDescription[position]);
            return row;
        }
    }
}