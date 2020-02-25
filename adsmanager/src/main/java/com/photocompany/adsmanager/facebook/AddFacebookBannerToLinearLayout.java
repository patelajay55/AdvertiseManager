package com.photocompany.adsmanager.facebook;

import android.content.Context;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;


public class AddFacebookBannerToLinearLayout {

    private AdView bannerAdView;

    public AddFacebookBannerToLinearLayout(Context context, String adsId, AdSize adSize, LinearLayout bannerAdContainer) {
        if (bannerAdView != null) {
            bannerAdView.destroy();
            bannerAdView = null;
        }
        bannerAdView = new AdView(context, adsId,
                adSize );

        bannerAdContainer.addView(bannerAdView);

        bannerAdView.loadAd();
    }

    public void onDestroy() {
        if (bannerAdView != null) {
            bannerAdView.destroy();
            bannerAdView = null;
        }
    }
}
