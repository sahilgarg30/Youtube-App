package com.example.sahil.changevideofullscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isPortLayout = getResources().getBoolean(R.bool.isPortLayout);
        if(isPortLayout) {
            // PORT
        } else {
            // LAND
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }
        setContentView(R.layout.activity_main);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String s = "http://www.ebookfrenzy.com/android_book/movie.mp4";
        MediaController controller = new MediaController(this);
        videoView.setVideoPath(s);
        videoView.setMediaController(controller);
        videoView.start();
    }


    public void closeApp(View view) {
        finish();
    }
}

