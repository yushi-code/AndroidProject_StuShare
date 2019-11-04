package com.example.stu_share;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpEmailPass extends AppCompatActivity {
    Button btnNext;
    EditText txtEm,txtRegPswd,txtRegpswd2;
    TextView test;
    public User userReg=null;
    DBHelper dbHelper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_email_pass);
        btnNext = findViewById(R.id.btnNext);
        txtEm=findViewById(R.id.txtRegEm2);
        txtRegPswd=findViewById(R.id.txtRegPswd);
        txtRegpswd2=findViewById(R.id.txtRegPswdConf);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userReg=dbHelper.getUserObj(db,txtEm.getText().toString());
                if(userReg!=null){
                    Toast.makeText(getBaseContext(), "Account already exists! ",
                            Toast.LENGTH_LONG).show();
                }
                else if(!checkEmailDomain(txtEm.getText().toString())){
                    Toast.makeText(getBaseContext(), "It's not George Brown email! ",
                            Toast.LENGTH_LONG).show();
                }
                else if(!txtRegPswd.getText().toString().equals(txtRegpswd2.getText().toString())){
                    Toast.makeText(getBaseContext(), "Password doesn't match! ",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent=new Intent(getBaseContext(),Signup.class);
                    userReg=new User();
                    userReg.setEmail(txtEm.getText().toString());
                    userReg.setPassword(txtRegPswd.getText().toString());
                    intent.putExtra("args",userReg);
                    startActivity(intent);
                }

            }
        });
    }
    public boolean checkEmailDomain(String em){
        String[] result=null;
        result=em.split("@");
        if(result.length==2 && result[1].toLowerCase().equals("georgebrown.ca")){
            return true;
        }return false;
    }

}
