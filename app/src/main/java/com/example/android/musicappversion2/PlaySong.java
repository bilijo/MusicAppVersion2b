package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);


        // get intent with extras from SongList, text name and color
        Intent recupIntent = getIntent();
        String vSongName = recupIntent.getStringExtra("IntentSongName");
        int vColorGenre = recupIntent.getIntExtra("IntentBkgColor", 0);

        // Create an instance of the View which would display the name of the Song
        TextView trackname = (TextView) findViewById(R.id.play_track);
        trackname.setText(vSongName);
        trackname.setBackgroundColor(vColorGenre);

        //Add instance of the  button designed to get back to previous Activity
        Button btnNext = (Button) findViewById(R.id.bt_back);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavUtils.navigateUpFromSameTask(PlaySong.this);
            }
        });
    }
}
