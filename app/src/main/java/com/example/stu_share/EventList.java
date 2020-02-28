package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import static com.example.stu_share.AdminEventList.AdminEventAdapter;
import static com.example.stu_share.EventCoordinator.EVENTS;

public class EventList extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper;
    Button btnHome, btnLogout12;
    private User user3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EVENTS.clear();
        super.onCreate(savedInstanceState);
        dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_event_list);

        listView = (ListView) findViewById(R.id.listview333);
        user3=(User)getIntent().getSerializableExtra("user");
        dbHelper.downloadEventJSON("https://w0044421.gblearn.com/stu_share/EventView_Status_Active.php",user3);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event event2=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), EventDetail.class);
                intent.putExtra("args",event2);
                intent.putExtra("user",user3);
                startActivity(intent);

            }
        });
        AdminEventAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, EVENTS);
        listView.setAdapter(AdminEventAdapter);
        btnHome = findViewById(R.id.btnHome);
        btnLogout12 = findViewById(R.id.btnLogout12);
        btnLogout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });

    }

    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user",user3);
        startActivity(intent);
    }

    public void OpenMenuActivity() {
        Intent intent = new Intent(this, EventMenu.class);
        intent.putExtra("user",user3);
        startActivity(intent);
    }


}
