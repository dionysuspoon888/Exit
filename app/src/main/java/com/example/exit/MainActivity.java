package com.example.exit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.orhanobut.hawk.Hawk;


public class MainActivity extends BaseActivity{


    ImageView b_start;
    ImageView b_reset;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_reset=findViewById(R.id.b_reset);
        b_start=findViewById(R.id.b_start);
        startService(new Intent(MainActivity.this,MainService.class));

        if(Hawk.get(GlobalConstants.KEY_ELV) !=null) {
            i = Integer.parseInt((String) Hawk.get(GlobalConstants.KEY_ELV));
        }else{
            i=0;
        }

        if(i==0){
            b_start.setImageResource(R.drawable.b_start);
            b_reset.setVisibility(View.GONE);

        }else{
            b_start.setImageResource(R.drawable.b_continue);
            b_reset.setVisibility(View.VISIBLE);
        }

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("start","SS");
                switch (i){
                    case 1:
                        startActivity(new Intent(MainActivity.this,LV1Activity.class));
                        finish();
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,LV2Activity.class));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,LV3Activity.class));
                        finish();
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,LV4Activity.class));
                        finish();
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,LV5Activity.class));
                        finish();
                        break;

                        default:startActivity(new Intent(MainActivity.this,LV1Activity.class));
                        finish();
                        break;

                }

            }
        });

        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                Hawk.deleteAll();
                b_start.setImageResource(R.drawable.b_start);
                b_reset.setVisibility(View.GONE);

            }
        });



    }




}
