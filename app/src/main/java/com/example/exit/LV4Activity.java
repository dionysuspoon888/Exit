package com.example.exit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.orhanobut.hawk.Hawk;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by D on 3/11/2018.
 */

public class LV4Activity extends BaseActivity {
    ImageView qrcode;

    ImageView b_submit;
    EditText et_lv4;
    String tmp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv4);
        Hawk.init(this).build();
        Hawk.put(GlobalConstants.KEY_ELV,"4");

        if(isMyServiceRunning(MainService.class)==false){
            Log.i("LV4 Service","SS");
            startService(new Intent(LV4Activity.this,MainService.class));
        }


        //set QR code
        qrcode = findViewById(R.id.qrcode);

        Bitmap bm = generateQRCode("TIXE");
        qrcode.setImageBitmap(bm);

        Log.i("LV4 QR", " SS ");

        b_submit=findViewById(R.id.b_submit);
        et_lv4=findViewById(R.id.et_lv4);


        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp=et_lv4.getText().toString().trim();
                Log.i("LV4 CLICK ","SS");
                if(tmp.equals("TIXE")){
                    Log.i("LV4 CLICK C","SS");
                    startActivity(new Intent(LV4Activity.this,LV5Activity.class));
                    finish();
                }else{
                    Log.i("LV4 CLICK X","SS");
                    Toast.makeText(getBaseContext(),"WRONG~~~~"+tmp,Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public Bitmap generateQRCode(String text) {

        Bitmap mBitmap = null;
//        LogUtil.info("generateQRCode", "generateQRCode:" + (TextUtils.isEmpty(qrMbid) || mBitmap == null || !mbid.equals(qrMbid)) + ", " + TextUtils.isEmpty(mbid)
//                + ", " + (mBitmap == null) + ", " + (!mbid.equals(qrMbid)) +", "+fullCardNo);


        QRCodeWriter writer = new QRCodeWriter();
        try {
            Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0); /* default = 4 */
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, (int) convertDpToPixel(120, this), (int) convertDpToPixel(120, this), hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    mBitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return mBitmap;


    }

    public static float convertDpToPixel(float dp, Context context) {
        float px = dp * getDensity(context);
        return px;
    }

    public static float convertPixelToDp(float px, Context context) {
        float dp = px / getDensity(context);
        return dp;
    }

    public static float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }

}