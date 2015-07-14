package com.laughingFace.microWash.ConnectionGuide.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.laughingFace.microWash.ConnectionGuide.R;

/**
 * Created by mathcoder23 on 15-7-14.
 */
public class FontTextView extends TextView {
    private Context mContext;
    public FontTextView(Context context) {
        super(context);
        this.mContext = context;
        setFontType();
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setFontType();
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setFontType();
    }

    public void setFontType()
    {
        this.setTypeface(Typeface.createFromAsset(mContext.getAssets(),mContext.getString(R.string.font_family)));
        TextPaint tp = this.getPaint();
        tp.setFakeBoldText(true);
        this.setLineSpacing(3,1.2f);
    }
}
