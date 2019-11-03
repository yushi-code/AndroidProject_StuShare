package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final String userEmail=email.getText().toString();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User userTemp=dbHelper.getUserObj(db,email.getText().toString().toLowerCase());
                if(userTemp!=null){
                    Intent intent=new Intent(getBaseContext(),PasswordReset.class);
                    intent.putExtra("args",userTemp);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(), "Your email can't be found!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
