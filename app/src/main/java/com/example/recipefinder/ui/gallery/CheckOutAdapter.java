package com.example.recipefinder.ui.gallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.R;
import com.example.recipefinder.acticities.FoodAdapter;
import com.example.recipefinder.entity.FoodBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckOutAdapter extends RecyclerView.Adapter<CheckOutAdapter.FoodHolder>{


    private List<FoodBody> datas;
    private Context mContext;


    public CheckOutAdapter(List<FoodBody> list,Context context){
        datas=list;
        mContext=context;
    }

    @NonNull
    @Override
    public CheckOutAdapter.FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        CheckOutAdapter.FoodHolder viewHolder=new CheckOutAdapter.FoodHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CheckOutAdapter.FoodHolder holder, int position) {
        FoodBody one =datas.get(position);
        holder.text.setText(datas.get(position).getName());
        holder.iv.setImageDrawable(mContext.getDrawable(datas.get(position).getResId()));


        SharedPreferences sharedPreferences = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        String tag = "isCollect" + one.getName();
        int isColl=sharedPreferences.getInt(tag,0);
    }



    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    public static class FoodHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView iv;
        RelativeLayout whole;
        ImageView dui;

        public FoodHolder(View itemView){
            super(itemView);
            text=itemView.findViewById(R.id.food_text);
            whole=itemView.findViewById(R.id.food_whole);
            iv=itemView.findViewById(R.id.food_iv);
            dui=itemView.findViewById(R.id.dui_iv);
        }
    }
}
