package com.laughingFace.microWash.ConnectionGuide;

import android.app.Application;

import com.laughingFace.microWash.ConnectionGuide.utils.FontsOverride;

/**
 * Created by mathcoder23 on 15-7-14.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "MyFontAsset.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "MyFontAsset2.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "MyFontAsset3.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "MyFontAsset4.ttf");
    }
}
