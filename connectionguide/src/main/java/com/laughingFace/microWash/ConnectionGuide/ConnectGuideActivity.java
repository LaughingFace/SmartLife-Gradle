package com.laughingFace.microWash.ConnectionGuide;

import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.laughingFace.microWash.ConnectionGuide.connectGuidePage.CheckPower;
import com.laughingFace.microWash.ConnectionGuide.connectGuidePage.SelectDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathcoder23 on 15-7-9.
 */
public class ConnectGuideActivity extends FragmentActivity implements AnimationFragment.OnChangePage{
    private AnimationFragment mCheckPower;
    private AnimationFragment mSelectDevice;
    private List<AnimationFragment> fragmentList;
    private int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hehe);
        try{
            initFragment();
            selectFragment(index);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        selectFragment(++index%2);
    }

    private void initFragment()
    {
        fragmentList = new ArrayList<>();

        mCheckPower = new CheckPower();
        mSelectDevice = new SelectDevice();

        fragmentList.add(mCheckPower);
        fragmentList.add(mSelectDevice);
    }
    private void selectFragment(int i){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.id_content, fragmentList.get(i));
        transaction.commit();
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void previousPage() {

    }
}
