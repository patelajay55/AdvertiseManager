package com.qksoft.advertisemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.MobileAds;

public class FacebookAdvertiseManager {

    private AdView bannerAdView;
    Context context;
    private final String TAG = FacebookAdvertiseManager.class.getSimpleName();

    public FacebookAdvertiseManager(Context context) {
        this.context =  context;
    }

    public static void InitializeFacebookSdk(Context context ) {
        AudienceNetworkAds.initialize(context);
    }

    public void addBannerToLinearLayout(AdSize adSize, String adsId, LinearLayout bannerAdContainer) {
        if (bannerAdView != null) {
            bannerAdView.destroy();
            bannerAdView = null;
        }
        bannerAdView = new AdView(context, adsId,
                 adSize );

        bannerAdContainer.addView(bannerAdView);

        bannerAdView.loadAd();
    }
    private  void setAdListner (final InterstitialAd interstitialAd,final Boolean isSplashScreen,final Boolean isReloadOnClosed,final Intent nextActivity){
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                if(isReloadOnClosed )
                    interstitialAd.loadAd();
                if(nextActivity != null)
                {
                    context.startActivity(nextActivity);
                    ((Activity) context).finish();
                }
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                if(isSplashScreen){
                    context.startActivity(nextActivity);
                    ((Activity) context).finish();
                    return;
                }
                interstitialAd.loadAd();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if(isSplashScreen)
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
    public InterstitialAd loadInterstatial (final Boolean isReloadOnClosed, final String interStastitialId , final Intent nextActivity){
       final InterstitialAd interstitialAd = new InterstitialAd(context, interStastitialId);
       setAdListner(interstitialAd,false,isReloadOnClosed,nextActivity);
        interstitialAd.loadAd();
        return  interstitialAd;
    }
    public InterstitialAd showSplashInterstatial (final Boolean isReloadOnClosed, final String interStastitialId , final Intent nextActivity){
        final InterstitialAd interstitialAd = new InterstitialAd(context, interStastitialId);
        setAdListner(interstitialAd,true,isReloadOnClosed,nextActivity);
        interstitialAd.loadAd();
        return  interstitialAd;
    }
    public void onDestroy() {
        if (bannerAdView != null) {
            bannerAdView.destroy();
            bannerAdView = null;
        }
    }
}
