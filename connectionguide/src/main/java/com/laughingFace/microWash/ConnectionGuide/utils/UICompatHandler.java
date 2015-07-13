package com.laughingFace.microWash.ConnectionGuide.utils;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.laughingFace.microWash.ConnectionGuide.R;

/**
 * Created by mathcoder23 on 15-7-12.
 */
public class UICompatHandler {
    public static void adjustLinearLayout(Context context,LinearLayout linearLayout)
    {
        int width = ScreenUtil.getScreenWidth(context);
        int height = ScreenUtil.getScreenHeight(context);
        int desigWidth = height*9/16;
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
//        layoutParams.width = desigWidth;
//
//        linearLayout.setLayoutParams(layoutParams);
        int padding = (width - desigWidth)/2;
         linearLayout.setPadding(padding,0,padding,0);
    }
}
