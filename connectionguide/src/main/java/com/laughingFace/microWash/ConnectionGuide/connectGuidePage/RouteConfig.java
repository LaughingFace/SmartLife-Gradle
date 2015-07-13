package com.laughingFace.microWash.ConnectionGuide.connectGuidePage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.laughingFace.microWash.ConnectionGuide.AnimationFragment;
import com.laughingFace.microWash.ConnectionGuide.R;

import java.util.ArrayList;

/**
 * Created by mathcoder23 on 15-7-13.
 */
public class RouteConfig extends AnimationFragment{
    private AnimationFragment.OnChangePage mOnChangePage;
    private Context mContext;

    private View route_config_circle;
    private View route_config_device_icon;
    private View route_config_wifi_arrow_up;
    private View route_config_wifi_arrow_down;
    private View route_config_wifi_arrow;
    private View route_config_phone_arrow_up;
    private View route_config_phone_arrow_down;
    private View route_config_phone_arrow;
    private View route_config_wifi_icon;
    private View route_config_phone;
    private View route_config_finish;
    private View route_config_edittext;
    private View route_config_hint;

//    private View select_device_spinner;
//    private View check_power_text;
//    private View check_power_text;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guide_page_route_config, container, false);
        this.mContext = this.getActivity().getApplicationContext();

        route_config_circle = view.findViewById(R.id.route_config_circle);
        route_config_device_icon = view.findViewById(R.id.route_config_device_icon);
        route_config_phone_arrow_up = view.findViewById(R.id.route_config_phone_arrow_up);
        route_config_phone_arrow_down = view.findViewById(R.id.route_config_phone_arrow_down);
        route_config_phone_arrow = view.findViewById(R.id.route_config_phone_arrow);
        route_config_wifi_arrow_up = view.findViewById(R.id.route_config_wifi_arrow_up);
        route_config_wifi_arrow_down = view.findViewById(R.id.route_config_wifi_arrow_down);
        route_config_wifi_arrow = view.findViewById(R.id.route_config_wifi_arrow);
        route_config_wifi_icon = view.findViewById(R.id.route_config_wifi_icon);
        route_config_phone = view.findViewById(R.id.route_config_phone);
        route_config_edittext = view.findViewById(R.id.route_config_edittext);
        route_config_finish = view.findViewById(R.id.route_config_finish);
        route_config_hint = view.findViewById(R.id.route_config_hint);

        route_config_phone_arrow.setAlpha(0);
        route_config_wifi_arrow.setAlpha(0);
        route_config_wifi_icon.setAlpha(0);
        route_config_phone.setAlpha(0);
        route_config_edittext.setAlpha(0);
        route_config_finish.setAlpha(0);
        route_config_hint.setAlpha(0);

        route_config_circle.setVisibility(View.INVISIBLE);
        route_config_device_icon.setVisibility(View.INVISIBLE);

       route_config_finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               animationIn();
               route_config_circle.setVisibility(View.VISIBLE);
               route_config_device_icon.setVisibility(View.VISIBLE);
           }
       });

        return view;
    }

    @Override
    public void animationIn() {
        AnimatorSet route_config_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.route_config_in_animation);
        ArrayList<Animator> childs = route_config_in_animation.getChildAnimations();

        /**
         * 圆和机器滚入动画
         */
        ((AnimatorSet)childs.get(0)).getChildAnimations().get(0).setTarget(route_config_circle);
        ((AnimatorSet)childs.get(0)).getChildAnimations().get(1).setTarget(route_config_device_icon);
        childs.get(0).setDuration(800);

        /**
         *箭头出场动画
         */
        ((AnimatorSet)childs.get(1)).getChildAnimations().get(0).setTarget(route_config_wifi_arrow);
        ((AnimatorSet)childs.get(1)).getChildAnimations().get(1).setTarget(route_config_phone_arrow);
        childs.get(1).setDuration(400);

        /**
         *箭头蠕动动画
         */
        AnimatorSet route_config_arrow_animation_wifi = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.route_config_arrow_animation);
        route_config_arrow_animation_wifi.getChildAnimations().get(0).setTarget(route_config_wifi_arrow_up);
        route_config_arrow_animation_wifi.getChildAnimations().get(1).setTarget(route_config_wifi_arrow_down);
        route_config_arrow_animation_wifi.getChildAnimations().get(0).setDuration(1000).start();
        route_config_arrow_animation_wifi.getChildAnimations().get(1).setDuration(1000).start();

        AnimatorSet route_config_arrow_animation_phone = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.route_config_arrow_animation);
        route_config_arrow_animation_phone.getChildAnimations().get(0).setTarget(route_config_phone_arrow_up);
        route_config_arrow_animation_phone.getChildAnimations().get(1).setTarget(route_config_phone_arrow_down);
        route_config_arrow_animation_phone.getChildAnimations().get(0).setDuration(1000).start();
        route_config_arrow_animation_phone.getChildAnimations().get(1).setDuration(1000).start();


        /**
         *wifi,文本框和手机出场动画
         */
        ((AnimatorSet)childs.get(2)).getChildAnimations().get(0).setTarget(route_config_wifi_icon);
        ((AnimatorSet)childs.get(2)).getChildAnimations().get(1).setTarget(route_config_phone);
        ((AnimatorSet)childs.get(2)).getChildAnimations().get(2).setTarget(route_config_edittext);
        childs.get(2).setDuration(1000);

        /**
         * 完成 按钮出现动画
         */
        childs.get(3).setTarget(route_config_finish);
        childs.get(3).setDuration(800);

        /**
         * 说明文字 出现动画
         */
        //route_config_hint.setPivotX(300);
        childs.get(4).setTarget(route_config_hint);
        childs.get(4).setDuration(3000);

        route_config_in_animation.start();
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
