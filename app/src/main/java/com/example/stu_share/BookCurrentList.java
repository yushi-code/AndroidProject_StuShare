package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.example.stu_share.BookCoordinator.BOOK_LIST;
import static com.example.stu_share.CarCoordinator.CAR_LIST;

public class BookCurrentList extends AppCompatActivity {
    private ListView listBook;
    private Button home, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_current_list);



        listBook=findViewById(R.id.bookCurrentList);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,BOOK_LIST);
        listBook.setAdapter(arrayAdapter);
        listBook.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                arrayAdapter.notifyDataSetChanged();
                BookCoordinator.Book book =(BookCoordinator.Book) adapter.getItemAtPosition(position);
                Intent intent =new Intent(getBaseContext(), BookCurrentDetail.class);
                intent.putExtra("book", book);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
        home=findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainMenu.class);
                startActivity(i);
            }
        });
        logout=findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
