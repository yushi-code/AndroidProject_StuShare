package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Owned extends AppCompatActivity {
    private Button btnCancel, btnEdit, btnViewAttend, btnCheckIn, btnLogout, btnHome;
    ListView listView;
    DBHelper dbHelper=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owned);
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
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] args=(String[])getIntent().getSerializableExtra("args");
        dbHelper.updateEventList(db,dbHelper.getEventCursorOwn(db,args[0]));
        listView = (ListView) findViewById(R.id.listV1);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,EventCoordinator.EVENTS);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event tmp=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), OwnDetail.class);
                intent.putExtra("args",tmp);
                startActivity(intent);

            }
        });
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
