package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdUserDetail extends AppCompatActivity {
    TextView txtDetail;
    Button btnDeact,btnLogout,btnAct, btnHome;
    DBHelper dbHelper;
    private User userDetail;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_detail);
        dbHelper=new DBHelper(this);
        userDetail=(User)getIntent().getSerializableExtra("args");
        user=(User)getIntent().getSerializableExtra("user");
        txtDetail=findViewById(R.id.txtAcctDerail);
        btnAct=findViewById(R.id.btnAct);
        btnLogout=findViewById(R.id.btnLogout2);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        btnDeact=findViewById(R.id.btnDeAct);
        txtDetail.setText(userDetail.toString());
        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "User is activated!",
                        Toast.LENGTH_LONG).show();
                Intent intent =new Intent(getBaseContext(),AdminDashboard.class);
                dbHelper.adminUpdateUser("https://w0044421.gblearn.com/stu_share/user_status_update.php","active",userDetail);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        btnDeact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "User is suspended!",
                        Toast.LENGTH_LONG).show();
                dbHelper.adminUpdateUser("https://w0044421.gblearn.com/stu_share/user_status_update.php","suspended",userDetail);
                Intent intent =new Intent(getBaseContext(),AdminDashboard.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        btnHome = findViewById(R.id.btnHome19);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
    }

    public void OpenMenuActivity() {
        Intent intent = new Intent(this, AdminDashboard.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}