package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PastEvent extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_event);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] args=(String[])getIntent().getSerializableExtra("args");
        dbHelper.updateEventList(db,dbHelper.getEventCursorPst(db,args[0]),args[0]);
        listView = (ListView) findViewById(R.id.listV);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,EventCoordinator.EVENTS);
        listView.setAdapter(arrayAdapter);
    }
}
