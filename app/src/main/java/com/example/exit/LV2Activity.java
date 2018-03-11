package com.example.exit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.orhanobut.hawk.Hawk;

/**
 * Created by D on 3/11/2018.
 */

public class LV2Activity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv2);
        Hawk.put(GlobalConstants.KEY_ELV,"2");


        //Ads Mob id for apps
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        //Ads Banner
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Lv2 ads click","SS");
                GlobalConstants.KEY_LV=3;

            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LV2 Key",""+GlobalConstants.KEY_LV);
        if( GlobalConstants.KEY_LV==3){
            new Handler().postDelayed(nextLv,200);

        }
    }
    public Runnable nextLv=new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(LV2Activity.this,LV3Activity.class));
        }
    };


}
