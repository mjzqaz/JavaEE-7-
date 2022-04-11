package com.example.activitytest8.project2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activitytest8.R;

public class AddBookActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Button add = (Button) findViewById(R.id.add);
        EditText id = (EditText) findViewById(R.id.id);
        EditText name = (EditText) findViewById(R.id.name);
        EditText author = (EditText) findViewById(R.id.author);
        EditText price = (EditText) findViewById(R.id.price);
        EditText pages = (EditText) findViewById(R.id.pages);
        EditText category_id = (EditText) findViewById(R.id.category_id);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = id.getText().toString();
                String p2 = author.getText().toString();
                String p3 = price.getText().toString();
                String p4 = pages.getText().toString();
                String p5 = name.getText().toString();
                String p6 = category_id.getText().toString();
                if (!p1.equals("") && !p2.equals("") && !p3.equals("") && !p4.equals("") && !p5.equals("") && !p6.equals("")) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into Book values(?,?,?,?,?,?)", new Object[]{p1, p2, p3, p4, p5, p6});
                    Toast.makeText(AddBookActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddBookActivity.this, "请输入全部参数！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}