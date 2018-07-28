package com.example.sahil.youtubeinfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import static android.R.attr.fragment;

public class MainActivity extends Activity {

    private FirstFragment mFirstFrag;
    private SecondFragment mSecFrag;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private boolean isfullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("SecondFrag","OnCreate");
        mFirstFrag = new FirstFragment();
        mSecFrag = new SecondFragment();
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.myframe,mFirstFrag);
        mFragmentTransaction.commit();
    }

    public void changeFragment() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mFirstFrag.isResumed()){
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        }
        else
            mFragmentTransaction.replace(R.id.myframe,mFirstFrag);
        mFragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

    public void isFullScreen(boolean b) {
        isfullScreen = b;
    }

}
