package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

import com.google.gson.Gson;



public class MainActivity extends AppCompatActivity {
    private Button btnCreateAcc, btnLogin, btnFgtPswd;
    private EditText txtEm, txtPswd;
    private TextView txtErr,txtShow;
    private User user=new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateAcc = findViewById(R.id.btnReg);
        btnFgtPswd = findViewById(R.id.btnResetPassword);
        txtEm = findViewById(R.id.txtRegEm);
        txtPswd = findViewById(R.id.txtPswd);
        txtShow=findViewById(R.id.txtShow);
        final String txtEmail = txtEm.getText().toString();
        final String txtPassword = txtPswd.getText().toString();
        final String txtE = txtEm.getText().toString();
        final String txtP = txtPswd.getText().toString();
        txtErr = findViewById(R.id.txtVErr);
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
                sendPost();
            }
        });
    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, SignUpEmailPass.class);

        startActivity(intent);
    }
    public void sendPost() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://f9team1.gblearn.com/stu_share/user_login.php");
                    //URL url = new URL("https://webhook.site/547e2577-2b3b-4183-9b81-a6b3ac5c985f");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    //jsonParam.put("timestamp", 1488873360);
                    jsonParam.put("email", txtEm.getText().toString());
                    jsonParam.put("name", "asdasdadsasdads");


                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
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

                    /*if(!total.equals(null)){
                        txtShow.setText(total.toString());
                    }*/
                    
                    Gson g = new Gson();
                     user = g.fromJson(total.toString(),User.class);
                              /*  JSONArray jsonArray = new JSONArray(total);

                                String[] stocks = new String[jsonArray.length()];
                                JSONObject obj=jsonArray.getJSONObject(0);
                                Log.d("JSON",obj.getString("email"));

                                    user.setId( obj.getString("_id"));
                                    user.setEmail(obj.getString("email"));
                                    user.setPassword(obj.getString("password"));

                                    user.setFirstName(obj.getString("first_name"));
                                    user.setLastName(obj.getString("last_name"));
                                    user.setCollegeCode(obj.getString("college_code"));

                                    user.setProgramCode(obj.getString("program_code"));
                                    user.setRegisterYear(obj.getString("registered_year"));
                                    user.setExpireYear(obj.getString("expire_year"));
                                    user.setStatus(obj.getString("status"));
                                    user.setQuestion(obj.getString("question"));
                                    user.setAnswer(obj.getString("answer"));
                                    user.setRole(obj.getString("role"));


*/
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        txtShow.setText(user.toString());
    }

    private void register(String username, String password) {

        if(txtEm.getText().toString().toLowerCase().equals("admin")){
            Intent intent =new Intent(this, AdminDashboardActivity.class);
             User  user =new User("1","david@georgebrown.ca","Password1","David","Shi","GBC","T127",
                    "2017","2020","what is my favourite car","Subaru","admin","active");
            intent.putExtra("user",user);
            //dbHelper.insertUser(db,user);
            startActivity(intent);
        }else if(txtEm.getText().toString().toLowerCase().equals("user")){
            Intent intent2 =new Intent(this, Menu.class);
            User user1 =new User("1","dharam@georgebrown.ca","Password2","Dharam","KC","GBC","T127",
                    "2017","2020","who is my favourite Teacher","Pawluk","user","active");
            intent2.putExtra("user",user1);
            //dbHelper.insertUser(db,user1);
            startActivity(intent2);
        }else{
            txtErr.setText("Something wrong with account, please try later");
        }

    }}



