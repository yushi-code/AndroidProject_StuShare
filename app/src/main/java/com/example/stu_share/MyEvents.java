package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyEvents extends AppCompatActivity {
    private Button  btnOwnedEvents, btnPstEvt,btnJoin,btnCreateEvent,btnHome, btnLogout,btnReg;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        btnCreateEvent=findViewById(R.id.btnCreate);
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateEvent();
            }
        });

        btnOwnedEvents = findViewById(R.id.btnOwnedEvents);
        btnOwnedEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOwnedEventActivity();
            }
        });
        btnJoin = findViewById(R.id.btnJoinEvt);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJoinActivity();
            }
        });
        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegActivity();
            }
        });
        btnPstEvt = findViewById(R.id.btnDeAct);
        btnPstEvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPstEvtAct();
            }
        });
        btnLogout = findViewById(R.id.btnLogout2);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        user=(User)getIntent().getSerializableExtra("user");
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
    }

    private void openRegActivity() {
        Intent intent =new Intent(this, ListJoinedEventActivity.class);
        String[] tt=new String[]{"2","2"};
        //intent.putExtra("args",tt);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void openOwnedEventActivity(){
        Intent intent =new Intent(this, Owned.class);
        String[] tt=new String[]{"2","2"};
        //intent.putExtra("args",tt);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void openPstEvtAct(){
        Intent intent =new Intent(this, PastEvent.class);
        String[] tt=new String[]{"2","2"};
        //intent.putExtra("args",tt);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void openJoinActivity(){
        Intent intent =new Intent(this, ListEvents.class);
        String[] tt=new String[]{"2","2"};
        //intent.putExtra("args",tt);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void openCreateEvent(){
        Intent intent =new Intent(this, CreateDescription.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void OpenMenuActivity() {
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
