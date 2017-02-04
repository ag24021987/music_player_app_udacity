package com.example.agupt23.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DownloadSongsActivity extends AppCompatActivity {

    Button goToPlaySongsButton;
    Button goToCreatePlaylistButton;
    Button goToHomeScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_songs);

        goToPlaySongsButton = (Button) findViewById(R.id.play_songs_gotoactivity_button);
        goToCreatePlaylistButton = (Button) findViewById(R.id.create_playlist_gotoactivity_button);
        goToHomeScreenButton = (Button) findViewById(R.id.home_gotoactivity_button);

        goToPlaySongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadSongsActivity.this,PlaySongsActivity.class);
                startActivity(intent);
            }
        });

        goToCreatePlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadSongsActivity.this,CreatePlayListActivity.class);
                startActivity(intent);
            }
        });

        goToHomeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadSongsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
