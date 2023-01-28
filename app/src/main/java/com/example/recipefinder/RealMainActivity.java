package com.example.recipefinder;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.recipefinder.fragment.FavFragment;
import com.example.recipefinder.fragment.MainHomeFragment;
import com.example.recipefinder.fragment.PlanFragment;
import com.example.recipefinder.fragment.ProfileFragment;
import com.example.recipefinder.ui.gallery.BottomList;
import com.example.recipefinder.ui.gallery.CustomBottomTab;


import java.util.ArrayList;
import java.util.List;

public class RealMainActivity extends AppCompatActivity {

    private LinearLayout simple_fragment_mine_ll;
    private Fragment[] mFragments;
    private CustomBottomTab mainBottomTab;
    private int mIndex =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentwebview);

        initTab();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initTab(){
        simple_fragment_mine_ll = findViewById(R.id.simple_fragment_mine_ll);
        ArrayList<BottomList> topShelfLists=new ArrayList<>();

        BottomList topMain1=new BottomList();
        topMain1.setShelfName("Home");
        topMain1.setCheckedResId(R.drawable.home_sel);
        topMain1.setUncheckedResId(R.drawable.home_nor);


        BottomList topMain2=new BottomList();
        topMain2.setShelfName("Favorite");
        topMain2.setCheckedResId(R.drawable.order_sel);
        topMain2.setUncheckedResId(R.drawable.order_nor);

        BottomList topMain3=new BottomList();
        topMain3.setShelfName("Plan");
        topMain3.setCheckedResId(R.drawable.order_sel);
        topMain3.setUncheckedResId(R.drawable.order_nor);


        BottomList topMain4=new BottomList();
        topMain4.setShelfName("Profile");
        topMain4.setCheckedResId(R.drawable.my_sel);
        topMain4.setUncheckedResId(R.drawable.my_nor);

        topShelfLists.add(topMain1);
        topShelfLists.add(topMain2);
        topShelfLists.add(topMain3);
        topShelfLists.add(topMain4);

        initTabPage(topShelfLists);

        mainBottomTab=new CustomBottomTab(this,simple_fragment_mine_ll,topShelfLists);
        LinearLayout.LayoutParams tabsLp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        simple_fragment_mine_ll.addView(mainBottomTab.getView(),tabsLp);
        mainBottomTab.setmOnTabChangeListener(new CustomBottomTab.OnTabChangeListener() {
            @Override
            public void changeTabPage(int position) {
                setIndexSelected(position);
            }
        });

        changeTabPageCustom(0);

    }


    private void initTabPage(List<BottomList> topShelfLists){
        mFragments =new Fragment[topShelfLists.size()];
        for(int i=0; i<topShelfLists.size(); i++){
            Fragment page = null;
            if(i==0){
                page = new MainHomeFragment();
            }else if(i==1){
                page = new FavFragment();
            }else if(i==2){
                page = new PlanFragment();
            }else if(i==3){
                page = new ProfileFragment();
            }

            mFragments[i] = page;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_content,mFragments[0]).commit();
    }

    private void setIndexSelected(int index){
        if(mIndex==index)
            return;

        FragmentTransaction ft;
        FragmentManager fragmentManager;

        if(!mFragments[index].isAdded()){
            fragmentManager=getSupportFragmentManager();
            ft=fragmentManager.beginTransaction();
            ft.hide(mFragments[mIndex]);
            ft.add(R.id.fl_content,mFragments[index]);
            ft.show(mFragments[index]);
            ft.commit();
            mIndex=index;
        }else{
            fragmentManager=getSupportFragmentManager();
            ft=fragmentManager.beginTransaction();
            ft.hide(mFragments[mIndex]);

            Fragment page = null;
            if(index==0){
                page = new MainHomeFragment();
            }else if(index==1){
                page = new FavFragment();
            }else if(index==2){
                page = new PlanFragment();
            }else if(index==3){
                page = new ProfileFragment();
            }
            mFragments[index] = page;
            ft.replace(R.id.fl_content,mFragments[index]);

            ft.show(mFragments[index]);
//            ft.show(mFragments[index]);
            ft.commit();
            mIndex=index;
        }

        Log.d("0825","index: "+index);

    }

    public void changeTabPageCustom(int position){
        if(mainBottomTab!=null){
            mainBottomTab.changeTab(position);
        }
    }








}
