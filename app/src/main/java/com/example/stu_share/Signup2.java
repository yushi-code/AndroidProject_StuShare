package com.example.stu_share;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup2 extends AppCompatActivity {
    Button btnSign;
    EditText txtPC,txtRY,txtExp;
    private User userReg;
    DBHelper dbHelper=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        txtPC=findViewById(R.id.txtPC);
        txtRY=findViewById(R.id.txtRY);
        txtExp=findViewById(R.id.txtExp);
        btnSign = findViewById(R.id.btnSign);
        dbHelper=new DBHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPC.getText().toString().equals("") || txtRY.getText().toString().equals("") || txtExp.getText().toString().equals("")
                        || txtPC.getText().toString().equals(null) || txtRY.getText().toString().equals(null) || txtExp.getText().toString().equals(null)) {
                    Toast.makeText(getBaseContext(), "Can't leave fields empty! ",
                            Toast.LENGTH_LONG).show();
                } else {
                    userReg=(User)getIntent().getSerializableExtra("args");
                    userReg.setProgramCode(txtPC.getText().toString());
                    userReg.setRegisterYear(txtRY.getText().toString());
                    userReg.setExpireYear(txtExp.getText().toString());
                    dbHelper.insertUser(db,userReg);
                Toast.makeText(getBaseContext(), "You have been registered in our system",
                        Toast.LENGTH_LONG).show();
                logout();
            }
        }});
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
