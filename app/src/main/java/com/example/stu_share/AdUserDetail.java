package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdUserDetail extends AppCompatActivity {
    TextView txtDetail;
    Button btnDeact,btnLogout,btnAct, btnHome;
    //DBHelper dbHelper = null;
    private User userDetail;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_user_detail);
        userDetail=(User)getIntent().getSerializableExtra("args");
        user=(User)getIntent().getSerializableExtra("user");
        txtDetail=findViewById(R.id.txtAcctDerail);
        btnAct=findViewById(R.id.btnAct);
        btnLogout=findViewById(R.id.btnLogout2);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(),AdminDashboardActivity.class);
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
                Intent intent =new Intent(getBaseContext(),AdminDashboardActivity.class);
                intent.putExtra("user",userDetail);
                startActivity(intent);
            }
        });
        btnDeact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "User is suspended!",
                        Toast.LENGTH_LONG).show();
                Intent intent =new Intent(getBaseContext(),AdminDashboardActivity.class);
                intent.putExtra("user",userDetail);
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
        Intent intent = new Intent(this, AdminDashboardActivity.class);
        intent.putExtra("user",userDetail);
        startActivity(intent);
    }
}