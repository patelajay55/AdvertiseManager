package com.qksoft.advertisemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdSize;
import com.qksoft.advertisemanager.admob.AddAdmobBannerToLinearLayout;
import com.qksoft.advertisemanager.admob.AddAdmobNativeBannerToLinearLayout;
import com.qksoft.advertisemanager.admob.LoadAdmobInterstatial;
import com.qksoft.advertisemanager.facebook.AddFacebookBannerToLinearLayout;
import com.qksoft.advertisemanager.facebook.AddFacebookNativeAds;
import com.qksoft.advertisemanager.facebook.LoadFacebookInterstatial;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";
    String test_Banner_Id = "ca-app-pub-3940256099942544/6300978111";
    String test_Interstatial_Id = "ca-app-pub-3940256099942544/1033173712";
    String orignal_Banner_Id = "ca-app-pub-4906547187531410/8704083733";
    String facebook_Test_id = "IMG_16_9_LINK#YOUR_PLACEMENT_ID";
    String facebook_Test_Video_id = "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID";
    String nativeBannerID = "ca-app-pub-3940256099942544/2247696110";
    Context context = MainActivity.this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout adContainer = findViewById(R.id.linerLayout);

       // new AddAdmobNativeBannerToLinearLayout(context, nativeBannerID, R.layout.gnt_small_template_view, adContainer);

       // new AddAdmobBannerToLinearLayout(context, test_Banner_Id, AdSize.SMART_BANNER, adContainer);

       // new AddFacebookBannerToLinearLayout(context, facebook_Test_id, com.facebook.ads.AdSize.BANNER_HEIGHT_90, adContainer);

      //  final LoadAdmobInterstatial admobInterstatial = new LoadAdmobInterstatial(context, test_Interstatial_Id, new Intent(context, MainActivity.class));

      //  final LoadFacebookInterstatial interstatial = new LoadFacebookInterstatial(context, facebook_Test_id, new Intent(context, MainActivity.class));

//        findViewById(R.id.showfacebook).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                interstatial.show();
//            }
//        });

//        findViewById(R.id.showadmob).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                admobInterstatial.show();
//            }
//
//        });
         NativeAdLayout nativeAdLayout = findViewById(R.id.native_ad_container);

         LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);

          new AddFacebookNativeAds(context,facebook_Test_Video_id,nativeAdLayout,adChoicesContainer);


    }

}