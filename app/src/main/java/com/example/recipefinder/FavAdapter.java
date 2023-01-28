package com.example.recipefinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.entity.RecipeBody;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavHolder>{

    private List<RecipeBody> datas;
    private Context mContext;

    public FavAdapter(List<RecipeBody> list,Context context){
        datas=list;
        mContext=context;
    }

    @NonNull
    @Override
    public FavHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        FavHolder viewHolder=new FavHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavHolder holder, int position) {
        RecipeBody recipeBody=datas.get(position);
        holder.iv.setImageDrawable(mContext.getDrawable(recipeBody.getResId()));

        holder.whole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,DetailActivity.class);
                intent.putExtra("name",recipeBody.getName());
                intent.putExtra("res",recipeBody.getResId());
                intent.putExtra("ingre",recipeBody.getIngredient());
                intent.putExtra("how",recipeBody.getMake());
                intent.putExtra("cal",recipeBody.getCalories());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    public void setNewData(List<RecipeBody> lists){
        this.datas=lists;
//        notifyDataSetChanged();

    }


    public static class FavHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        RelativeLayout whole;

        public FavHolder(View itemView){
            super(itemView);
            whole=itemView.findViewById(R.id.fav_whole);
            iv=itemView.findViewById(R.id.fav_iv);
        }
    }
}
