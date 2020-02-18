package com.qksoft.advertisemanager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SetUpAdvertisingSdk(appId);
    }

    private void SetUpAdvertisingSdk(String appId) {
        /**
         * Don't Forget to add in Application Tag in Manifest
         * <meta-data
         *         android:name="com.google.android.gms.ads.APPLICATION_ID"
         *         android:value="[ADMOB_APP_ID]"/>
         */
        MobileAds.initialize(MainActivity.this, appId);

    }

    public AdView createBanner(Context context, AdSize adSize, String bannerId) {
        AdView adView = new AdView(context);
        adView.setAdSize(adSize);
        adView.setAdUnitId(bannerId);
        adView.loadAd(requestAd());
        return adView;
    }
    public AdRequest requestAd(){
        return new AdRequest.Builder().build();
    }
}