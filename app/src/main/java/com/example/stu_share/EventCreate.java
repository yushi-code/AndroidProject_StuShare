package com.example.stu_share;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EventCreate extends AppCompatActivity {
    TimePickerDialog timePickerSt,timePickerEnd;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;
    private static final String TAG = "Create";
    EventCreateDescription createDescription;
    private TextView txtStDate;
    private TextView txtEndDate;

    private TextView startDisplayDate;
    private DatePickerDialog.OnDateSetListener startDateSetListener;
    private TextView endDisplayDate;
    private DatePickerDialog.OnDateSetListener endDateSetListener;

    EditText txtStTime,txtEndTime;
    private User user;
    Button btnCreate, btnHome, btnLogout;
    //    DBHelper dbHelper = null;
    private static final String REGISTER_URL="https://f9team1.gblearn.com/stu_share/create_event.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        startDisplayDate = findViewById(R.id.txtStDate);
        endDisplayDate = findViewById(R.id.txtEndDate);

        txtStDate=findViewById(R.id.txtStDate);
        txtStTime=findViewById(R.id.txtStTime);
        txtStTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerSt = new TimePickerDialog(EventCreate.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtStTime.setText(String.format("%02d:%02d", hourOfDay, minutes) );
                    }
                }, currentHour, currentMinute, false);

                timePickerSt.show();
            }
        });
        txtEndTime=findViewById(R.id.txtEndTime);
        txtEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerEnd = new TimePickerDialog(EventCreate.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        txtEndTime.setText(String.format("%02d:%02d", hourOfDay, minutes) );
                    }
                }, currentHour, currentMinute, false);

                timePickerEnd.show();
            }
        });
        txtEndDate= findViewById(R.id.txtEndDate);

        startDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EventCreate.this,
                        android.R.style.Theme_DeviceDefault_Light_Dialog,
                        startDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        startDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = ""+year +month +dayOfMonth;
                startDisplayDate.setText(date);
            }
        };

        endDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EventCreate.this,
                        android.R.style.Theme_DeviceDefault_Light_Dialog,
                        endDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        endDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date =""+year +month +dayOfMonth;
                endDisplayDate.setText(date);
            }
        };

//        dbHelper = new DBHelper(this);
//        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        btnLogout = findViewById(R.id.btnAlLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
//        txtStDate=findViewById(R.id.txtStDate);
//        txtStTime=findViewById(R.id.txtStTime);
//        txtEndTime=findViewById(R.id.txtEndTime);
        user=(User)getIntent().getSerializableExtra("user");
//        final EventCoordinator.Event event1=(EventCoordinator.Event)getIntent().getSerializableExtra("event");
        final Calendar myCalendar = Calendar.getInstance();
        final Calendar myCalendar1 = Calendar.getInstance();
//        txtEndDate= findViewById(R.id.txtEndDate);
//        event1.setStartDate(txtStDate.getText().toString());
//        event1.setEndDate(txtEndDate.getText().toString());
//        event1.setStartTime(txtStTime.getText().toString());
//        event1.setEndTime(txtEndTime.getText().toString());
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String myFormat = "yyMMdd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
                txtEndDate.setText(sdf.format(myCalendar.getTime()));
            }

        };

        txtEndDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog( EventCreate.this,date, myCalendar1
                        .get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
                        myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar1.set(Calendar.YEAR, year);
                myCalendar1.set(Calendar.MONTH, monthOfYear);
                myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String myFormat = "yyMMdd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
                txtStDate.setText(sdf.format(myCalendar1.getTime()));
                txtEndDate.setText(sdf.format(myCalendar.getTime()));
            };

        };
        txtStDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog( EventCreate.this,date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
        btnCreate=findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEvent();
//                final EventCoordinator.Event event2=
//                        new EventCoordinator.Event("1","2","active",txtStDate.getText().toString(),txtStTime.getText().toString(),txtEndDate.getText().toString(),txtEndTime.getText().toString(),event1.eventTitle,event1.eventDetail);

//                long id = dbHelper.insertEvent(db, event2);
//                dbHelper.updateEventList(db,dbHelper.getEventCursorAct(db));
//                Toast.makeText(getBaseContext(), "Event added with\n "+event2.toString(),
//                        Toast.LENGTH_LONG).show();
                OpenMenuActivity();
            }
        });

    }
    private void createEvent() {
        final EventCoordinator.Event event1=(EventCoordinator.Event)getIntent().getSerializableExtra("event");
        event1.setStartDate(txtStDate.getText().toString());
        event1.setEndDate(txtEndDate.getText().toString());
        event1.setStartTime(txtStTime.getText().toString());
        event1.setEndTime(txtEndTime.getText().toString());

        String startDate = event1.startDate;
        String startTime = event1.startTime;
        String endDate = event1.endDate;
        String endTime = event1.endTime;
        String eventTitle = event1.eventTitle;
        String eventDetail = event1.eventDetail;

        create("active",startDate, startTime, endDate, endTime, eventTitle, eventDetail);
    }

    private void create(String status, String startDate, String startTime, String endDate, String endTime, String eventTitle, String eventDetail) {
        String urlSuffix = "?status=" + status +"&startDate=" + startDate + "&startTime=" + startTime + "&endDate=" + endDate + "&endTime=" + endTime
                + "&title=" + eventTitle + "&detail=" + eventDetail;

        class CreateEvent extends AsyncTask<String, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EventCreate.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader = null;
                try {
                    URL url = new URL(REGISTER_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    bufferReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferReader.readLine();
                    return result;

                } catch (Exception e) {
                    return null;
                }
            }

        }
        CreateEvent event = new CreateEvent();
        event.execute(urlSuffix);
    }

    public void OpenMenuActivity(){
        Intent intent = new Intent(this, EventMenu.class);
      intent.putExtra("user",user);
        startActivity(intent);
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
