package com.photocompany.adsmanager.admob;

import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AddAdmobBannerToLinearLayout1 {

    public AddAdmobBannerToLinearLayout1(Context context, String bannerId, AdSize adSize, LinearLayout adContainer) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        adContainer.addView(geteBannerAd(context,adSize,bannerId),params);
    }
    private AdView geteBannerAd(Context context, AdSize adSize, String bannerId) {
        AdView adView = new AdView(context);
        adView.setAdSize(adSize);
        adView.setAdUnitId(bannerId);
        adView.loadAd(requestAd());
        return adView;
    }
    private AdRequest requestAd(){
        return new AdRequest.Builder().build();
    }
}
