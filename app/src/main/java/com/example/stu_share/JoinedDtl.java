package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JoinedDtl extends AppCompatActivity {
    private Button btnLogout,btnJoin;
    private TextView txtEvtTitle,txtEvtDetail,txtStDate,txtStTime,txtEndTime,txtEndDate;
    DBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_dtl);
        btnJoin=findViewById(R.id.btnDereg);
        btnLogout=findViewById(R.id.btnLogout111);
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
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete record
                dbHelper = new DBHelper(getBaseContext());
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.eventDeReg(db,event.id,"2");
                Toast.makeText(getBaseContext(),"selected"+event.id+"wwwwww",Toast.LENGTH_LONG);
            }
        });
    }
}
