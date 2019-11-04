package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
        private Button btnMyEvents, btnViewEvents,btnCrtEvt, btnMyProfile, btnLogout;
    public static User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnMyEvents = findViewById(R.id.btnMyEvents);
        btnMyEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyEventsActivity();
            }
        });
        btnViewEvents = findViewById(R.id.btnViewEvents);
        btnViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewEventsActivity();
            }
        });
        user1=(User)getIntent().getSerializableExtra("user");
        btnCrtEvt=findViewById(R.id.btnCrtEvt);
        btnCrtEvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateEvent();
            }
        });
        btnMyProfile = findViewById(R.id.btnMyProfile);
        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyProfileEvent();
            }
        });
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }
    public void openMyEventsActivity(){
        Intent intent =new Intent(this, MyEvents.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
    public void openViewEventsActivity(){
        Intent intent =new Intent(this, ListEvents.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
    public void openCreateEvent(){
        Intent intent =new Intent(this, CreateDescription.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
    public void openMyProfileEvent(){
        Intent intent =new Intent(this, MyProfile.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }

    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
}
