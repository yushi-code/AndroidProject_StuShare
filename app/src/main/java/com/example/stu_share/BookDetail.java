package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {

    private TextView txtTitle,txtAuthor,txtEdition,txtISBN,txtDetails;
    private Button btnHome,btnLogout,btnEmail,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainMenu.class);
                startActivity(intent);
            }
        });

        Button btnEmail = findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),EmailActivity.class);
                startActivity(intent);
            }
        });

        message=findViewById(R.id.btnMessage);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(), MessageCreate.class);
                startActivity(i);
            }
        });

        txtTitle=findViewById(R.id.txtTitle);
        txtAuthor=findViewById(R.id.txtAuthor);
        txtEdition=findViewById(R.id.txtEdition);
        txtISBN=findViewById(R.id.txtISBN);
        txtDetails=findViewById(R.id.txtDetails);

        BookCoordinator.Book book=(BookCoordinator.Book)getIntent().getSerializableExtra("book");
        txtTitle.setText(book.title);
        txtAuthor.setText(book.author);
        txtEdition.setText(book.edition);
        txtISBN.setText(book.isbn);
        txtDetails.setText(book.details);

    }
}
