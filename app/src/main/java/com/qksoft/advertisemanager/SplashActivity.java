package com.qksoft.advertisemanager;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static com.qksoft.advertisemanager.Advertisement.InitializeAdmobSdk;
import static com.qksoft.advertisemanager.FacebookAdvertiseManager.InitializeFacebookSdk;

public class SplashActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";
    String test_Interstatial_Id = "ca-app-pub-3940256099942544/1033173712";
    String facebook_Test_id = "IMG_16_9_LINK#YOUR_PLACEMENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        InitializeAdmobSdk(SplashActivity.this,appId);
        InitializeFacebookSdk(SplashActivity.this);

        Advertisement advertisement = new Advertisement(SplashActivity.this);
       // advertisement.showSplashInterstatial(false,test_Interstatial_Id,new Intent(SplashActivity.this,MainActivity.class));

        FacebookAdvertiseManager facebookAdvertiseManager = new FacebookAdvertiseManager(SplashActivity.this);
        facebookAdvertiseManager.showSplashInterstatial(false,facebook_Test_id,new Intent(SplashActivity.this,MainActivity.class));


    }

}
