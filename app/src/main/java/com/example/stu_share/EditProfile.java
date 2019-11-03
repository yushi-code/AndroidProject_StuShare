package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {
    Button btnSubmit, btnHome7, btnLogout8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

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
