package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

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

public class ResetConfirm extends AppCompatActivity {
    EditText txtPSWD,txtPSWD2;
    Button btnSubmit;
    private User user;
    private DBHelper dbHelper;
    private final String urlWebService="https://w0044421.gblearn.com/stu_share/user_reset_pswd.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_confirm);
        user=(User)getIntent().getSerializableExtra("args");
        dbHelper=new DBHelper(this);
        btnSubmit=findViewById(R.id.btnSubmitPswd);
        txtPSWD=findViewById(R.id.txtNewPswd);
        final String pswd=txtPSWD.getText().toString();
        txtPSWD2=findViewById(R.id.txtPswd2);
        final String pswd2=txtPSWD2.getText().toString();
        final User user=(User)getIntent().getSerializableExtra("args");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pswd.equals(pswd2)){


                    user.setPassword(txtPSWD.getText().toString());
                    dbHelper.updateUser(user,urlWebService);
                    Toast.makeText(getBaseContext(), "Password reset successfully!",
                            Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}
