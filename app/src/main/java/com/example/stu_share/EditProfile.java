package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.stu_share.AdminDashboardActivity.user;

public class EditProfile extends AppCompatActivity {
    Button btnSubmit, btnHome7, btnLogout8;
    TextView editFn,editLn,editQ,editA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user=(User)getIntent().getSerializableExtra("user");
        setContentView(R.layout.activity_edit_profile);
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
                user.setFirstName(editFn.getText().toString());
                user.setLastName(editLn.getText().toString());
                user.setQuestion(editQ.getText().toString());
                user.setAnswer(editA.getText().toString());
                Toast.makeText(getBaseContext(), "Profile has been updated",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public void OpenMenuActivity() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void logout(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
