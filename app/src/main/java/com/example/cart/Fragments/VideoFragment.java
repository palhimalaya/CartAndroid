package com.example.cart.Fragments;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cart.R;

public class VideoFragment extends Fragment implements View.OnClickListener {

    TextView link;
    Button play;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();


    }


    private void initView() {
        link = link.findViewById(R.id.link_view);
        play = play.findViewById(R.id.play_button);
    }

    private void initListener() {
        play.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.play_button) {
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
        }
    }
}