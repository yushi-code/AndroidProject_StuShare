package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import static com.example.stu_share.EventCoordinator.EVENTS;


public class AdminEventDetail extends AppCompatActivity {
    private Button btnLogout,btnJoin, btnHome;
    private TextView txtEvtTitle,txtEvtDetail,txtStDate,txtStTime,txtEndTime,txtEndDate;
    DBHelper dbHelper;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event_detail);
        btnJoin=findViewById(R.id.btnSus);
        btnLogout=findViewById(R.id.btnLogout111);
        txtEvtTitle=findViewById(R.id.txtEventTitle);
        txtEvtDetail=findViewById(R.id.txtEvtDetail);
        txtStDate=findViewById(R.id.txtStDate);
        txtStTime=findViewById(R.id.txtStTime);
        txtEndDate=findViewById(R.id.txtEndDate);
        txtEndTime=findViewById(R.id.txtEndTime);
        user=(User)getIntent().getSerializableExtra("user");
        final EventCoordinator.Event event=(EventCoordinator.Event)getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event.eventTitle);
        txtEvtDetail.setText(event.eventDetail);
        txtStTime.setText(event.startTime);
        txtStDate.setText(event.startDate);
        txtEndDate.setText(event.endDate);
        txtEndTime.setText(event.endTime);
        dbHelper=new DBHelper(this);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "you have successfully suspended the event",
                        Toast.LENGTH_LONG).show();
                dbHelper.updateEventStatus("https://w0044421.gblearn.com/stu_share/EventSuspended.php",event.id);
                dbHelper.updateEventStatus("https://w0044421.gblearn.com/stu_share/eventRegDeleteByAdmin.php",event.id);
                Intent intent=new Intent(getBaseContext(),AdminDashboard.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        btnHome = findViewById(R.id.btnHome8);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
    }
    public void OpenMenuActivity(){
        Intent intent = new Intent(this, AdminDashboard.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}

