package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private Button btnCreateAcc, btnLogin,btnFgtPswd;
    private Button btnLogin1;
    private EditText txtEm,txtPswd;
    private TextView txtErr;
    DBHelper dbHelper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreateAcc = findViewById(R.id.btnReg);
        btnFgtPswd=findViewById(R.id.btnResetPassword);
        txtEm=findViewById(R.id.txtRegEm);
        txtPswd=findViewById(R.id.txtPswd);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final String  txtE = txtEm.getText().toString();
        final String txtP = txtPswd.getText().toString();
        txtErr=findViewById(R.id.txtVErr);
        btnFgtPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent =new Intent(getBaseContext(), ResetWithEmail.class);
                    startActivity(intent);
            }
        });
        txtErr=findViewById(R.id.txtWrong);
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
                openMainMenu(db);
            }
        });
    }
    public void openSignupActivity(){
        Intent intent =new Intent(this, SignUpEmailPass.class);

        startActivity(intent);
    }
    public void openMainMenu(SQLiteDatabase db){
        if(txtEm.getText().toString().toLowerCase().equals("admin")){
            Intent intent =new Intent(this, AdminDashboardActivity.class);
             User  user =new User("1","david@georgebrown.ca","Password1","David","Shi","GBC","T127",
                    "2017","2020","what is my favourite car","Subaru","admin","active");
            intent.putExtra("user",user);
            dbHelper.insertUser(db,user);
            startActivity(intent);
        }else if(txtEm.getText().toString().toLowerCase().equals("user")){
            Intent intent2 =new Intent(this, Menu.class);
            User user1 =new User("1","dharam@georgebrown.ca","Password2","Dharam","KC","GBC","T127",
                    "2017","2020","who is my favourite Teacher","Pawluk","user","active");
            intent2.putExtra("user",user1);
            dbHelper.insertUser(db,user1);
            startActivity(intent2);
        }else{
            txtErr.setText("Something wrong with account, please try later");
        }

    }

}

