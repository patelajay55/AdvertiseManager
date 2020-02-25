package com.photocompany.adsmanager.admob;

import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;


public class AddAdmobNativeBannerToLinearLayout {
     public AddAdmobNativeBannerToLinearLayout(final Context context, String bannerId, final int layoutToInflate, final LinearLayout adContainer){
        AdLoader adLoader = new AdLoader.Builder(context, bannerId)
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        NativeTemplateStyle styles = new NativeTemplateStyle.Builder().build();
                        TemplateView template = new TemplateView(context,layoutToInflate);
                        template.setStyles(styles);
                        adContainer.addView(template);
                        template.setNativeAd(unifiedNativeAd);
                    }
                })
                .build();

        adLoader.loadAd(requestAd());
    }
   private AdRequest requestAd(){
        return new AdRequest.Builder().build();
    }
}
