package com.laughingFace.microWash.ConnectionGuide;

import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.widget.TextView;
import com.laughingFace.microWash.ConnectionGuide.connectGuidePage.CheckPower;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by mathcoder23 on 15-7-9.
 */
public class ConnectGuideActivity extends FragmentActivity {
    AnimationFragment mCheckPower;
//    @ViewInject(R.id.id_content)
//    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hehe);
        setDefaultFragment();
    }
    private void setDefaultFragment()
    {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mCheckPower = new CheckPower();
        transaction.replace(R.id.id_content, mCheckPower);
        transaction.commit();
    }
}
