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

public class RegEventDetail extends AppCompatActivity {
    private Button btnLogout,  btnHome, btnDeReg;
    private TextView txtEvtTitle, txtEvtDetail, txtStDate, txtStTime, txtEndTime, txtEndDate;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_event_detail);



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
                OpenMenuActivity();
            }
        });
        txtEvtTitle = findViewById(R.id.txtEventTitle123);
        txtEvtDetail = findViewById(R.id.txtEvtDetail123);
        txtStDate = findViewById(R.id.txtStDate123);
        txtStTime = findViewById(R.id.txtStTime123);
        txtEndDate = findViewById(R.id.txtEndDate123);
        txtEndTime = findViewById(R.id.txtEndTime123);
        final User user = (User) getIntent().getSerializableExtra("user");
        final EventCoordinator.Event event = (EventCoordinator.Event) getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event.eventTitle);
        txtEvtDetail.setText(event.eventDetail);
        txtStTime.setText(event.startTime);
        txtStDate.setText(event.startDate);
        txtEndDate.setText(event.endDate);
        txtEndTime.setText(event.endTime);
        btnDeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deRegEvent(event.id,user.id);
                //delete from evenreg table

            }
});
}

    private void deRegEvent(String id, String id1) {
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void OpenMenuActivity() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
