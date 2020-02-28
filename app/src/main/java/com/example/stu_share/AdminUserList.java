package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
import static com.example.stu_share.User.USERS;

public class AdminUserList extends AppCompatActivity {
    Button btnLogout, btnHome;
    ListView listView;
    DBHelper dbHelper;
    private User user2,user1;
    TextView txt;
    public static ArrayAdapter AdminUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_admin_user_list);
        dbHelper.downloadUserJSON("https://w0044421.gblearn.com/stu_share/read_all_users.php");
        listView = findViewById(R.id.listUser);
        AdminUserAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, USERS);
        listView.setAdapter(AdminUserAdapter);
        btnLogout = findViewById(R.id.btnLogout);
        user1=(User)getIntent().getSerializableExtra("user");
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                User user2=(User) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), AdUserDetail.class);
                intent.putExtra("args",user2);
                intent.putExtra("user",user1);
                startActivity(intent);
            }
        });
    }
    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void home(){
        Intent intent = new Intent(this, AdminDashboard.class);
        intent.putExtra("user",user1);
        startActivity(intent);
    }

}

