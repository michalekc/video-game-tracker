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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Atari 2600", "Atari 5200", "Atari 7800", "Atari Lynx", "Atari Jaguar", "ColecoVision",
            "Intellivision", "Nintendo Entertainment System", "Super Nintendo", "Nintendo 64", "Nintendo Gamecube",
            "Nintendo Wii", "Nintendo Wii U", "Nintendo Switch", "Gameboy", "Gameboy Color", "Gameboy Advance",
            "Nintendo DS", "Nintendo 3DS", "Virtual Boy", "Panasonic 3DO", "Philips CD-i", "Playstation",
            "Playstation 2", "Playstation 3", "Playstation 4", "Playstation 5", "Playstation Portable",
            "Playstation Vita", "Sega Master System", "Sega Genesis", "Sega CD", "Sega 32X", "Sega Game Gear",
            "Sega Saturn", "Sega Dreamcast", "TurboGrafx-16", "Xbox", "Xbox 360", "Xbox One", "Xbox Series X"};
    String mDesc[] = {"Atari 2600", "Atari 5200", "Atari 7800", "Atari Lynx", "Atari Jaguar", "ColecoVision",
            "Intellivision", "Nintendo Entertainment System", "Super Nintendo", "Nintendo 64", "Nintendo Gamecube",
            "Nintendo Wii", "Nintendo Wii U", "Nintendo Switch", "Gameboy", "Gameboy Color", "Gameboy Advance",
            "Nintendo DS", "Nintendo 3DS", "Virtual Boy", "Panasonic 3DO", "Philips CD-i", "Playstation",
            "Playstation 2", "Playstation 3", "Playstation 4", "Playstation 5", "Playstation Portable",
            "Playstation Vita", "Sega Master System", "Sega Genesis", "Sega CD", "Sega 32X", "Sega Game Gear",
            "Sega Saturn", "Sega Dreamcast", "TurboGrafx-16", "Xbox", "Xbox 360", "Xbox One", "Xbox Series X"};
    int images[] = {R.drawable.atari2600, R.drawable.atari5200, R.drawable.atari7800,R.drawable.atarilynx, R.drawable.atarijaguar,
                    R.drawable.coleco, R.drawable.intellivision, R.drawable.nes,R.drawable.snes, R.drawable.n64,
                    R.drawable.gamecube, R.drawable.wii, R.drawable.wiiu,R.drawable.ninswitch, R.drawable.gameboy,
                    R.drawable.gbc, R.drawable.gba, R.drawable.nds,R.drawable.nin3ds, R.drawable.virtualboy,
                    R.drawable.panasonic3do, R.drawable.cdi, R.drawable.ps1,R.drawable.ps2, R.drawable.ps3,
                    R.drawable.ps4, R.drawable.ps5, R.drawable.psp,R.drawable.vita, R.drawable.mastersystem,
                    R.drawable.genesis, R.drawable.segacd, R.drawable.sega32x,R.drawable.gamegear, R.drawable.saturn,
                    R.drawable.dreamcast, R.drawable.turbogfx, R.drawable.xbox,R.drawable.xbox360, R.drawable.xbone,
                    R.drawable.xboxseriesx};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDesc, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Main Activity pos: " + position);
                openCollectionScreen(position);
            }
        });
    }

    public void openCollectionScreen(int pos) {
        Intent intent = new Intent(this, CollectionActivity.class);
        //sends the console that was clicked
        intent.putExtra("console", pos);
        startActivity(intent);
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