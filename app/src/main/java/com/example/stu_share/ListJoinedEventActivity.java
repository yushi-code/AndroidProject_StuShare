package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListJoinedEventActivity extends AppCompatActivity {
    Button btnLogout, btnHome;
    ListView listView11;
    DBHelper dbHelper=null;
    TextView test;
    public static  List<EventCoordinator.Event> evt = new ArrayList<EventCoordinator.Event>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_joined_event);
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
        evt=dbHelper.getRegList(db,"2");
        listView11 = (ListView) findViewById(R.id.listView2323);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,evt);
        listView11.setAdapter(arrayAdapter);
        Cursor c=dbHelper.getRegListCur(db,"2");
        String k="";
        while(c.moveToNext()){
            k+=c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVTREG_COL_NAME_EVENTID))+"\n";
        }
        test=findViewById(R.id.txtTest);
        test.setText(k);
        listView11.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event tmp=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent1 =new Intent(getBaseContext(), JoinedDtl.class);
                Toast.makeText(getBaseContext(),"selected"+position+"wwwwww",Toast.LENGTH_LONG);
               intent1.putExtra("args",tmp);
                intent1.putExtra("position",String.valueOf(position));
                startActivity(intent1);
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
