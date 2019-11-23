package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MessageListActivity extends AppCompatActivity {
    Button msgHome, msgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        msgHome = findViewById(R.id.btnMsgHome);
        msgLogout = findViewById(R.id.btnMsgLogout);

        msgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Menu.class);
//              intent.putExtra("args", userReg);
                startActivity(intent);
            }
        });

        msgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//              intent.putExtra("args", userReg);
                startActivity(intent);

            }
        });
    }
}
