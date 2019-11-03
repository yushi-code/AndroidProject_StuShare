package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {
    Button profile;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        user=(User)getIntent().getSerializableExtra("user");
        profile = findViewById(R.id.btnAdmProfile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyProfileEvent();
            }
        });

    }
    public void openMyProfileEvent(){
        Intent intent =new Intent(this, MyProfile.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
