package com.example.exit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

/**
 * Created by D on 3/11/2018.
 */

public class LV1Activity extends BaseActivity {
    TextView tv_exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv1);
        Hawk.put(GlobalConstants.KEY_ELV,"1");

        tv_exit=findViewById(R.id.tv_exit);
        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LV1Activity.this,LV2Activity.class));
                finish();

            }
        });


    }
}
