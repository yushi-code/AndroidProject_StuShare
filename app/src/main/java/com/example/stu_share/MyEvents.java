package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyEvents extends AppCompatActivity {
    private Button  btnOwnedEvents, btnPstEvt,btnJoin,btnCreateEvent, btnLogout,btnReg;
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
        btnJoin = findViewById(R.id.btnJoin);
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
//                openRegActivity();
            }
        });
        btnPstEvt = findViewById(R.id.btnPstEvt);
        btnPstEvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPstEvtAct();
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

    public void openOwnedEventActivity(){
        Intent intent =new Intent(this, Owned.class);
        String[] tt=new String[]{"2","2"};
        intent.putExtra("args",tt);
        startActivity(intent);
    }
    public void openPstEvtAct(){
        Intent intent =new Intent(this, PastEvent.class);
        String[] tt=new String[]{"2","2"};
        intent.putExtra("args",tt);
        startActivity(intent);
    }
    public void openJoinActivity(){
        Intent intent =new Intent(this, ListJoinedEventActivity.class);
        String[] tt=new String[]{"2","2"};
        intent.putExtra("args",tt);
        startActivity(intent);
    }
    public void openCreateEvent(){
        Intent intent =new Intent(this, CreateDescription.class);
        startActivity(intent);
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
