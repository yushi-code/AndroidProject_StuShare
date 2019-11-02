package com.example.stu_share;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.stu_share.DBConnect.DBEntity.EVTREG_COL_NAME_EVENTID;
import static com.example.stu_share.DBConnect.DBEntity.EVTREG_COL_NAME_USERID;
import static com.example.stu_share.DBConnect.DBEntity.TABLE_NAME_EVENT;
import static com.example.stu_share.DBConnect.DBEntity.TABLE_NAME_EVENTREG;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "stushare.db";
    public static final Date today = new Date();
    public static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
    public static final String dateToday = format.format(today);
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBConnect.DBEntity.SQL_CREATE_TABLE_USER);
        db.execSQL(DBConnect.DBEntity.SQL_CREATE_TABLE_EVENT);
        db.execSQL(DBConnect.DBEntity.SQL_CREATE_TABLE_EVTREG);
        Log.d("DATABASE", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBConnect.DBEntity.SQL_DROP);
        Log.d("DATABASE", "Database dropped");
        onCreate(db);
    }


    //add to database table with event id and participante id
    public long eventReg(SQLiteDatabase db, String eventID,String userID){

        ContentValues values = new ContentValues();
        values.put(DBConnect.DBEntity.EVTREG_COL_NAME_EVENTID, eventID);
        values.put(DBConnect.DBEntity. EVTREG_COL_NAME_USERID ,userID);
        values.put(DBConnect.DBEntity.EVTREG_COL_NAME_STATUS ,"registered");


        return db.insert(TABLE_NAME_EVENTREG, null, values);
    }

    public long insertUser(SQLiteDatabase db, User user){

        ContentValues values = new ContentValues();
        values.put(DBConnect.DBEntity.COLUMN_NAME_EMAIL, user.email);
        values.put(DBConnect.DBEntity. COLUMN_NAME_PSWD ,user.password);
        values.put(DBConnect.DBEntity.COLUMN_NAME_FN ,user.firstName);
        values.put(DBConnect.DBEntity.COLUMN_NAME_LN,user.lastName);
        values.put(DBConnect.DBEntity.COLUMN_NAME_CC ,user.collegeCode);
        values.put(DBConnect.DBEntity.COLUMN_NAME_PC ,user.programCode);
        values.put(DBConnect.DBEntity.COLUMN_NAME_RY ,user.registerYear);
        values.put(DBConnect.DBEntity.COLUMN_NAME_EXP ,user.expireYear);
        values.put(DBConnect.DBEntity.COLUMN_NAME_STATUS,user.status);
        values.put(DBConnect.DBEntity.COLUMN_NAME_Q ,user.question);
        values.put(DBConnect.DBEntity.COLUMN_NAME_A ,user.answer);
        values.put(DBConnect.DBEntity. COLUMN_NAME_ROLE ,"student");

        return db.insert(DBConnect.DBEntity.TABLE_NAME_USER, null, values);
    }

    public Cursor getAllUsers(SQLiteDatabase db){
        String[] projection = {
                DBConnect.DBEntity._ID,
                DBConnect.DBEntity.COLUMN_NAME_EMAIL,
                DBConnect.DBEntity.COLUMN_NAME_PSWD,
                DBConnect.DBEntity.COLUMN_NAME_FN,
                DBConnect.DBEntity.COLUMN_NAME_LN,
                DBConnect.DBEntity.COLUMN_NAME_CC,
                DBConnect.DBEntity.COLUMN_NAME_PC,
                DBConnect.DBEntity.COLUMN_NAME_RY,
                DBConnect.DBEntity.COLUMN_NAME_EXP,
                DBConnect.DBEntity.COLUMN_NAME_STATUS,
                DBConnect.DBEntity.COLUMN_NAME_Q,
                DBConnect.DBEntity.COLUMN_NAME_A,
                DBConnect.DBEntity.COLUMN_NAME_ROLE

        };


        return db.query(DBConnect.DBEntity.TABLE_NAME_USER,
                projection,
                null,
                null,
                null,
                null,
                null);
    }
    public Cursor getEventCursorAct(SQLiteDatabase db){
        String[] projection = {
                DBConnect.DBEntity._ID,
                DBConnect.DBEntity.EVENT_COL_NAME_ORGID,
                DBConnect.DBEntity.EVENT_COL_NAME_STATUS,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_END_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_END_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_TITLE,
                DBConnect.DBEntity.EVENT_COL_NAME_DETAIL
        };

        return db.query(DBConnect.DBEntity.TABLE_NAME_EVENT,
                projection,
                "status=? and end_date>? ",
                new String[] { "active",dateToday },
                null,
                null,
                null);
    }
    public Cursor getRegListCur(SQLiteDatabase db,String id){
         final String MY_QUERY = "SELECT * FROM "+TABLE_NAME_EVENT+" e INNER JOIN "+TABLE_NAME_EVENTREG+" erg ON e._id=erg.event_id WHERE erg.user_id=?";

        return db.rawQuery(MY_QUERY, new String[]{String.valueOf(id)});
    }
    public List<EventCoordinator.Event> getRegList(SQLiteDatabase db, String id){
        List<EventCoordinator.Event> evt = new ArrayList<EventCoordinator.Event>();
        Cursor c=getRegListCur(db,id);
        while (c.moveToNext()){
            EventCoordinator.Event event=new EventCoordinator.Event(
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity._ID)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ORGID)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_STATUS)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_END_DATE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_END_TIME)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_TITLE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_DETAIL)));
           evt.add(event);

        }
        c.close();
        return evt;
    }


    public Cursor getEventCursorPst(SQLiteDatabase db,String id){
        String[] projection = {
                DBConnect.DBEntity._ID,
                DBConnect.DBEntity.EVENT_COL_NAME_ORGID,
                DBConnect.DBEntity.EVENT_COL_NAME_STATUS,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_END_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_END_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_TITLE,
                DBConnect.DBEntity.EVENT_COL_NAME_DETAIL
        };
        Date date=new Date();
        return db.query(DBConnect.DBEntity.TABLE_NAME_EVENT,
                projection,
                "end_date<? and organizer_id=? ",
                new String[] { dateToday ,id},
                null,
                null,
                null);
    }

    public Cursor getEventCursorOwn(SQLiteDatabase db,String id){
        String[] projection = {
                DBConnect.DBEntity._ID,
                DBConnect.DBEntity.EVENT_COL_NAME_ORGID,
                DBConnect.DBEntity.EVENT_COL_NAME_STATUS,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_END_DATE,
                DBConnect.DBEntity.EVENT_COL_NAME_END_TIME,
                DBConnect.DBEntity.EVENT_COL_NAME_TITLE,
                DBConnect.DBEntity.EVENT_COL_NAME_DETAIL
        };
        Date date=new Date();
        return db.query(DBConnect.DBEntity.TABLE_NAME_EVENT,
                projection,
                "organizer_id=? and end_date>? ",
                new String[] { id,dateToday},
                null,
                null,
                null);
    }
    public void updateEventList(SQLiteDatabase db,Cursor c){
        EventCoordinator.EVENTS.clear();
        EventCoordinator.EVENT_MAP.clear();

        while (c.moveToNext()){
            EventCoordinator.Event event=new EventCoordinator.Event(
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity._ID)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ORGID)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_STATUS)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_END_DATE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_END_TIME)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_TITLE)),
                    c.getString(c.getColumnIndexOrThrow(DBConnect.DBEntity.EVENT_COL_NAME_DETAIL)));
            EventCoordinator.addEventList(event);

        }
        c.close();

    }

    public long insertEvent(SQLiteDatabase db, EventCoordinator.Event event){

        ContentValues values = new ContentValues();
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_ORGID, event.orgID);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_STATUS ,event.status);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_ST_DATE ,event.startDate);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_ST_TIME,event.startTime);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_END_DATE ,event.endDate);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_END_TIME ,event.endTime);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_TITLE ,event.eventTitle);
        values.put(DBConnect.DBEntity.EVENT_COL_NAME_DETAIL ,event.eventDetail);
        return db.insert(DBConnect.DBEntity.TABLE_NAME_EVENT, null, values);

    }

    public boolean eventDeReg(SQLiteDatabase db, String id, String userId) {

        return db.delete(TABLE_NAME_EVENTREG, "event_id= ? and user_id = ? ;"  , new String[]{id,userId}) > 0;
    }
}


