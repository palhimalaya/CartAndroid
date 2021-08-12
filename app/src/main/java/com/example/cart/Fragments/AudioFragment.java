package com.example.cart.Fragments;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cart.R;


import java.io.IOException;

public class AudioFragment extends Fragment implements View.OnClickListener {
    private TextView audioUrl;
    private Button playButton;
    private Button pauseButton;
    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio, container, false);

    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView();
        initListener();

    }
    private void intView() {
        audioUrl = getActivity().findViewById(R.id.audio_link);
        playButton = getActivity().findViewById(R.id.play_button);
        pauseButton = getActivity().findViewById(R.id.pause_audio);
    }

    private void initListener() {
        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.play_audio){
            String url = audioUrl.getText().toString(); // your URL here
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mediaPlayer.setAudioAttributes(
                        new AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                );
            }
            try {
                mediaPlayer.setDataSource(url);

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                mediaPlayer.prepare(); // might take long! (for buffering, etc)
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();

        }
        if (v.getId()==R.id.pause_audio){
            if (mediaPlayer !=null){
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        }
    }
}