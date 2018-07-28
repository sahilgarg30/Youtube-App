package com.example.sahil.youtubeinfragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment implements YouTubePlayer.OnInitializedListener {


    private YouTubePlayerFragment youTubeView;
    private YouTubePlayer youTubePlayer;
    private boolean youTubePlayerIsFullScreen;
    private SecondFragment mSecFrag;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        Log.i("ThirdFrag","created!");
        mainActivity = (MainActivity)getActivity();
        youTubeView = new YouTubePlayerFragment();
        youTubeView.initialize(Config.YOUTUBE_API_KEY,this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.youtube_frame, youTubeView);
        fragmentTransaction.commit();
        return view;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        youTubePlayer = player;
        //player.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);
        //player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);
        //youTubePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);
        player.setShowFullscreenButton(true);
        if (!wasRestored) {
            player.cueVideo("TyMUY2CDrjc"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
        player.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean isFullScreen) {
                youTubePlayerIsFullScreen = isFullScreen;
            }
        });


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Thirdfrag","destroyed!");
        super.onDestroy();
    }
}
