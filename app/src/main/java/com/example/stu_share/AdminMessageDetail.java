package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMessageDetail extends AppCompatActivity {
    Button btnDelete, btnCancel;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_message_detail);
        user=(User)getIntent().getSerializableExtra("user") ;
        btnCancel = findViewById(R.id.btnCancel_Admin);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AdminMessageList.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}
