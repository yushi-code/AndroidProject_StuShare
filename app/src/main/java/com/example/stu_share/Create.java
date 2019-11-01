package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {
    EditText txtStDate,txtStTime,txtEndTime,txtEndDate;
    Button btnCreate;
    DBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbHelper = new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        txtStDate=findViewById(R.id.txtStDate);
        txtStTime=findViewById(R.id.txtStTime);
        txtEndDate=findViewById(R.id.txtEndDate);
        txtEndTime=findViewById(R.id.txtEndTime);
         EventCoordinator.Event event1=(EventCoordinator.Event)getIntent().getSerializableExtra("event");
        final EventCoordinator.Event event2=new EventCoordinator.Event("1","2","active",""+txtStDate.getText().toString(),txtStTime.getText().toString(),txtEndDate.getText().toString(),txtEndTime.getText().toString(),event1.eventTitle,event1.eventDetail);

        btnCreate=findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = dbHelper.insertEvent(db,event2);
                dbHelper.updateEventList(db);
                Toast.makeText(getBaseContext(), "Word added with id = "+event2.toString()+"!"+txtStDate.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
