package com.example.stu_share;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpEmailPass extends AppCompatActivity {
    Button btnNext;
    EditText txtEm,txtRegPswd,txtRegpswd2;
    public User user;
    DBHelper dbHelper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_email_pass);
        btnNext = findViewById(R.id.btnNext);
        txtEm=findViewById(R.id.txtRegEm);
        txtRegPswd=findViewById(R.id.txtRegPswd);
        txtRegpswd2=findViewById(R.id.txtRegPswdConf);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        user=dbHelper.getUserObj(db,txtEm.getText().toString());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(user.email.equals(null)|user.email.equals(""))){

                    Intent intent=new Intent(getBaseContext(),Signup.class);
                    intent.putExtra("args",user);
                    startActivity(intent);
                }

            }
        });
    }

    public void openSignupActivity(){
        Intent intent =new Intent(this, Signup.class);
        intent.putExtra("args",user);
        startActivity(intent);
    }
}
