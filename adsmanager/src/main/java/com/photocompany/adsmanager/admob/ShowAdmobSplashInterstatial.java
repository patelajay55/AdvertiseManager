package com.photocompany.adsmanager.admob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class ShowAdmobSplashInterstatial {
    Context context;
    public ShowAdmobSplashInterstatial(Context context, @NonNull String interStastitialId , @NonNull Intent nextActivity){
         this.context = context;
         InterstitialAd mInterstitialAd = generateInterstatial(interStastitialId);
         setAdlistner(mInterstitialAd, interStastitialId, nextActivity );
     }
    private InterstitialAd generateInterstatial(String interStastitialId){
         InterstitialAd mInterstitialAd = new InterstitialAd(context);
         mInterstitialAd.setAdUnitId(interStastitialId);
         mInterstitialAd.loadAd(requestAd());
         return mInterstitialAd;
    }
    private void setAdlistner(final InterstitialAd mInterstitialAd , String interStastitialId, final Intent nextActivity) {
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startNextActivity(nextActivity);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                startNextActivity(nextActivity);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                    mInterstitialAd.show();
            }
        });
    }
    private void startNextActivity(Intent intent){
        if(intent != null)
        {
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
    private AdRequest requestAd(){
        return new AdRequest.Builder().build();
    }
}
