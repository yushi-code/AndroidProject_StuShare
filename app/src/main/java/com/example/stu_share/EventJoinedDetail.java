package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EventJoinedDetail extends AppCompatActivity {
    private Button btnLogout,btnDeReg,btnHome;
    private TextView txtEvtTitle,txtEvtDetail,txtStDate,txtStTime,txtEndTime,txtEndDate;
    private DBHelper dbHelper ;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_joined_detail);
        dbHelper=new DBHelper(this);
        user=(User)getIntent().getSerializableExtra("user");
        btnDeReg=findViewById(R.id.btnDeRegister);
        btnHome=findViewById(R.id.btnHome666);
        btnLogout=findViewById(R.id.btnLogout111);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),EventMenu.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        txtEvtTitle=findViewById(R.id.txtEventTitle99);
        txtEvtDetail=findViewById(R.id.txtEvtDetail9);
        txtStDate=findViewById(R.id.txtStDate99);
        txtStTime=findViewById(R.id.txtStTime99);
        txtEndDate=findViewById(R.id.txtEndDate99);
        txtEndTime=findViewById(R.id.txtEndTime99);
        final EventCoordinator.Event event=(EventCoordinator.Event)getIntent().getSerializableExtra("args");
        txtEvtTitle.setText(event.eventTitle);
        txtEvtDetail.setText(event.eventDetail);
        txtStTime.setText(event.startTime);
        txtStDate.setText(event.startDate);
        txtEndDate.setText(event.endDate);
        txtEndTime.setText(event.endTime);
        btnDeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Deregister successfully!",
                        Toast.LENGTH_LONG).show();
                dbHelper.joinEvent(" https://w0044421.gblearn.com/stu_share/EventDeReg.php",user,event);
                Intent intent=new Intent(getBaseContext(),EventMenu.class);
                intent.putExtra("user",user);
                intent.putExtra("event",event);
                startActivity(intent);
            }
        });
    }
}
