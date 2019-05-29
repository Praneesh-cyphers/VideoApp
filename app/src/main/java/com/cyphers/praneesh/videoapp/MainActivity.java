package com.cyphers.praneesh.videoapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button btnPlayPause;
    private SeekBar mySeekbar;
    private Button btnPlayMusic, btnPauseMusic;

    private MediaPlayer myMediaPlayer;
    private MediaController myMedia;
    private AudioManager myAudioMg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnplayVideo);
        btnPlayMusic = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);
        mySeekbar = findViewById(R.id.seekBar);

        btnPlayPause.setOnClickListener(MainActivity.this );
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);

        myMedia = new MediaController(MainActivity.this);
        myMediaPlayer = MediaPlayer.create(this,R.raw.music);
        myAudioMg = (AudioManager) getSystemService(AUDIO_SERVICE);

    }
    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId())
        {
            case R.id.btnPlayMusic :
            {
                myMediaPlayer.start();
            }
             break;

            case R.id.btnPauseMusic:
            {
                myMediaPlayer.pause();
            }
             break;

            case R.id.btnplayVideo:
            {
                myVideoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName()+"/"+ R.raw.video));
                myVideoView.setMediaController(myMedia);
                myMedia.setAnchorView(myVideoView);
                myVideoView.start();
            }
             break;
            case R.id.seekBar :
            {
                mySeekbar.
            }
            break;
        }


    }
}
