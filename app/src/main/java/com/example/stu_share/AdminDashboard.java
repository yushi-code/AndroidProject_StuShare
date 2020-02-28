package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.stu_share.EventCoordinator.EVENTS;

public class AdminDashboard extends AppCompatActivity {
    Button profile,viewUser,viewEvents, btnLogout;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        btnLogout = findViewById(R.id.btnAdminLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        user = (User) getIntent().getSerializableExtra("user");
        profile = findViewById(R.id.btnAdmProfile);
        viewUser = findViewById(R.id.btnViewUsers);
        viewEvents = findViewById(R.id.btnViewCurEvent);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyProfileEvent();
            }
        });
        viewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AdminEventList.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
        viewUser.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), AdminUserList.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }

    public void openMyProfileEvent(){

        Intent intent =new Intent(this, MyProfile.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
