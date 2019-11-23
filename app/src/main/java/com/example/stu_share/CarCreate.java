package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CarCreate extends AppCompatActivity {
    private EditText textTitle,textDate,textBrand,textModel,textYear,textMile,textlocation,textDetail,textPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_create);

    }
}
