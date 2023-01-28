package com.example.recipefinder.acticities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.R;
import com.example.recipefinder.entity.FoodBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {


    private List<FoodBody> datas;
    private Context mContext;


    public FoodAdapter(List<FoodBody> list,Context context){
        datas=list;
        mContext=context;
    }


    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        FoodHolder viewHolder=new FoodHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        FoodBody one =datas.get(position);
        holder.text.setText(datas.get(position).getName());
        holder.iv.setImageDrawable(mContext.getDrawable(datas.get(position).getResId()));


        SharedPreferences sharedPreferences = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        String tag = "isCollect" + one.getName();
        int isColl=sharedPreferences.getInt(tag,0);


        if(isColl==2){
            holder.dui.setVisibility(View.VISIBLE);
        }else{
            holder.dui.setVisibility(View.GONE);
        }

        holder.whole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
                String tag = "isCollect" + one.getName();
                int isCollect=sharedPreferences.getInt(tag,0);
                if(isCollect==2){
                    remove(one);
                    holder.dui.setVisibility(View.GONE);
                }else{
                    add(one);
                    holder.dui.setVisibility(View.VISIBLE);
                }


            }
        });




    }

    private void add(FoodBody one){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<FoodBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectData", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<FoodBody>>() {
            }.getType());
        }
        lists.add(one);

        Gson add = new Gson();
        String addJson = add.toJson(lists);
        editor.putString("collectData", addJson);
        editor.apply();


//        SharedPreferences shared = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorShared = sharedPreferences.edit();

        String tag = "isCollect" + one.getName();
        editorShared.putInt(tag, 2);
        editorShared.apply();

    }

    private void remove(FoodBody one){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<FoodBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectData", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<FoodBody>>() {
            }.getType());
        }
        Iterator<FoodBody> iterator = lists.iterator();
        while (iterator.hasNext()) {
            FoodBody obj = iterator.next();
            if (obj.getName().equals(one.getName())) {
                iterator.remove();
            }
        }


        Gson add = new Gson();
        String addJson = add.toJson(lists);
        editor.putString("collectData", addJson);
        editor.apply();


        SharedPreferences.Editor editorShared = sharedPreferences.edit();

        String tag = "isCollect" + one.getName();
        editorShared.putInt(tag, 1);
        editorShared.apply();

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
