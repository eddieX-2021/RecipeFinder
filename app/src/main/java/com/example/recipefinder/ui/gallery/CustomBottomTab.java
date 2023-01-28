package com.example.recipefinder.ui.gallery;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recipefinder.R;

import java.util.ArrayList;
import java.util.List;

public class CustomBottomTab extends AbstractAssemble{
    private List<View> tabs = new ArrayList<>();
    private int curPosition = 0;
    private LinearLayout.LayoutParams tabsLp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1);
    private OnTabChangeListener mOnTabChangeListener;
    private LinearLayout rg = null;
    private final String TEXT_COLOR_NOR = "#909090";
    private final String TEXT_COLOR_SEL = "#2E86F6";

    public CustomBottomTab(Context mContext, ViewGroup parent, List<BottomList> data){
        super(mContext, parent, data);
    }


    @Override
    public View getView() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.layout_bottomtab,parent,false);
        rg =layout.findViewById(R.id.lat_mainbottomtab_frame);
        for(int i=0; i<data.size(); i++){
            View child = createTextButton((BottomList)data.get(i),i);
            tabs.add(child);
            rg.addView(child, tabsLp);

        }
        return layout;
    }

    private View createTextButton(final BottomList r, final int curPosition){
        View childView= LayoutInflater.from(mContext).inflate(R.layout.menu_item_maintab,rg,false);
        ImageView icon = childView.findViewById(R.id.tv_maintab_btn_icon);
        TextView text=childView.findViewById(R.id.tv_maintab_btn_text);
        icon.setImageResource(r.getUncheckedResId());
        text.setTextColor(Color.parseColor(TEXT_COLOR_NOR));
        text.setText(r.getShelfName());
        childView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(curPosition);
            }
        });

        return childView;
    }

    public void changeTab(int targetPosition){
        changeTabStatus(targetPosition);
        this.curPosition=targetPosition;
        if(mOnTabChangeListener!=null){
            mOnTabChangeListener.changeTabPage(targetPosition);
        }

    }

    private void changeTabStatus(int pressPosition){
        BottomList preData=(BottomList) data.get(curPosition);
        ImageView icon = tabs.get(curPosition).findViewById(R.id.tv_maintab_btn_icon);
//        TextView text=tabs.get(curPosition).findViewById(R.id.tv_maintab_btn_text);
        icon.setImageResource(((BottomList)data.get(curPosition)).getUncheckedResId());
//        text.setTextColor(Color.parseColor(TEXT_COLOR_NOR));

        BottomList pressData=(BottomList) data.get(pressPosition);
        ImageView icon2 = tabs.get(pressPosition).findViewById(R.id.tv_maintab_btn_icon);
//        TextView text2=tabs.get(pressPosition).findViewById(R.id.tv_maintab_btn_text);
        icon2.setImageResource(((BottomList)data.get(pressPosition)).getCheckedResId());
//        text2.setTextColor(Color.parseColor(TEXT_COLOR_SEL));
    }

    public void setmOnTabChangeListener(OnTabChangeListener mOnTabChangeListener){
        this.mOnTabChangeListener = mOnTabChangeListener;
    }

    public interface OnTabChangeListener{
        void changeTabPage(int position);
    }
}
