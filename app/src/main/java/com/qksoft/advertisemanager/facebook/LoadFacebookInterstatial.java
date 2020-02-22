package com.qksoft.advertisemanager.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class LoadFacebookInterstatial {

    Context context;
    public InterstitialAd mInterstitialAd;
    public LoadFacebookInterstatial(Context context, String interStastitialId, Intent nextActivity) {
        this.context = context;
        InterstitialAd mInterstitialAd = new InterstitialAd(context, interStastitialId);
        setAdListner(mInterstitialAd, nextActivity);
        mInterstitialAd.loadAd();
        this.mInterstitialAd = mInterstitialAd;
    }

    private void setAdListner(final InterstitialAd interstitialAd, final Intent nextActivity) {
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                interstitialAd.loadAd();
                startNextActivity(nextActivity);
            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {
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
        if (mInterstitialAd.isAdLoaded())
            return true;
        return false;
    }

    public void show() {
        if(isLoaded())
            mInterstitialAd.show();
    }

}
