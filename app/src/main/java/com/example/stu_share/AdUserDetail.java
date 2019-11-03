package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdUserDetail extends AppCompatActivity {
    TextView txtDetail;
    Button btnDeact,btnLogout,btnAct;
    DBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_user_detail);
        final User userDetail=(User)getIntent().getSerializableExtra("args");
        txtDetail=findViewById(R.id.txtAcctDerail);
        btnAct=findViewById(R.id.btnAct);
        btnDeact=findViewById(R.id.btnDeAct);
        txtDetail.setText(userDetail.toString());
        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(getBaseContext());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.updateUserStatus(db,userDetail.email,"active");

            }
        });
        btnDeact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(getBaseContext());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.updateUserStatus(db,userDetail.email,"suspended");

            }
        });
    }
}
