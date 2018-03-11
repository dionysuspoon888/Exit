package com.example.exit;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.orhanobut.hawk.Hawk;

/**
 * Created by D on 3/11/2018.
 */

public class LV3Activity extends BaseActivity {
    private MediaPlayer musicPlayer;

    //Notification
    private NotificationHelper notificationHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv3);
        Hawk.put(GlobalConstants.KEY_ELV,"3");
        //Own Music BGM
        stopService(new Intent(LV3Activity.this,MainService.class));
        musicPlayer = MediaPlayer.create(this,R.raw.r2);
        musicPlayer.setLooping(true);
        musicPlayer.start();

        //Notification
        notificationHelper = new NotificationHelper(this);
        sendToChannel1("Congrats!","You find a secret Exit,Let's Go to LV 4!!!");

    }

    @Override
    protected void onResume() {
        super.onResume();
        musicPlayer.start();
        Log.i("Resume LV3","SS");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause LV3","SS");
        musicPlayer.pause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy LV3","SS");
        musicPlayer.release();
        finish();
    }

    //Notification

    public void sendToChannel1(String title ,String message){
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title,message);

        //NotificationManager.notify() sends Notification to system
        notificationHelper.getManager().notify(1,nb.build());

    }
}
