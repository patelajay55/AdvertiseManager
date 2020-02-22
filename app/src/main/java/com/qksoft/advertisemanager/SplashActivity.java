package com.qksoft.advertisemanager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Space;

import androidx.appcompat.app.AppCompatActivity;

import com.qksoft.advertisemanager.admob.InitializeAdmobSdk;
import com.qksoft.advertisemanager.admob.ShowAdmobSplashInterstatial;
import com.qksoft.advertisemanager.facebook.FacebookAdvertiseManager;
import com.qksoft.advertisemanager.facebook.InitiaizeFacebookSdk;
import com.qksoft.advertisemanager.facebook.ShowFacebookSplashInterstatial;

import static com.qksoft.advertisemanager.facebook.FacebookAdvertiseManager.InitializeFacebookSdk;

public class SplashActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";
    String test_Interstatial_Id = "ca-app-pub-3940256099942544/1033173712";
    String facebook_Test_id = "IMG_16_9_LINK#YOUR_PLACEMENT_ID";
    String native_test_id = "ca-app-pub-3940256099942544/2247696110";
    Context context = SplashActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       new InitializeAdmobSdk(SplashActivity.this,appId);
       new InitiaizeFacebookSdk(context);

     //   new ShowAdmobSplashInterstatial(context,test_Interstatial_Id,new Intent(context, MainActivity.class));
        new ShowFacebookSplashInterstatial(context,facebook_Test_id,new Intent(context,MainActivity.class));

    }

}
