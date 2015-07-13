package com.laughingFace.microWash.ConnectionGuide.connectGuidePage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laughingFace.microWash.ConnectionGuide.AnimationFragment;
import com.laughingFace.microWash.ConnectionGuide.R;

/**
 * Created by mathcoder23 on 15-7-13.
 */
public class StartConnect extends AnimationFragment{
    private AnimationFragment.OnChangePage mOnChangePage;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guide_page_start_connect, container, false);
        this.mContext = this.getActivity().getApplicationContext();
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

    @Override
    public void setOnChangePage(AnimationFragment.OnChangePage onChangePage) {
        this.mOnChangePage = onChangePage;
    }

}
