package com.example.exit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orhanobut.hawk.Hawk;

/**
 * Created by D on 3/11/2018.
 */

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    Thread thread1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Hawk.init(this).build();

        thread1=new Thread(MainActTask);
        handler=new Handler();
        handler.postDelayed(thread1,2000);



    }

    public Runnable MainActTask=new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
            Log.i("MainAct","SS");

        }
    };
}
