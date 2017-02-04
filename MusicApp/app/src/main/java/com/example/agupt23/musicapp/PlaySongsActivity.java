package com.example.agupt23.musicapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class PlaySongsActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button startSampleAudioButton;
    Button pauseSampleAudioButton;
    Button stopSampleAudioButton;
    MediaPlayer mediaPlayer;
    Button chooseAudioFile;
    Button stopAudioFile;
    Button goToDownloadSongsButton;
    Button goToCreatePlaylistButton;
    Button goToHomeScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_songs);

        startSampleAudioButton = (Button) findViewById(R.id.start_sample_audio_button);
        pauseSampleAudioButton = (Button) findViewById(R.id.pause_sample_audio_button);
        stopSampleAudioButton = (Button) findViewById(R.id.stop_sample_audio_button);
        mediaPlayer = MediaPlayer.create(PlaySongsActivity.this,R.raw.sample_audio);
        mPlayer = new MediaPlayer();
        chooseAudioFile = (Button) findViewById(R.id.choose_audio_file);
        stopAudioFile = (Button) findViewById(R.id.stop_audio_file);
        goToDownloadSongsButton = (Button) findViewById(R.id.download_songs_gotoactivity_button);
        goToCreatePlaylistButton = (Button) findViewById(R.id.create_playlist_gotoactivity_button);
        goToHomeScreenButton = (Button) findViewById(R.id.home_gotoactivity_button);

        startSampleAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        pauseSampleAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });

        stopSampleAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*After Stop is called, currently the user cannot click on Start again to start the song unless he navigates
                 to some other activity and comes back to this activity */
                mediaPlayer.stop();
            }
        });

        chooseAudioFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("audio/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(Intent.createChooser(intent, "Select Audio"), 1);
                }
            }

        });

        stopAudioFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*After Stop is called, currently the user cannot click on Start again to start the song unless he navigates
                 to some other activity and comes back to this activity */
                mPlayer.stop();
            }
        });

        goToDownloadSongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaySongsActivity.this,DownloadSongsActivity.class);
                startActivity(intent);
            }
        });

        goToCreatePlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaySongsActivity.this,CreatePlayListActivity.class);
                startActivity(intent);
            }
        });

        goToHomeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaySongsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {
                Uri uri = data.getData();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(getApplicationContext(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlayer.start();

            }
        }
    }
}
