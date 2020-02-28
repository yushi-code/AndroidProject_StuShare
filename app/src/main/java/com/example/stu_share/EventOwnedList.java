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

public class EventOwnedList extends AppCompatActivity {
    private Button btnCancel, btnEdit, btnViewAttend, btnCheckIn, btnLogout, btnHome;
    ListView listView;
    DBHelper dbHelper;
    private User user;
    private String REGISTER_URL="https://w0044421.gblearn.com/stu_share/EventView_Owned_Events.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_owned_list);
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
        dbHelper=new DBHelper(this);
        listView = (ListView) findViewById(R.id.listV1);
        dbHelper.downloadOwnedEventJSON(REGISTER_URL,user);
        AdminEventAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, EVENTS);
        listView.setAdapter(AdminEventAdapter);

        Log.d("TAG","OwnedEvent"+user.id);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event event2=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), EventOwnDetail.class);
                intent.putExtra("args",event2);
                intent.putExtra("user",user);

                startActivity(intent);

            }
        });
    }
    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void OpenMenuActivity() {
        Intent intent = new Intent(this, EventMenu.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }



}
