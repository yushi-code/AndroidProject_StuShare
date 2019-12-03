package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EventMenu extends AppCompatActivity {
        private Button btnMyEvents, btnViewEvents,btnCrtEvt, btnHome, btnLogout;
    public static User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_menu);
        btnHome=findViewById(R.id.btnMainMenu1);
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
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),MainMenu.class);
                i.putExtra("user",user1);
                startActivity(i);
            }
        });
        btnLogout = findViewById(R.id.btnAlLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        Button btnMessageCenter=findViewById(R.id.btnAlMessageCenter);
        btnMessageCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MessageList.class);
//              intent.putExtra("args", userReg);
                startActivity(intent);
            }
        });


    }
    public void openMyEventsActivity(){
        Intent intent =new Intent(this, EventMyEvents.class);
        intent.putExtra("user",user1);
        Log.d("TAG","Menu to MyEvent"+user1.id);
        startActivity(intent);
    }
    public void openViewEventsActivity(){
        Intent intent =new Intent(this, EventList.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
    public void openCreateEvent(){
        Intent intent =new Intent(this, EventCreateDescription.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }


    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }
}
