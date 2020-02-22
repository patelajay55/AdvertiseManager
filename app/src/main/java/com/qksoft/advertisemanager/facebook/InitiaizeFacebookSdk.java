package com.qksoft.advertisemanager.facebook;

import android.content.Context;

import com.facebook.ads.AudienceNetworkAds;

public class InitiaizeFacebookSdk {
    public InitiaizeFacebookSdk(Context context) {
        AudienceNetworkAds.initialize(context);
    }
}
