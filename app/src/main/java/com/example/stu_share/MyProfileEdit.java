package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;




public class MyProfileEdit extends AppCompatActivity {
    Button btnSubmit, btnHome7, btnLogout8;
    TextView editFn,editLn,editQ,editA;
    private User user;
    private final String urlWebService="https://w0044421.gblearn.com/stu_share/user_update.php";
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper=new DBHelper(this);
        super.onCreate(savedInstanceState);
        user=(User)getIntent().getSerializableExtra("user");
        setContentView(R.layout.activity_profile_edit);
        editFn=findViewById(R.id.editFirstName);
        editFn.setText(user.firstName);
        editLn=findViewById(R.id.editLastName);
        editLn.setText(user.lastName);
        editQ=findViewById(R.id.editQuestion);
        editQ.setText(user.question);
        editA=findViewById(R.id.editAnswer);
        editA.setText(user.answer);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnHome7 = findViewById(R.id.btnHome7);
        btnLogout8 = findViewById(R.id.btnLogout8);

        btnLogout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnHome7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.role.equals("admin")){
                    user.setFirstName(editFn.getText().toString());
                    user.setLastName(editLn.getText().toString());
                    user.setQuestion(editQ.getText().toString());
                    user.setAnswer(editA.getText().toString());
                    Toast.makeText(getBaseContext(), "Profile has been updated",
                            Toast.LENGTH_LONG).show();
                    dbHelper.updateUser(user,urlWebService);
                    Intent intent = new Intent(getBaseContext(), AdminDashboard.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }else{

                    user.setFirstName(editFn.getText().toString());
                    user.setLastName(editLn.getText().toString());
                    user.setQuestion(editQ.getText().toString());
                    user.setAnswer(editA.getText().toString());
                    Toast.makeText(getBaseContext(), "Profile has been updated",
                            Toast.LENGTH_LONG).show();
                    dbHelper.updateUser(user,urlWebService);
                    Intent intent = new Intent(getBaseContext(), EventMenu.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }

            }
        });

    }
    public void OpenMenuActivity() {
        if(user.role.equals("admin")){
            Intent intent = new Intent(this, AdminDashboard.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }else{Intent intent = new Intent(this, MainMenu.class);
            intent.putExtra("user",user);
            startActivity(intent);}
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
