package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OwnDetail extends AppCompatActivity {
    private Button btnLogout, btnHome, btnUpdate,btnTerminate;
    private EditText txtEvtTitle, txtEvtDetail, txtStDate, txtStTime, txtEndTime, txtEndDate;
    DBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_detail);
        btnUpdate=findViewById(R.id.btnUpdateOwn);
        btnTerminate=findViewById(R.id.btnTereminate);
        txtEvtTitle=findViewById(R.id.txtEventTitle);
        txtEvtDetail=findViewById(R.id.txtEvtDetail6);
        txtStDate=findViewById(R.id.txtStDate6);
        txtStTime=findViewById(R.id.txtStTime6);
        txtEndDate=findViewById(R.id.txtEndDate6);
        txtEndTime=findViewById(R.id.txtEndTime6);

        final EventCoordinator.Event event=(EventCoordinator.Event)getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event.eventTitle);
        txtEvtDetail.setText(event.eventDetail);
        txtStTime.setText(event.startTime);
        txtStDate.setText(event.startDate);
        txtEndDate.setText(event.endDate);
        txtEndTime.setText(event.endTime);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to database table with event id and participante id
                dbHelper = new DBHelper(getBaseContext());
                event.setEventTitle(txtEvtTitle.getText().toString());
                event.setEventDetail(txtEvtDetail.getText().toString());
                event.setStartDate(txtStDate.getText().toString());
                event.setStartTime(txtStTime.getText().toString());
                event.setEndDate(txtEndDate.getText().toString());
                event.setEndTime(txtEndTime.getText().toString());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.updateEvent(db,event);
                dbHelper.close();

                Toast.makeText(getBaseContext(), "Event has been updated in your account",
                        Toast.LENGTH_LONG).show();
                OpenMenuActivity();
            }
        });
        btnTerminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(getBaseContext());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                event.setStatus("not active");
                dbHelper.eventStatusChange(db,event);
                Toast.makeText(getBaseContext(), "Event has been terminated from your account",
                        Toast.LENGTH_LONG).show();
                OpenMenuActivity();
            }
        });

        btnHome = findViewById(R.id.btnHome);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

}
