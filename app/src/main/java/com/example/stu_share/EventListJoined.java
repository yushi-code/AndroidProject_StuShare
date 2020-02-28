package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import static com.example.stu_share.AdminEventList.AdminEventAdapter;
import static com.example.stu_share.EventCoordinator.EVENTS;

public class EventListJoined extends AppCompatActivity {
    Button btnLogout, btnHome;
    ListView listView;
    private User user ;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_event_list_joined);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
        user=(User)getIntent().getSerializableExtra("user");
        listView = (ListView) findViewById(R.id.listView2323);
        dbHelper.downloadEventJSON("https://w0044421.gblearn.com/stu_share/EventsRegistered.php",user);
        AdminEventAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, EVENTS);
        listView.setAdapter(AdminEventAdapter);
        Log.d("TAG","LISTJOINEVENT"+user.id);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event event2=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), EventJoinedDetail.class);
                intent.putExtra("args",event2);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void OpenMenuActivity() {
        Intent intent = new Intent(this, EventMenu.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
