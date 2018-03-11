package com.example.exit;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.orhanobut.hawk.Hawk;

/**
 * Created by D on 3/11/2018.
 */

public class LV5Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv5);
        Hawk.put(GlobalConstants.KEY_ELV,"5");
    }
}
