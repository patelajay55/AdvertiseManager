package com.photocompany.adsmanager.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;


public class ShowFacebookSplashInterstatial {

    Context context;

    public ShowFacebookSplashInterstatial(Context context, final String interStastitialId, final Intent nextActivity) {
        this.context = context;
        final InterstitialAd interstitialAd = new InterstitialAd(context, interStastitialId);
        setAdListner(interstitialAd, nextActivity);
        interstitialAd.loadAd();
    }

    private void setAdListner(final InterstitialAd interstitialAd, final Intent nextActivity) {
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                startNextActivity(nextActivity);
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                startNextActivity(nextActivity);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                interstitialAd.show();
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
}
