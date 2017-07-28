package com.example.phobussng_2.thymely;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by LIM JING JIE on 17/7/2017.
 */

public class Font extends android.support.v7.widget.AppCompatTextView {

    public Font(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Font(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Font(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "assets/font/SF UI Display Regular.otf");
        setTypeface(tf ,1);

    }
}
