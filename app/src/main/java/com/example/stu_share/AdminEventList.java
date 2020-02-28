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
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.stu_share.EventCoordinator.EVENTS;

public class AdminEventList extends AppCompatActivity {
    Button btnLogout, btnHome;
    ListView listView;
    private User user;
    DBHelper dbHelper;
    public static ArrayAdapter AdminEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event_list);
        user=(User)getIntent().getSerializableExtra("user");
        dbHelper=new DBHelper(this);
        dbHelper.downloadEventJSON("https://w0044421.gblearn.com/stu_share/read_all_events.php",user);
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
                home();
            }
        });
        Log.d("USER in ADM EVT",user.toString());
        listView = (ListView) findViewById(R.id.eventList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event event2=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), AdminEventDetail.class);
                intent.putExtra("args",event2);
                intent.putExtra("user",user);
                startActivity(intent);

            }
        });

        AdminEventAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, EVENTS);
        listView.setAdapter(AdminEventAdapter);
    }
    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void home(){
        Intent intent = new Intent(this, AdminDashboard.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }




}


