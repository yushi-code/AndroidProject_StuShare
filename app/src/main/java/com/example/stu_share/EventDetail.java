package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

public class EventDetail extends AppCompatActivity {
    private Button btnLogout, btnJoin, btnLogout2, btnHome3;
    private TextView txtEvtTitle, txtEvtDetail, txtStDate, txtStTime, txtEndTime, txtEndDate;
    private User user2;
    DBHelper dbHelper;
    private EventCoordinator.Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        dbHelper=new DBHelper(this);
        btnJoin = findViewById(R.id.btnJoin);
        btnLogout = findViewById(R.id.btnLogout2);
        btnHome3 = findViewById(R.id.btnHome3);
        txtEvtTitle = findViewById(R.id.txtEventTitle);
        txtEvtDetail = findViewById(R.id.txtEvtDetail);
        txtStDate = findViewById(R.id.txtStDate);
        txtStTime = findViewById(R.id.txtStTime);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtEndTime = findViewById(R.id.txtEndTime);
        user2=(User)getIntent().getSerializableExtra("user");
        final EventCoordinator.Event event = (EventCoordinator.Event) getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event.eventTitle);
        txtEvtDetail.setText(event.eventDetail);
        txtStTime.setText(event.startTime);
        txtStDate.setText(event.startDate);
        txtEndDate.setText(event.endDate);
        txtEndTime.setText(event.endTime);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to database table with event id and participante id

                Toast.makeText(getBaseContext(), "you have successfully joined the event",
                        Toast.LENGTH_LONG).show();
                dbHelper.joinEvent("https://w0044421.gblearn.com/stu_share/EventReg.php",user2,event);

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
    }

    public void logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void OpenMenuActivity() {
        Intent intent = new Intent(this, EventMenu.class);
        intent.putExtra("user",user2);
        startActivity(intent);
    }
}



