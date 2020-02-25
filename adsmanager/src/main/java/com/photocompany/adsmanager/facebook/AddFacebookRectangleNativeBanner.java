package com.photocompany.adsmanager.facebook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class AddFacebookRectangleNativeBanner {

    private int mAdBackgroundColor, mTitleColor, mCtaTextColor, mContentColor, mCtaBgColor;
    private static final int COLOR_LIGHT_GRAY = 0xff90949c;
    private static final int COLOR_DARK_GRAY = 0xff4e5665;
    private static final int COLOR_CTA_BLUE_BG = 0xff4080ff;
    //200 to 500
    private static final int DEFAULT_HEIGHT_DP = 200;
    private int mLayoutHeightDp = DEFAULT_HEIGHT_DP;
    Context context;

    public AddFacebookRectangleNativeBanner(Context context, String adsId, LinearLayout bannerAdContainer) {
        this.context = context;
        createAndLoadNativeAd(adsId,bannerAdContainer);
    }

    public AddFacebookRectangleNativeBanner(Context context, String adsId, LinearLayout bannerAdContainer, int adsSize) {
        this.context = context;
        mLayoutHeightDp = adsSize;
        createAndLoadNativeAd(adsId,bannerAdContainer);
    }

    private void createAndLoadNativeAd(String adsId, LinearLayout bannerAdContainer) {
        mAdBackgroundColor = Color.WHITE;
        mTitleColor = COLOR_DARK_GRAY;
        mCtaTextColor = COLOR_CTA_BLUE_BG;
        mContentColor = COLOR_LIGHT_GRAY;
        mCtaBgColor = Color.WHITE;
        NativeAd mNativeAd = new NativeAd(context, adsId);
        setAdListner(mNativeAd,bannerAdContainer);
        mNativeAd.loadAd();
    }
    private void setAdListner(final NativeAd mNativeAd,final LinearLayout adContainer) {
        mNativeAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (mNativeAd == null || mNativeAd != ad) {
                    // Race condition, load() called again before last ad was displayed
                    return;
                }
                reloadAdContainer(context, mNativeAd,adContainer);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
    }
    private void reloadAdContainer(Context context, final NativeAd mNativeAd, LinearLayout mNativeAdContainer) {

        if (context != null && mNativeAd != null && mNativeAd.isAdLoaded()) {
            mNativeAdContainer.removeAllViews();

            // Create a NativeAdViewAttributes object and set the attributes
            NativeAdViewAttributes attributes = new NativeAdViewAttributes()
                    .setBackgroundColor(mAdBackgroundColor)
                    .setTitleTextColor(mTitleColor)
                    .setDescriptionTextColor(mContentColor)
                    .setButtonBorderColor(mCtaTextColor)
                    .setButtonTextColor(mCtaTextColor)
                    .setButtonColor(mCtaBgColor);

            // Use NativeAdView.render to generate the ad View
            View mAdView = NativeAdView.render(context, mNativeAd, attributes);

            mNativeAdContainer.addView(mAdView, new ViewGroup.LayoutParams(MATCH_PARENT, 0));
            updateAdViewParams(mAdView);

        }
    }
    private void updateAdViewParams( View mAdView) {
        if (mAdView == null) {
            return;
        }
        ViewGroup.LayoutParams params = mAdView.getLayoutParams();
        params.height = (int) (Resources.getSystem().getDisplayMetrics().density * mLayoutHeightDp);
        mAdView.setLayoutParams(params);
        mAdView.requestLayout();
    }
}
