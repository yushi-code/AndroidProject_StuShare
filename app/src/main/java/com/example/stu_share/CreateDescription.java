package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateDescription extends AppCompatActivity {

    private Button btnNextCreate, btnHome2, btnLogout;

    private EditText txtEvtTitle,txtEvtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_description);
        txtEvtDetail=findViewById(R.id.txtEvtDetail);
        txtEvtTitle=findViewById(R.id.txtEvtTitle);
        btnNextCreate = findViewById(R.id.btnNextCreate);
        btnNextCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventCoordinator.Event event=new EventCoordinator.Event();
                event.setEventTitle(txtEvtTitle.getText().toString());
                event.setEventDetail(txtEvtDetail.getText().toString());
                Intent intent =new Intent(getBaseContext(), Create.class);
                intent.putExtra("event",event);
                startActivity(intent);
            }
        });

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnHome2 = findViewById(R.id.btnHome2);
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuActivity();
            }
                });
    }
    public void openCreateActivity(){

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
