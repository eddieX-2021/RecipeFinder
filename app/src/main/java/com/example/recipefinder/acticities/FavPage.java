package com.example.recipefinder.acticities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.recipefinder.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavPage extends AppCompatActivity {
    ImageView homePic;
    ImageView favPic;
    ImageView planPic;
    ImageView profilePic;

    BottomNavigationItemView homeButton;
    BottomNavigationItemView favButton;
    BottomNavigationItemView planButton;
    BottomNavigationItemView profileButton;
    private BottomNavigationView bottomNavigationView;
    ImageButton favAdd;

    SearchView favSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_page);
//        homePic = findViewById(R.id.homePic);
//        favPic = findViewById(R.id.favPic);
//        planPic = findViewById(R.id.planPic);
//        profilePic = findViewById(R.id.profilePic);
//        bottomNavigationView=findViewById(R.id.bottomNavigationView);
//        //0825 del
////        favSearch = findViewById(R.id.favSearch);
//        //create home button
//        homeButton =  findViewById(R.id.homeButton);
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openHomePage();
//            }
//        });
//        //create favourtie button
//        favButton = findViewById(R.id.favButton);
//        favButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openFavPage();
//            }
//        });
//        //create plan button
//        planButton = findViewById(R.id.planButton);
//        planButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPlanPage();
//            }
//        });
//        //create profile button
//        profileButton = findViewById(R.id.profileButton);
//        profileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openProfilePage();
//            }
//        });
        //create add favourite function

        //0825 del
//        favAdd = (ImageButton) findViewById(R.id.favAdd);
//        favAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openHomePage();
//            }
//        });
    }
    //open home page function
    public void openHomePage(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    //open favourite page function
    public void openFavPage(){
        Intent intent = new Intent(this,FavPage.class);
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
}