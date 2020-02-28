package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.stu_share.AdminEventList.AdminEventAdapter;
import static com.example.stu_share.EventCoordinator.EVENTS;

public class EventPastList extends AppCompatActivity {
    private Button btnLogout, btnHome;
    ListView listView;
    private DBHelper dbHelper;
    private User user;
    private String REGISTER_URL="https://w0044421.gblearn.com/stu_share/EventsView_PastEvents.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_past_list);
        user=(User)getIntent().getSerializableExtra("user");
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
                OpenHome();
            }
        });
        dbHelper=new DBHelper(this);
        listView = findViewById(R.id.listV);
        dbHelper.downloadEventJSON(REGISTER_URL,user);
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
                Intent intent =new Intent(getBaseContext(), EventPastDetail.class);
                intent.putExtra("args",event2);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
    public void OpenHome(){
        Intent intent =new Intent(this, EventMenu.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
