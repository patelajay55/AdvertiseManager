package com.qksoft.advertisemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

 class Advertisement {

    private Context context;

     /**
      * Don't Forget to add in Application Tag in Manifest
      * <meta-data
      *         android:name="com.google.android.gms.ads.APPLICATION_ID"
      *         android:value="[ADMOB_APP_ID]"/>
      */

     Advertisement(Context context) {
        this.context = context;
    }

     void initializeAdmobSdk(String appId) {
        MobileAds.initialize(context, appId);
    }

     public AdRequest requestAd(){
         return new AdRequest.Builder().build();
     }

     public AdView geteBannerAd(AdSize adSize, String bannerId) {
         AdView adView = new AdView(context);
         adView.setAdSize(adSize);
         adView.setAdUnitId(bannerId);
         adView.loadAd(requestAd());
         return adView;
     }

     public void addBannerToLinearLayout(AdSize adSize, String bannerId, LinearLayout adContainer) {
         LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
         adContainer.addView(geteBannerAd(adSize,bannerId),params);
     }

     public InterstitialAd loadInterstatial(final Boolean isReloadOnClosed,String interStastitialId ,final Intent nextActivity){
         InterstitialAd mInterstitialAd = generateInterstatial(interStastitialId);
         setAdlistner(mInterstitialAd,false,true, interStastitialId, nextActivity );
         return  mInterstitialAd;
     }

     public InterstitialAd loadSplashInterstatial( Boolean isReloadOnClosed,String interStastitialId , Intent nextActivity){
         InterstitialAd mInterstitialAd = generateInterstatial(interStastitialId);
         setAdlistner(mInterstitialAd,true,false, interStastitialId, nextActivity );
         return mInterstitialAd;
     }

     private InterstitialAd generateInterstatial(String interStastitialId){
         final InterstitialAd mInterstitialAd = new InterstitialAd(context);
         mInterstitialAd.setAdUnitId(interStastitialId);
         mInterstitialAd.loadAd(requestAd());
         return mInterstitialAd;
     }

     private void setAdlistner(final InterstitialAd mInterstitialAd,final Boolean isSplashScreen ,final Boolean isReloadOnClosed, String interStastitialId, final Intent nextActivity) {
         mInterstitialAd.setAdListener(new AdListener(){
             @Override
             public void onAdClosed() {
                 super.onAdClosed();
                 if(isReloadOnClosed )
                     mInterstitialAd.loadAd(requestAd());
                 if(nextActivity != null)
                 {
                     context.startActivity(nextActivity);
                     ((Activity) context).finish();
                 }
             }

             @Override
             public void onAdFailedToLoad(int i) {
                 super.onAdFailedToLoad(i);
                 mInterstitialAd.loadAd(requestAd());
             }

             @Override
             public void onAdLoaded() {
                 super.onAdLoaded();
                 if(isSplashScreen)
                     mInterstitialAd.show();
             }
         });
     }
 }
