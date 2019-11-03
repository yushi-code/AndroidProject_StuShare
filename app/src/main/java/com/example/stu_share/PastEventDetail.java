package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.stu_share.ListJoinedEventActivity.evt;

public class PastEventDetail extends AppCompatActivity {
    private Button btnLogout,btnHome, btnDeReg;
    private TextView txtEvtTitle, txtEvtDetail, txtStDate, txtStTime, txtEndTime, txtEndDate;
    DBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_event_detail);
        btnDeReg = findViewById(R.id.btnReg123);
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
        txtEvtTitle = findViewById(R.id.txtEventTitle);
        txtEvtDetail = findViewById(R.id.txtEvtDetail);
        txtStDate = findViewById(R.id.txtStDate);
        txtStTime = findViewById(R.id.txtStTime);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtEndTime = findViewById(R.id.txtEndTime);
        final String position = getIntent().getSerializableExtra("position").toString();
        final EventCoordinator.Event event1 = (EventCoordinator.Event) getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event1.eventTitle);
        txtEvtDetail.setText(event1.eventDetail);
        txtStTime.setText(event1.startTime);
        txtStDate.setText(event1.startDate);
        txtEndDate.setText(event1.endDate);
        txtEndTime.setText(event1.endTime);
        btnDeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete from evenreg table
                dbHelper = new DBHelper(getBaseContext());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(dbHelper.eventDeReg(db, event1.id, "2")){
                    evt.remove(Integer.valueOf(position));
                    Toast.makeText(getBaseContext(),"selected"+position,Toast.LENGTH_LONG);

                }
                else {
                    evt.remove(Integer.valueOf(position));
                    Toast.makeText(getBaseContext(),"Not"+position,Toast.LENGTH_LONG);

                }
            }
        });
    }

    public void OpenHome(){
        Intent intent =new Intent(this, Menu.class);
        startActivity(intent);
    }
    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
