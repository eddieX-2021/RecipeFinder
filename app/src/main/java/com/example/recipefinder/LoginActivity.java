package com.example.recipefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recipefinder.acticities.HomePage;

public class LoginActivity extends AppCompatActivity {

    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, HomePage.class));
                startActivity(new Intent(LoginActivity.this, RealMainActivity.class));

            }
        });
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }


}