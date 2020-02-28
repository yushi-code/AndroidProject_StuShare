package com.example.stu_share;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Signup2 extends AppCompatActivity {
    Button btnSign;
    EditText txtPC,txtRY,txtExp;
    private User userReg;
    DBHelper dbHelper=null;
    private static final String REGISTER_URL="https://w0044421.gblearn.com/stu_share/user_account_create.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);


        txtPC=findViewById(R.id.txtPC);
        txtRY=findViewById(R.id.txtRY);
        txtExp=findViewById(R.id.txtExp);
        btnSign = findViewById(R.id.btnSign);
        dbHelper=new DBHelper(this);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserAccount();
                Toast.makeText(getBaseContext(),"You have successfully registered your account, now proceed to login page!",Toast.LENGTH_LONG).show();
                logout();
            }
        });

        Button btnCancel=findViewById(R.id.btnSignup2Cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createUserAccount() {
        userReg=(User)getIntent().getSerializableExtra("args");
        userReg.setProgramCode(txtPC.getText().toString());
        userReg.setRegisterYear(txtRY.getText().toString());
        userReg.setExpireYear(txtExp.getText().toString());
        dbHelper.createAccount(REGISTER_URL,userReg.email, userReg.password, userReg.firstName,
                userReg.lastName,userReg.collegeCode ,userReg.programCode,
                userReg.registerYear, userReg.expireYear,"active", userReg.question,
                userReg.answer,"student");
    }
    public void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
