package com.example.recipefinder.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.recipefinder.R;
import com.example.recipefinder.RecipePage;
import com.example.recipefinder.acticities.FoodAdapter;
import com.example.recipefinder.acticities.HomePage;
import com.example.recipefinder.entity.FoodBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage extends AppCompatActivity {
    Button timeButton;
    Button calsButton;
    Button difficultyButton;
    Button cultureButton;
    Button checkOutBackButton;
    Button seeRecipeButton;

    TextView checkOutText;

    private RecyclerView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_page);
        checkOutText = findViewById(R.id.checkOutText);
        timeButton = (Button) findViewById(R.id.timeButton);
        calsButton = (Button) findViewById(R.id.calsButton);
        difficultyButton = (Button) findViewById(R.id.difficultyButton);
        cultureButton = (Button) findViewById(R.id.cultureButton);
        //create back to home button
        checkOutBackButton = (Button) findViewById(R.id.checkOutBackButton);
        checkOutBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHomePage();
            }
        });
        //create open recipe page button
        seeRecipeButton = (Button) findViewById(R.id.seeRecipeButton);
        seeRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecipePage();
            }
        });

        foodList=findViewById(R.id.food_list);

        initData();
    }

    private void initData(){
        SharedPreferences sharedPreferences = getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        List<FoodBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectData", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<FoodBody>>() {
            }.getType());


            CheckOutAdapter foodAdapter=new CheckOutAdapter(lists,this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            foodList.setAdapter(foodAdapter);
            foodList.setLayoutManager(gridLayoutManager);
        }


    }










    //return back to home page function
    public void backToHomePage(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    //open recipe page function
    public void openRecipePage(){
        Intent intent = new Intent(this, RecipePage.class);
        startActivity(intent);
    }
}