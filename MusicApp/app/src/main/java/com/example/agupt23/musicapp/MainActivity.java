package com.example.agupt23.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button downloadButton;
    Button playSongsButton;
    Button createPlaylistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadButton = (Button) findViewById(R.id.download_button);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DownloadSongsActivity.class);
                startActivity(intent);
            }
        });

        playSongsButton = (Button) findViewById(R.id.play_songs_button);
        playSongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlaySongsActivity.class);
                startActivity(intent);
            }
        });

        createPlaylistButton = (Button) findViewById(R.id.create_playlist_button);
        Log.v("MainActivity",String.valueOf(createPlaylistButton.getText()));
        createPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreatePlayListActivity.class);
                startActivity(intent);
            }
        });
    }
}
