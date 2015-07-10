package com.laughingFace.microWash.ConnectionGuide.connectGuidePage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.laughingFace.microWash.ConnectionGuide.AnimationFragment;
import com.laughingFace.microWash.ConnectionGuide.R;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by mathcoder23 on 15-7-10.
 */
public class CheckPower extends AnimationFragment {
//    @ViewInject(R.id.guide_page_check_power_finish)
//    TextView tvFinish;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.guide_page_check_power, container, false);
            int i = R.id.guide_page_check_power_finish;
        return view;
    }

    @Override
    public void animationIn() {

    }

    @Override
    public void animationOut() {

    }

    @Override
    public void animationPerform() {

    }
}
