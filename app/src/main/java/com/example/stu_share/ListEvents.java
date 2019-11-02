package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListEvents extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_events);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        dbHelper.updateEventList(db,dbHelper.getEventCursorAct(db),"1");
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,EventCoordinator.EVENTS);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                EventCoordinator.Event tmp=(EventCoordinator.Event) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), EventDetail.class);
                Toast.makeText(getBaseContext(),"selected"+position,Toast.LENGTH_LONG);
                intent.putExtra("args",tmp);
                startActivity(intent);
                Toast.makeText(getBaseContext(),"selected"+position,Toast.LENGTH_LONG);
            }
        });


        /*listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                EventCoordinator.Event tmp=(EventCoordinator.Event) parent.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), EventDetail.class);
                Toast.makeText(getBaseContext(),"selected"+position,Toast.LENGTH_LONG);
                intent.putExtra("args",tmp);
                //startActivity(intent);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(),"Nothing selected",Toast.LENGTH_LONG);
            }
        });*/
    }
}
