package com.example.recipefinder.acticities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipefinder.R;

public class PlanPage extends AppCompatActivity {
    ImageView homePic;
    ImageView favPic;
    ImageView planPic;
    ImageView profilePic;
    ImageView gainOrLoss;
    ImageView consumeCal;

    Button homeButton;
    Button favButton;
    Button planButton;
    Button profileButton;
    Button breakfastButton;
    Button lunchButton;
    Button dinnerButton;
    Button TDEEButton;

    TextView TDEEText;
    TextView gainOrLossText;
    TextView consumeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);
        //creat all text view
        TDEEText = findViewById(R.id.TDEEText);
        gainOrLossText = findViewById(R.id.gainOrLossText);
        consumeText = findViewById(R.id.consumeText);
        //create all image view
//        homePic = findViewById(R.id.homePic);
//        favPic = findViewById(R.id.favPic);
//        planPic = findViewById(R.id.planPic);
//        profilePic = findViewById(R.id.profilePic);
        gainOrLoss = findViewById(R.id.gainOrLoss);
        consumeCal = findViewById(R.id.consumeCal);
        //create home button
        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
        //create favourtie button
        favButton = (Button)findViewById(R.id.favButton);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFavPage();
            }
        });
        //create plan button
        planButton = (Button)findViewById(R.id.planButton);
        planButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlanPage();
            }
        });
        //create profile button
        profileButton = (Button)findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfilePage();
            }
        });
        breakfastButton = findViewById(R.id.breakfastButton);
        lunchButton = findViewById(R.id.lunchButton);
        dinnerButton = findViewById(R.id.dinnerButton);
        //TDEEButton = findViewById(R.id.TDEEButton);
    }
    //open home page function
    public void openHomePage(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    //open favourite page function
    public void openFavPage(){
        Intent intent = new Intent(this, FavPage.class);
        startActivity(intent);
    }
    //open Plan page function
    public void openPlanPage(){
        Intent intent = new Intent(this,PlanPage.class);
        startActivity(intent);
    }
    //open profile page function
    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
}
