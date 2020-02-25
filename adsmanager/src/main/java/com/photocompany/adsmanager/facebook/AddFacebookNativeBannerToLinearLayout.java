package com.photocompany.adsmanager.facebook;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class AddFacebookNativeBannerToLinearLayout {

    private int mAdBackgroundColor, mTitleColor, mLinkColor, mContentColor, mCtaBgColor;
    private NativeBannerAdView.Type mViewType = NativeBannerAdView.Type.HEIGHT_100;
    private static final int COLOR_LIGHT_GRAY = 0xff90949c;
    private static final int COLOR_DARK_GRAY = 0xff4e5665;
    private static final int COLOR_CTA_BLUE_BG = 0xff4080ff;
    public static final int HEIGHT_50 = 4;
    public static final int HEIGHT_100 = 0;
    public static final int HEIGHT_120 = 1;
    private Context context;

    public AddFacebookNativeBannerToLinearLayout(Context context, String adsId, LinearLayout bannerAdContainer) {
        createAndLoadNativeAd(context,adsId,bannerAdContainer);
    }
    public AddFacebookNativeBannerToLinearLayout(Context context, String adsId, LinearLayout bannerAdContainer, int adsSize) {
        createAndLoadNativeAd(context,adsId,bannerAdContainer);
        switch(adsSize){
            case HEIGHT_50:
                mViewType = NativeBannerAdView.Type.HEIGHT_50;
                return;
            case HEIGHT_100:
                mViewType = NativeBannerAdView.Type.HEIGHT_100;
                return;
            case HEIGHT_120:
                mViewType = NativeBannerAdView.Type.HEIGHT_120;
                return;
            default:
                mViewType = NativeBannerAdView.Type.HEIGHT_100;
        }
    }
    private void createAndLoadNativeAd(Context context,String adsId, LinearLayout bannerAdContainer) {
        mAdBackgroundColor = Color.WHITE;
        mTitleColor = COLOR_DARK_GRAY;
        mLinkColor = Color.WHITE;
        mContentColor = COLOR_LIGHT_GRAY;
        mCtaBgColor = COLOR_CTA_BLUE_BG;

        NativeBannerAd mNativeBannerAd = new NativeBannerAd(context, adsId);
        this.context = context;
        // Set a listener to get notified when the ad was loaded.
        setAdListner(mNativeBannerAd,bannerAdContainer);
        // Initiate a request to load an ad.
        mNativeBannerAd.loadAd();

    }


    private void setAdListner(final NativeBannerAd mNativeBannerAd,final LinearLayout adContainer) {
        mNativeBannerAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (mNativeBannerAd == null || mNativeBannerAd != ad) {
                    // Race condition, load() called again before last ad was displayed
                    return;
                }
                reloadAdContainer(context,mNativeBannerAd,adContainer);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
    }

    private void reloadAdContainer(Context context, NativeBannerAd mNativeBannerAd, LinearLayout mNativeAdContainer) {

        if (context != null && mNativeBannerAd != null && mNativeBannerAd.isAdLoaded()) {
            mNativeAdContainer.removeAllViews();

            // Create a NativeAdViewAttributes object and set the attributes
            NativeAdViewAttributes attributes = new NativeAdViewAttributes()
                    .setBackgroundColor(mAdBackgroundColor)
                    .setTitleTextColor(mTitleColor)
                    .setDescriptionTextColor(mContentColor)
                    .setButtonBorderColor(mCtaBgColor)
                    .setButtonTextColor(mLinkColor)
                    .setButtonColor(mCtaBgColor);

            // Use NativeAdView.render to generate the ad View
            View adView =
                    NativeBannerAdView.render(context, mNativeBannerAd, mViewType, attributes);

            // Add adView to the container showing Ads
            mNativeAdContainer.addView(adView, 0);
            mNativeAdContainer.setBackgroundColor(Color.TRANSPARENT);

        }
    }
}
