package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EventJoinedDetail extends AppCompatActivity {
    private Button btnLogout,btnDeReg;
    private TextView txtEvtTitle,txtEvtDetail,txtStDate,txtStTime,txtEndTime,txtEndDate;
    //DBHelper dbHelper = null;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_joined_detail);
        btnDeReg=findViewById(R.id.btnDereg);
        btnLogout=findViewById(R.id.btnLogout111);
        txtEvtTitle=findViewById(R.id.txtEventTitle99);
        txtEvtDetail=findViewById(R.id.txtEvtDetail9);
        txtStDate=findViewById(R.id.txtStDate99);
        txtStTime=findViewById(R.id.txtStTime99);
        txtEndDate=findViewById(R.id.txtEndDate99);
        txtEndTime=findViewById(R.id.txtEndTime99);
        user=(User)getIntent().getSerializableExtra("user");
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
                //delete record

                Toast.makeText(getBaseContext(), "Deregister successfully!",
                        Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getBaseContext(),EventMenu.class);
                intent.putExtra("user",user);
                intent.putExtra("event",event);
                startActivity(intent);
            }
        });
    }
}
