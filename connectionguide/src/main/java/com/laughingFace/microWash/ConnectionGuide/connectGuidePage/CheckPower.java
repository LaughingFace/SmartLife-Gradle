package com.laughingFace.microWash.ConnectionGuide.connectGuidePage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.laughingFace.microWash.ConnectionGuide.AnimationFragment;
import com.laughingFace.microWash.ConnectionGuide.R;

/**
 * Created by mathcoder23 on 15-7-10.
 */
public class CheckPower extends AnimationFragment {

    private Context context;

    View check_power_circle;
    View check_power_plug;
    View check_power_socket;
    View check_power_text;
    View check_power_finish;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("xixi","oncreateview");
            View view = inflater.inflate(R.layout.guide_page_check_power, container, false);
        this.context = this.getActivity().getApplicationContext();
        check_power_circle =view.findViewById(R.id.check_power_circle);
        check_power_plug = view.findViewById(R.id.check_power_plug);
        check_power_socket = view.findViewById(R.id.check_power_socket);
        check_power_text = view.findViewById(R.id.check_power_text);
        check_power_finish = view.findViewById(R.id.check_power_finish);

        check_power_finish.setAlpha(0);
        check_power_text.setAlpha(0);
        check_power_plug.setAlpha(0);

        check_power_circle.setVisibility(View.INVISIBLE);
        check_power_socket.setVisibility(View.INVISIBLE);

        check_power_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //animationIn();
//                animationPerform();
//                animationOut();
                //test();

                //check_power_text.setVisibility(View.VISIBLE);
                if (null != onChangePage)
//                onChangePage.nextPage();
                onChangePage.nextPage(CheckPower.this);
            }
        });
        view.post(new Runnable() {
            @Override
            public void run() {
                if (null != onChangePage)
                    onChangePage.initFinished(CheckPower.this);
            }
        });
        return view;
    }

    public void test(){
/*
        AnimatorSet as = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.test);

        as.getChildAnimations().get(0).setTarget(check_power_finish);
        as.getChildAnimations().get(0).setDuration(2000);
        //as.getChildAnimations().get(0).start();

        as.getChildAnimations().get(1).setTarget(check_power_text);
        as.getChildAnimations().get(1).setDuration(5000);
        //as.getChildAnimations().get(1).start();

//        as.setTarget(check_power_finish);
        as.start();*/

    }

    AnimatorSet plug_in_animation;
    AnimatorSet socket_in_animation;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    public void animationIn() {
        Log.i("aaa", "in....");
        Log.i("xixi", "animationIn");

        /**
         * 按钮和文字的动画
         */
        AnimatorSet finish_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.check_power_finish_in_animation);
        finish_in_animation.setTarget(check_power_finish);
        finish_in_animation.setInterpolator(new OvershootInterpolator());

        AnimatorSet text_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.check_power_text_in_animation);
        text_in_animation.setTarget(check_power_text);
        text_in_animation.setDuration(900).setStartDelay(200);

        text_in_animation.start();
        finish_in_animation.start();
        text_in_animation.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {

                AnimatorSet circle_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.check_power_circle_in);
                circle_in_animation.setTarget(check_power_circle);
                circle_in_animation.setDuration(700);

                 socket_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.in_socket);
                socket_in_animation.setTarget(check_power_socket);

                //圆形背景和插座滚入
                socket_in_animation.start();
                circle_in_animation.start();

                //插头入场动画
                 plug_in_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.check_power_plug_in);
                plug_in_animation.setTarget(check_power_plug);
                plug_in_animation.setStartDelay(700);
                plug_in_animation.start();

                check_power_circle.setVisibility(View.VISIBLE);
                check_power_socket.setVisibility(View.VISIBLE);

                super.onAnimationEnd(animation);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void animationOut() {
        plug_in_animation.cancel();
        socket_in_animation.cancel();
        Log.i("aaa", "out....");

        AnimatorSet circle_out_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.check_power_circle_out);
        circle_out_animation.setTarget(check_power_circle);
        circle_out_animation.setDuration(1500);
        circle_out_animation.start();

        AnimatorSet plug_out_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.check_power_plug_out);
        plug_out_animation.setTarget(check_power_plug);
        plug_out_animation.setDuration(1500);
        plug_out_animation.start();

        AnimatorSet socket_out_animation = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.check_power_plug_out);
        socket_out_animation.setTarget(check_power_socket);
        socket_out_animation.setDuration(1500);
        socket_out_animation.start();
        check_power_socket.animate().setDuration(1500).translationY(105).start();

        check_power_text.animate().setDuration(300).setStartDelay(1555).translationY(-1000)
                .scaleY(0).scaleX(0).start();
        ObjectAnimator.ofFloat(check_power_finish, "translationY", 0, -1000).setDuration(300).start();
        ObjectAnimator.ofFloat(check_power_finish,"scaleY",1,0.1f).setDuration(300).start();
        ObjectAnimator.ofFloat(check_power_finish,"scaleX",1,0.1f).setDuration(300).start();
        ObjectAnimator.ofFloat(check_power_finish,"alpha",1,0).setDuration(300).start();
//        check_power_finish.animate().setDuration(300).setStartDelay(5300).translationY(-1000)
//                .scaleY(0).scaleX(0).start();


    }

    @Override
    public void animationPerform() {

        plug_in_animation.cancel();
        socket_in_animation.cancel();
        AnimatorSet circle_perform_animation = (AnimatorSet) AnimatorInflater
                .loadAnimator(context,R.animator.check_power_circle_perform);
        circle_perform_animation.setDuration(500);
        circle_perform_animation.setTarget(check_power_circle);
        circle_perform_animation.start();

        AnimatorSet socket_perform_animation = (AnimatorSet) AnimatorInflater
                .loadAnimator(context, R.animator.check_power_socket_perform);
        socket_perform_animation.setDuration(500);
        socket_perform_animation.setTarget(check_power_socket);
        socket_perform_animation.start();

        AnimatorSet plug_perform_animation = (AnimatorSet) AnimatorInflater
                .loadAnimator(context, R.animator.check_power_plug_perform);
        plug_perform_animation.setDuration(700);
        plug_perform_animation.setInterpolator(new AccelerateInterpolator());
        plug_perform_animation.setTarget(check_power_plug);
        plug_perform_animation.setStartDelay(400);
        plug_perform_animation.start();
        plug_perform_animation.addListener(new AnimatorListenerAdapter() {
            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            @Override
            public void onAnimationEnd(Animator animation) {

                ( (ImageView)check_power_plug).setImageResource(R.mipmap.guide_page_check_power_plug_ratated);
                ViewPropertyAnimator vpa = check_power_plug.animate();
                vpa.setDuration(3).rotationX(0).scaleY(1).scaleX(1).start();
                super.onAnimationEnd(animation);
            }
        });


    }

    OnChangePage onChangePage;
    @Override
    public void setOnChangePage(OnChangePage onChangePage) {
       this.onChangePage = onChangePage;
    }
}
