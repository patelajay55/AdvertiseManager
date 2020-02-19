package com.qksoft.advertisemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";
    String test_Banner_Id = "ca-app-pub-3940256099942544/6300978111";
    String test_Interstatial_Id = "ca-app-pub-3940256099942544/1033173712";
    String orignal_Banner_Id = "ca-app-pub-4906547187531410/8704083733";
    String facebook_Test_id = "IMG_16_9_LINK#YOUR_PLACEMENT_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Advertisement advertisement = new Advertisement(MainActivity.this);

        FacebookAdvertiseManager facebookAdvertiseManager = new FacebookAdvertiseManager(MainActivity.this);

        final InterstitialAd interstitialAd = advertisement.loadInterstatial(false,test_Interstatial_Id,new Intent(MainActivity.this,MainActivity.class));

        LinearLayout adContainer = findViewById(R.id.linerLayout);

       advertisement.addBannerToLinearLayout(AdSize.LARGE_BANNER, test_Banner_Id, adContainer);

 //       facebookAdvertiseManager.addBannerToLinearLayout(AdSize.BANNER_HEIGHT_90,facebook_Test_id,adContainer);

        final com.facebook.ads.InterstitialAd facebookInterstatial = facebookAdvertiseManager.loadInterstatial(false,facebook_Test_id,new Intent(MainActivity.this,MainActivity.class));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd.isLoaded())
                    interstitialAd.show();
            }
        });
    }

}