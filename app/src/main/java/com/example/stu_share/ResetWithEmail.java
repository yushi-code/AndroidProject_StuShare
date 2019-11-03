package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetWithEmail extends AppCompatActivity {
    Button btnNext;
    EditText email;
    DBHelper dbHelper=null;
    User userTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_with_email);
        dbHelper=new DBHelper(this);
        email=findViewById(R.id.txtEm);
        btnNext=findViewById(R.id.btnNext);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        String userEmail=email.getText().toString();
        final User userTemp=dbHelper.getUserObj(db,userEmail);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),PasswordReset.class);
                intent.putExtra("args",userTemp);
                startActivity(intent);
            }
        });
    }
}
