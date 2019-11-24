package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.stu_share.CarCoordinator.CAR_LIST;
import static com.example.stu_share.CarCoordinator.CAR_PAST_LIST;

public class MainMenu extends AppCompatActivity {
    private Button buttonBooks,buttonRooms,buttonCars,buttonEvents,buttonMyProfile,buttonMessageCenter,buttonLogout,buttonContactUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        createCars();
        buttonBooks=findViewById(R.id.btnBooks);
        buttonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i= new Intent(getBaseContext(),BookMenu.class);
                //startActivity(i);
            }
        });
        buttonRooms=findViewById(R.id.btnRooms);
        buttonRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MessageListActivity.class);
                startActivity(i);
            }
        });
        buttonEvents=findViewById(R.id.btnEvents);
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),EventMenu.class);
                startActivity(i);
            }
        });
        buttonCars=findViewById(R.id.btnCars);
        buttonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),CarMenu.class);
                startActivity(i);
            }
        });
        buttonMyProfile=findViewById(R.id.btnMyProfile);
        buttonMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MyProfile.class);
                startActivity(i);
            }
        });
        buttonMessageCenter=findViewById(R.id.btnMessageCenter);
        buttonMessageCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MessageListActivity.class);
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
        buttonContactUs=findViewById((R.id.btnContactUs));
        buttonContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MessageActivity.class);
                i.putExtra("id","admin");
                startActivity(i);
            }
        });

    }

    private void createCars() {
         CarCoordinator.Car car1=new CarCoordinator.Car("1","Dharam KC","A brand new Jeep checrokee for rent!","2019-12-25",
                "Jeep","Cherokee","2019","0","Casa Loma Campus",
                "Nice to have ,greate deal for GBC studeents, 50% discount with valid student ID","$20,000","active","2019-11-23 18:04:00");
       CarCoordinator.Car car2=new CarCoordinator.Car("2","Harmanpreet Kaur","Looking for ride share from Vancouver to Toronto","2019-12-20",
                "Tesla","Model X","2020","10","Vancouver City Hall",
                "Electric SUV with blazing fast speed, environmental friendly","$20","active","2019-11-23 18:04:00");
         CarCoordinator.Car car3=new CarCoordinator.Car("3","Yu Shi","7 sets caravan for sale","2019-12-25",
                "Dodge","Caravan","2016","80,000","At your choice",
                "7 seats caravan good for car pool","$12,000","active","2019-11-23 18:04:00");
        CarCoordinator.Car car4=new CarCoordinator.Car("1","Ayusha","Looking for lunxury ride ,please contact","2019-12-23",
                "Any","Any","2019","0","St James Campus",
                "Looking for a ride to GTA,Please contact ayusha@georgebrown.ca","$10","active","2019-11-23 18:04:00");


        CarCoordinator.Car pastcar1=new CarCoordinator.Car("1","Dharam KC","A brand new Jeep checrokee for rent!","2018-12-25",
                "Jeep","Cherokee","2019","0","Casa Loma Campus",
                "Nice to have ,greate deal for GBC studeents, 50% discount with valid student ID","$20,000","active","2018-11-23 18:04:00");
         CarCoordinator.Car pastcar2=new CarCoordinator.Car("2","Harmanpreet Kaur","Looking for ride share from Vancouver to Toronto","2018-12-20",
                "Tesla","Model X","2020","10","Vancouver City Hall",
                "Electric SUV with blazing fast speed, environmental friendly","$20","active","2018-11-23 18:04:00");
         CarCoordinator.Car pastcar3=new CarCoordinator.Car("3","Yu Shi","7 sets caravan for sale","2018-12-25",
                "Dodge","Caravan","2016","80,000","At your choice",
                "7 seats caravan good for car pool","$12,000","active","2018-11-23 18:04:00");
        CarCoordinator.Car pastcar4=new CarCoordinator.Car("1","Ayusha","Looking for lunxury ride ,please contact","2018-12-23",
                "Any","Any","2019","0","St James Campus",
                "Looking for a ride to GTA,Please contact ayusha@georgebrown.ca","$10","active","2018-11-23 18:04:00");
        CAR_LIST.add(car1);
        CAR_LIST.add(car2);
        CAR_LIST.add(car3);
        CAR_LIST.add(car4);
        CAR_PAST_LIST.add(pastcar1);
        CAR_PAST_LIST.add(pastcar2);
        CAR_PAST_LIST.add(pastcar3);
        CAR_PAST_LIST.add(pastcar4);
    }
}
