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
                        i.putExtra("user",user1);
                        startActivity(i);
                    }else{
                        Intent i=new Intent(getBaseContext(), Menu.class);
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



