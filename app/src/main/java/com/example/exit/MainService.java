package com.example.exit;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by D on 3/11/2018.
 */

public class MainService extends Service {
    private MediaPlayer musicPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Background music
        musicPlayer = MediaPlayer.create(this,R.raw.r1);
        musicPlayer.setLooping(true);
        musicPlayer.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        musicPlayer.stop();
    }
}
