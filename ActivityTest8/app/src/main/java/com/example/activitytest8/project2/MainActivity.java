package com.example.activitytest8.project2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activitytest8.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<BookView> bookList = new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //调用方法获取全部的书籍信息
        initBooks();
        //把书籍信息传到listView
        BookAdapter adapter1 = new BookAdapter(MainActivity.this, R.layout.bookview, bookList);
        ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter1);
        //添加书籍按钮，并设置事件
        Button addBook = (Button) findViewById(R.id.add_book);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });


    }

    //获取全部书籍信息
    @SuppressLint("Range")
    private void initBooks() {
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select b.name,b.price,c.category_name from Book as b,Category as c where b.category_id=c.id", null);
        if (cursor1.moveToFirst()) {
            do {
                BookView bookView = new BookView();
                bookView.setName(cursor1.getString(cursor1.getColumnIndex("name")));
                bookView.setPrice(Double.toString(cursor1.getDouble(cursor1.getColumnIndex("price"))));
                bookView.setCategory_name(cursor1.getString(cursor1.getColumnIndex("category_name")));
                bookList.add(bookView);
            } while (cursor1.moveToNext());
        }
        cursor1.close();
    }
}