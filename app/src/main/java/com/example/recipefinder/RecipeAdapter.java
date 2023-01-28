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

import com.example.recipefinder.entity.FoodBody;
import com.example.recipefinder.entity.RecipeBody;
import com.example.recipefinder.ui.gallery.CheckOutAdapter;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder>{
    private List<RecipeBody> datas;
    private Context mContext;


    public RecipeAdapter(List<RecipeBody> list,Context context){
        datas=list;
        mContext=context;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        RecipeAdapter.RecipeHolder viewHolder=new RecipeAdapter.RecipeHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        RecipeBody recipeBody=datas.get(position);
        holder.text.setText(recipeBody.getName());
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

    public static class RecipeHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView iv;
        RelativeLayout whole;

        public RecipeHolder(View itemView){
            super(itemView);
            text=itemView.findViewById(R.id.recipe_name);
            whole=itemView.findViewById(R.id.recipe_whole);
            iv=itemView.findViewById(R.id.recipe_iv);
        }
    }
}
