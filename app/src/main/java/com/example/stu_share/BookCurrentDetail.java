package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookCurrentDetail extends AppCompatActivity {
    private EditText title, author, edition, isbn, price, description;
    private Button home,logout,terminate,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_current_detail);

        title=findViewById(R.id.txtCarTitle);
        author=findViewById(R.id.txtCarDate);
        edition=findViewById(R.id.txtCarBrand);
        isbn=findViewById(R.id.txtCarModel);
        price=findViewById(R.id.txtCarYear2);
        description=findViewById(R.id.txtCarMileage);


        final BookCoordinator.Book book=(BookCoordinator.Book)getIntent().getSerializableExtra("book");
        final int position=(int)getIntent().getSerializableExtra("position");
        terminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookCoordinator.BOOK_LIST.remove(book);
                BookCoordinator.BOOK_PAST_LIST.add(book);
                Toast.makeText(BookCurrentDetail.this,"Your car share has been terminated.",Toast.LENGTH_LONG).show();
            }
        });
        home=findViewById(R.id.btnHome);
        logout=findViewById(R.id.btnLogout);

        update=findViewById(R.id.btnUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Your information has been updated!",Toast.LENGTH_LONG);
                Intent i=new Intent(getBaseContext(),CarMenu.class);
                startActivity(i);
            }
        });

        title.setText(book.title);
        author.setText(book.author);
        edition.setText(book.edition);
        isbn.setText(book.isbn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainMenu.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
