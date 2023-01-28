package com.example.recipefinder.acticities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.recipefinder.R;

public class ProfilePage extends AppCompatActivity {
    ImageView homePic;
    ImageView favPic;
    ImageView planPic;
    ImageView profilePic;
    ImageView profilePicR;

    EditText nameTextField;
    EditText emailTextField;

    Button homeButton;
    Button favButton;
    Button planButton;
    Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        //create all image view
//        homePic = findViewById(R.id.homePic);
//        favPic = findViewById(R.id.favPic);
//        planPic = findViewById(R.id.planPic);
//        profilePic = findViewById(R.id.profilePic);
        //0825 del
//        profilePicR = findViewById(R.id.profilePicR);
//        //Edit Text
//        nameTextField = findViewById(R.id.nameTextField);
//        emailTextField = findViewById(R.id.emailTextField);
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
        Intent intent = new Intent(this, PlanPage.class);
        startActivity(intent);
    }
    //open profile page function
    public void openProfilePage(){
        Intent intent = new Intent(this,ProfilePage.class);
        startActivity(intent);
    }
}