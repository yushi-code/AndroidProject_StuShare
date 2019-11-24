package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.stu_share.CarCoordinator.CAR_LIST;
import static com.example.stu_share.CarCoordinator.CAR_PAST_LIST;


public class MainActivity extends AppCompatActivity {
    private Button btnCreateAcc, btnLogin, btnFgtPswd;
    private EditText txtEm, txtPswd;
    private TextView txtErr;
    private User user=new User();
    private String userString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateAcc = findViewById(R.id.btnReg);
        btnFgtPswd = findViewById(R.id.btnResetPassword);
        txtEm = findViewById(R.id.txtRegEm);
        txtPswd = findViewById(R.id.txtPswd);

        final String txtEmail = txtEm.getText().toString();
        final String txtPassword = txtPswd.getText().toString();
        final String txtE = txtEm.getText().toString();
        final String txtP = txtPswd.getText().toString();
        txtErr = findViewById(R.id.txtVErr);
        String msgError=(String)getIntent().getSerializableExtra("msgErr");
        txtErr.setText(msgError);
        user=(User)getIntent().getSerializableExtra("user");

        btnFgtPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ResetWithEmail.class);
                startActivity(intent);
            }
        });
        txtErr = findViewById(R.id.txtWrong);
        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=sendPost();
            }
        });
    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, SignUpEmailPass.class);
        startActivity(intent);
    }
    public User sendPost() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://f9team1.gblearn.com/stu_share/user_login.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("email", txtEm.getText().toString());

                    user=(User) getIntent().getSerializableExtra("user");

                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    os.writeBytes(jsonParam.toString());
                    os.flush();
                    os.close();
                    conn.connect();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    DataInputStream is=new DataInputStream(conn.getInputStream());

                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                    Log.d("TAG", "Server Response is: " + total.toString() + ": " );

                    User user1=jsonToUser(total.toString().trim(),user);

                    if(user1==null){
                        Intent i=new Intent(getBaseContext(), MainActivity.class);

                        i.putExtra("msgErr","Can't login,user name not found.");
                        startActivity(i);
                    }else if(txtPswd.getText().toString().equals(user1.password)){
                        Log.d("JSON",user1.toString()+"usertoString!");
                        if(user1.role.equals("admin")){
                        Intent i=new Intent(getBaseContext(), AdminDashboardActivity.class);
                        createCars();
                        i.putExtra("user",user1);
                        startActivity(i);
                    }else{
                        Intent i=new Intent(getBaseContext(), MainMenu.class);
                        createCars();
                        i.putExtra("user",user1);
                        startActivity(i);
                    }

                }else{
                    Intent i=new Intent(getBaseContext(), MainActivity.class);
                    i.putExtra("msgErr","\"Paassword wrong!\"");
                    startActivity(i);
                }
                              user=user1;
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();



        return user;
    }
    private void createCars() {
        CarCoordinator.Car car1=new CarCoordinator.Car("1","Dharam KC","A brand new Jeep checrokee for rent!","2019-12-25",
                "Jeep","Cherokee","2019","0","Casa Loma Campus",
                "Nice to have ,greate deal for GBC studeents, 50% discount with valid student ID","$40","active","2019-11-23 18:04:00");
        CarCoordinator.Car car2=new CarCoordinator.Car("2","Harmanpreet Kaur","Looking for ride share from Vancouver to Toronto","2019-12-20",
                "Tesla","Model X","2020","10","Vancouver City Hall",
                "Electric SUV with blazing fast speed, environmental friendly","$20","active","2019-11-23 18:04:00");
        CarCoordinator.Car car3=new CarCoordinator.Car("3","Yu Shi","7 sets caravan for rent","2019-12-25",
                "Dodge","Caravan","2016","80,000","At your choice",
                "7 seats caravan good for car pool","$120","active","2019-11-23 18:04:00");
        CarCoordinator.Car car4=new CarCoordinator.Car("1","Ayusha","Looking for lunxury ride ,please contact","2019-12-23",
                "Any","Any","2019","0","St James Campus",
                "Looking for a ride to GTA,Please contact ayusha@georgebrown.ca","$10","active","2019-11-23 18:04:00");


        CarCoordinator.Car pastcar1=new CarCoordinator.Car("1","Dharam KC","(Past)A brand new Jeep checrokee for rent!","2018-12-25",
                "Jeep","Cherokee","2019","0","Casa Loma Campus",
                "Nice to have ,greate deal for GBC studeents, 50% discount with valid student ID","$40","active","2018-11-23 18:04:00");
        CarCoordinator.Car pastcar2=new CarCoordinator.Car("2","Harmanpreet Kaur","(Past)Looking for ride share from Vancouver to Toronto","2018-12-20",
                "Tesla","Model X","2020","10","Vancouver City Hall",
                "Electric SUV with blazing fast speed, environmental friendly","$20","active","2018-11-23 18:04:00");
        CarCoordinator.Car pastcar3=new CarCoordinator.Car("3","Yu Shi","(Past)7 sets caravan for rente","2018-12-25",
                "Dodge","Caravan","2016","80,000","At your choice",
                "7 seats caravan good for car pool","$120","active","2018-11-23 18:04:00");
        CarCoordinator.Car pastcar4=new CarCoordinator.Car("1","Ayusha","(Past)Looking for lunxury ride ,please contact","2018-12-23",
                "Any","Any","2019","0","St James Campus",
                "Looking for a ride to GTA,Please contact ayusha@georgebrown.ca","$10","active","2018-11-23 18:04:00");
        CAR_LIST.add(car1);
        CAR_LIST.add(car2);
        CAR_LIST.add(car3);
        CAR_LIST.add(car4);
        CAR_PAST_LIST.add(pastcar1);
        CAR_PAST_LIST.add(pastcar2);
        CAR_PAST_LIST.add(pastcar3);
        CAR_PAST_LIST.add(pastcar4);
    }
    private User jsonToUser(String json, User user) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
             user = new User();

            user.setId( obj.getString("id"));
            user.setEmail(obj.getString("email"));
            user.setPassword(obj.getString("password"));
            user.setFirstName(obj.getString("firstName"));
            user.setLastName(obj.getString("lastName"));
            user.setCollegeCode(obj.getString("collegeCode"));
            user.setProgramCode(obj.getString("programCode"));
            user.setRegisterYear(obj.getString("registeredYear"));
            user.setExpireYear(obj.getString("expireYear"));
            user.setStatus(obj.getString("status"));
            user.setQuestion(obj.getString("question"));
            user.setAnswer(obj.getString("answer"));
            user.setRole(obj.getString("role"));

        }
        return user;
    }
   }



