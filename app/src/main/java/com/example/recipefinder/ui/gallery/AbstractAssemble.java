package com.example.recipefinder.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class AbstractAssemble {
    protected ViewGroup parent;
    protected Context mContext;
    protected List<?> data;

    public AbstractAssemble(Context mContext, ViewGroup parent, List<?> data){
        this.parent = parent;
        this.mContext = mContext;
        this.data = data;
    }

    public abstract View getView();
}
