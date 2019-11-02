package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyEvents extends AppCompatActivity {
    private Button  btnOwnedEvents, btnPstEvt,btnJoin,btnCreateEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        /*btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateDescriptionActivity();
            }
        });*/
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
        btnPstEvt = findViewById(R.id.btnPstEvt);
        btnPstEvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPstEvtAct();
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
}
