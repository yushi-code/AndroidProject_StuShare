package com.example.stu_share;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import static com.example.stu_share.CarCoordinator.CAR_LIST;
//import static com.example.stu_share.CarCoordinator.CAR_PAST_LIST;

import androidx.appcompat.app.AppCompatActivity;


public class MainMenu extends AppCompatActivity {
    private Button buttonBooks,buttonRooms,buttonCars,buttonEvents,buttonMyProfile,buttonMessageCenter,buttonLogout,buttonContactUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final User user=(User)getIntent().getSerializableExtra("user");

        buttonEvents=findViewById(R.id.btnEvents);
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),EventMenu.class);
                i.putExtra("user",user);
                startActivity(i);
            }
        });

        buttonMyProfile=findViewById(R.id.btnMyProfile);
        buttonMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MyProfile.class);
                i.putExtra("user",user);
                startActivity(i);
            }
        });

        buttonLogout=findViewById(R.id.btnLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }


}
