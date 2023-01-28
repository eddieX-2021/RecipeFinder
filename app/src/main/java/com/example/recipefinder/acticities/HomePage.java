package com.example.recipefinder.acticities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.recipefinder.entity.FoodBody;
import com.example.recipefinder.ui.gallery.CheckOutPage;
import com.example.recipefinder.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    //ImageView orignal1;
    ImageView check1;

    SearchView homeSearch;

    ImageView homePic;
    ImageView favPic;
    ImageView planPic;
    ImageView profilePic;

//    Button homeButton;
    BottomNavigationItemView favButton;
    Button planButton;
    Button profileButton;
    Button checkOutButton;
    ImageButton shopButton;

    //ScrollView listOfIngredient;
//    HorizontalScrollView ingredientCategory;

    int a = 1;

    private RecyclerView foodList;
    private ImageButton fruitButton;
    private ImageButton meatButton;
    private ImageButton dairyButton;
    private ImageButton vegeButton;
    private ImageButton fishButton;

    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        foodList=findViewById(R.id.food_list);
//        bottomNavigationView=findViewById(R.id.bottomNavigationView);

//        favButton = bottomNavigationView.findViewById(R.id.favButton);

//        favButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openFavPage();
//            }
//        });
        //        favButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openFavPage();
//            }
//        });


        //orignal1 = findViewById(R.id.gainOrLoss);
        check1 = findViewById(R.id.imageView2);
        //create scearch
        homeSearch = findViewById(R.id.homeSearch);
        //ingredientCategory = findViewById(R.id.ingredientCategory);


        //0825delete
//        ingredientCategory = findViewById(R.id.ingredientCategory);

        //
//        orignal1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                check1.setVisibility(View.VISIBLE);
//            }
//        });

        //create all image view

        //create home button 0825 del
//        homeButton = (Button) findViewById(R.id.homeButton);
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openHomePage();
//            }
//        });
        //create favourtie button
//        favButton = (Button)findViewById(R.id.favButton);
//        favButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openFavPage();
//            }
//        });
        //create plan button
//        planButton = (Button)findViewById(R.id.planButton);
//        planButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPlanPage();
//            }
//        });
//        //create profile button
//        profileButton = (Button)findViewById(R.id.profileButton);
//        profileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openProfilePage();
//            }
//        });
        //create check out button
        checkOutButton = (Button) findViewById(R.id.checkOutButton);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckOutPage();
            }
        });
        //create shope button
        shopButton = (ImageButton) findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckOutPage();
            }
        });

        fruitButton=findViewById(R.id.fruitButton);
        fruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFruit();
            }
        });

        meatButton=findViewById(R.id.meatButton);
        meatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

        dairyButton=findViewById(R.id.dairyButton);
        vegeButton=findViewById(R.id.vegeButton);
        fishButton=findViewById(R.id.fishButton);

        dairyButton.setOnClickListener(this);
        vegeButton.setOnClickListener(this);
        fishButton.setOnClickListener(this);

        initData();
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.dairyButton){
            initDairy();

        }else if(view.getId()==R.id.vegeButton){
            initVege();

        }else if(view.getId()==R.id.fishButton){
            initFish();

        }

    }

    private void initFruit(){

        List<FoodBody> dataList=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Apple");
        one.setResId(R.drawable.apple_iv);

        FoodBody two =new FoodBody();
        two.setName("Mango");
        two.setResId(R.drawable.mango_iv);

        FoodBody three =new FoodBody();
        three.setName("Oranges");
        three.setResId(R.drawable.orange_iv);

        FoodBody four =new FoodBody();
        four.setName("Banana");
        four.setResId(R.drawable.banana_iv);
        dataList.add(one);
        dataList.add(two);
        dataList.add(three);
        dataList.add(four);

        FoodAdapter foodAdapter=new FoodAdapter(dataList,HomePage.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initData(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Beef");
        one.setResId(R.drawable.beef_iv);

//        FoodBody two =new FoodBody();
//        two.setName("Fish");
//        two.setResId(R.drawable.fish_iv);

        FoodBody three =new FoodBody();
        three.setName("Pork");
        three.setResId(R.drawable.pork_iv);

        dataListMeat.add(one);
//        dataListMeat.add(two);
        dataListMeat.add(three);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,HomePage.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initDairy(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Milk");
        one.setResId(R.drawable.milk_iv);

        dataListMeat.add(one);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,HomePage.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initFish(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Fish");
        one.setResId(R.drawable.fish_iv);

        dataListMeat.add(one);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,HomePage.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initVege(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Tomato");
        one.setResId(R.drawable.tomato_iv);

        FoodBody two =new FoodBody();
        two.setName("Potato");
        two.setResId(R.drawable.potato_iv);

        FoodBody three =new FoodBody();
        three.setName("Onion");
        three.setResId(R.drawable.onion_iv);

        dataListMeat.add(one);
        dataListMeat.add(two);
        dataListMeat.add(three);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,HomePage.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }




    //open home page function
    public void openHomePage(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
    //open favourite page function
    public void openFavPage(){
        Intent intent = new Intent(this, FavPage.class);
        startActivity(intent);
    }
    //open Plan page function
    public void openPlanPage(){
        Intent intent = new Intent(this, PlanPage.class);
        startActivity(intent);
    }
    //open profile page function
    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    //open check out page function
    public void openCheckOutPage(){
        Intent intent = new Intent(this, CheckOutPage.class);
        startActivity(intent);
    }

}