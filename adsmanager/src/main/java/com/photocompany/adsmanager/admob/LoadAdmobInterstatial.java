package com.photocompany.adsmanager.admob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.InterstitialAd;

public class LoadAdmobInterstatial {


    public InterstitialAd mInterstitialAd;
    Context context;

    public LoadAdmobInterstatial(Context context, String interStastitialId, final Intent nextActivity) {
        this.context = context;
        InterstitialAd mInterstitialAd = generateInterstatial(interStastitialId);
        setAdlistner(mInterstitialAd, nextActivity);
        this.mInterstitialAd = mInterstitialAd;
    }

    private InterstitialAd generateInterstatial(String interStastitialId) {
        InterstitialAd mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(interStastitialId);
        mInterstitialAd.loadAd(requestAd());
        return mInterstitialAd;
    }

    private AdRequest requestAd() {
        return new AdRequest.Builder().build();
    }

    public InterstitialAd getmInterstitialAd() {
        return mInterstitialAd;
    }

    private void setAdlistner(final InterstitialAd mInterstitialAd, final Intent nextActivity) {
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(requestAd());
                startNextActivity(nextActivity);
            }
        });
    }

    private void startNextActivity(Intent intent) {
        if (intent != null) {
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }

    boolean isLoaded() {
        if (mInterstitialAd.isLoaded())
            return true;
        return false;
    }

    public void show() {
        if(isLoaded()) mInterstitialAd.show();
    }

}