package com.photocompany.adsmanager.admob;

import android.content.Context;

import com.google.android.gms.ads.MobileAds;

public class InitializeAdmobSdk {

    public InitializeAdmobSdk(Context context , String appId) {
         MobileAds.initialize(context, appId);
     }
 }
