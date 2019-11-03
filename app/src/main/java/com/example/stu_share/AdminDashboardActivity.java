package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {
    Button profile,viewUser,viewEvents;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        user=(User)getIntent().getSerializableExtra("user");
        profile = findViewById(R.id.btnAdmProfile);
        viewUser=findViewById(R.id.btnViewUsers);
        viewEvents=findViewById(R.id.btnViewCurEvent);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyProfileEvent();
            }
        });
        viewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),AdEventList.class);
                startActivity(intent);
            }
        });
        viewUser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getBaseContext(),UserList.class);
            startActivity(intent);
        }
        });
        }
    public void openMyProfileEvent(){
        Intent intent =new Intent(this, MyProfile.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
