package com.example.recipefinder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipefinder.entity.FoodBody;
import com.example.recipefinder.entity.RecipeBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView detailIv,collectIv,cancelCollectIv,homeBack;
    private TextView detailName;
    private TextView ingredient, make;

    private String name,ingre,how;
    private int resId,cal;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        initView();
        initData();
    }

    private void initView(){
        detailIv=findViewById(R.id.detail_iv);
        detailName=findViewById(R.id.detail_name);
        ingredient=findViewById(R.id.text_two);
        make=findViewById(R.id.text_four);
        collectIv=findViewById(R.id.collect_iv);
        collectIv.setOnClickListener(this);

        cancelCollectIv=findViewById(R.id.cancel_collect_iv);
        cancelCollectIv.setOnClickListener(this);

        homeBack=findViewById(R.id.home_back);
        homeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void initData(){
        name=getIntent().getStringExtra("name");
        detailName.setText(name);

        ingre=getIntent().getStringExtra("ingre");
        ingredient.setText(ingre);

        how=getIntent().getStringExtra("how");
        make.setText(how);

        resId=getIntent().getIntExtra("res",0);
        detailIv.setImageDrawable(getDrawable(resId));

        cal=getIntent().getIntExtra("cal",0);


        SharedPreferences shared = getSharedPreferences("collect", Context.MODE_PRIVATE);

        String tag = "isCollectDetail" + name;
        int prefer=shared.getInt(tag,0);
        if(prefer==2){
            cancelCollectIv.setVisibility(View.VISIBLE);
            collectIv.setVisibility(View.GONE);
        }else {
            cancelCollectIv.setVisibility(View.GONE);
            collectIv.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View view) {
        RecipeBody recipeBody=new RecipeBody();
        recipeBody.setName(name);
        recipeBody.setCalories(cal);
        recipeBody.setMake(how);
        recipeBody.setIngredient(ingre);
        recipeBody.setResId(resId);
        if(view.getId()==R.id.collect_iv){
            add(recipeBody);
            cancelCollectIv.setVisibility(View.VISIBLE);
            collectIv.setVisibility(View.GONE);
        }else if(view.getId()==R.id.cancel_collect_iv){
            remove(recipeBody);
            cancelCollectIv.setVisibility(View.GONE);
            collectIv.setVisibility(View.VISIBLE);
        }

    }

    private void add(RecipeBody one){
        SharedPreferences sharedPreferences = getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<RecipeBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectDetail", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<RecipeBody>>() {
            }.getType());
        }
        lists.add(one);

        Gson add = new Gson();
        String addJson = add.toJson(lists);
        editor.putString("collectDetail", addJson);
        editor.apply();


//        SharedPreferences shared = mContext.getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorShared = sharedPreferences.edit();

        String tag = "isCollectDetail" + one.getName();
        editorShared.putInt(tag, 2);
        editorShared.apply();

    }

    private void remove(RecipeBody one){
        SharedPreferences sharedPreferences = getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<RecipeBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectDetail", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<RecipeBody>>() {
            }.getType());
        }
        Iterator<RecipeBody> iterator = lists.iterator();
        while (iterator.hasNext()) {
            RecipeBody obj = iterator.next();
            if (obj.getName().equals(one.getName())) {
                iterator.remove();
            }
        }


        Gson add = new Gson();
        String addJson = add.toJson(lists);
        editor.putString("collectDetail", addJson);
        editor.apply();


        SharedPreferences.Editor editorShared = sharedPreferences.edit();

        String tag = "isCollectDetail" + one.getName();
        editorShared.putInt(tag, 1);
        editorShared.apply();

    }
}
