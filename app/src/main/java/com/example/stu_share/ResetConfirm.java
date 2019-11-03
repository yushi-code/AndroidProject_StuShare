package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResetConfirm extends AppCompatActivity {
    EditText txtPSWD,txtPSWD2;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_confirm);
        btnSubmit=findViewById(R.id.btnSubmitPswd);
        txtPSWD=findViewById(R.id.txtNewPswd);
        txtPSWD2=findViewById(R.id.txtPswd2);
        final User user=(User)getIntent().getSerializableExtra("args");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPSWD.getText().toString().equals(txtPSWD2.getText().toString())){
                    DBHelper dbHelper=null;
                    dbHelper=new DBHelper(getBaseContext());
                    final SQLiteDatabase db = dbHelper.getWritableDatabase();
                    user.setPassword(txtPSWD.getText().toString());
                    dbHelper.updateUser(db,user);
                    Toast.makeText(getBaseContext(), "Password reset successfully!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
