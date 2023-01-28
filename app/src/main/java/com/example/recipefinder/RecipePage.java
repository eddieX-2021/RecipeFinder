package com.example.recipefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipefinder.acticities.FoodAdapter;
import com.example.recipefinder.entity.RecipeBody;
import com.example.recipefinder.ui.gallery.CheckOutPage;

import java.util.ArrayList;
import java.util.List;

public class RecipePage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView backIv;
    private TextView backTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        recyclerView=findViewById(R.id.recipe_list);
        backIv=findViewById(R.id.home_back);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        backTv=findViewById(R.id.home_title_text);
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        initData();


    }

    private void initData(){

        RecipeBody one=new RecipeBody();
        one.setName("Onion tomato soup");
        one.setResId(R.drawable.onion_tomato_soup);
        one.setIngredient("Onion tomato chicken beef");
        one.setMake("In a large pot, gently sauté the onions in the butter until they caramelize, about 15 minutes. Season with salt and pepper. Deglaze with the wine. Add the broth and tomatoes. Bring to a boil and simmer for about 10 minutes. Season with salt and pepper.");
        one.setCalories(249);

        RecipeBody two=new RecipeBody();
        two.setName("Bone-in Pork Chops");
        two.setResId(R.drawable.bone_pork);
        two.setIngredient("pork");
        two.setMake("Season the pork chops on both sides with salt and pepper. In a large, cast-iron skillet, heat the oil, three turns of the pan, over medium-high. When the oil ripples and smokes, add the chops and cook until browned, 2 minutes per side. Using tongs, lift the chops and brown them on the edges; transfer to a plate");
        two.setCalories(390);

        RecipeBody three=new RecipeBody();
        three.setName("Shrimp with Mustard Sauce");
        three.setResId(R.drawable.recipe_shrimp);
        three.setIngredient("shrimp");
        three.setMake("In a bowl, whisk together the cornstarch and water. Stir in the mustard and set aside.");
        three.setCalories(290);

        List<RecipeBody> recipeBodyList=new ArrayList<>();
        recipeBodyList.add(one);
        recipeBodyList.add(two);
        recipeBodyList.add(three);

        RecipeAdapter recipeAdapter=new RecipeAdapter(recipeBodyList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(recipeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);



    }







    //return back to home page function
    public void backToCheckOutPage(){
        Intent intent = new Intent(this, CheckOutPage.class);
        startActivity(intent);
    }
}