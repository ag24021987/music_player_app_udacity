package com.example.agupt23.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreatePlayListActivity extends AppCompatActivity {

    Button goToDownloadSongsButton;
    Button goToPlaySongsButton;
    Button goToHomeScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_play_list);

        goToDownloadSongsButton = (Button) findViewById(R.id.download_songs_gotoactivity_button);
        goToPlaySongsButton = (Button) findViewById(R.id.play_songs_gotoactivity_button);
        goToHomeScreenButton = (Button) findViewById(R.id.home_gotoactivity_button);

        goToDownloadSongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePlayListActivity.this,DownloadSongsActivity.class);
                startActivity(intent);
            }
        });

        goToPlaySongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePlayListActivity.this,PlaySongsActivity.class);
                startActivity(intent);
            }
        });

        goToHomeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePlayListActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
