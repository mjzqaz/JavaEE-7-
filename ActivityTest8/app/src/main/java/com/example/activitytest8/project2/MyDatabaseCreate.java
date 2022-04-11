package com.example.activitytest8.project2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activitytest8.R;

//创建数据库
public class MyDatabaseCreate extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydatabase_create);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("id", 1);
                values.put("author", "FengMenglong");
                values.put("price", 45.0);
                values.put("pages", 466);
                values.put("name", "Yu Shi Ming Yan");
                values.put("category_id", 1);
                db.insert("Book", null, values);//插入第一条数据
                values.clear();

                values.put("id", 2);
                values.put("author", "SunWukong");
                values.put("price", 56.0);
                values.put("pages", 511);
                values.put("name", "Xi You Ji");
                values.put("category_id", 2);
                db.insert("Book", null, values);//插入第一条数据
                values.clear();

                values.put("id", 1);
                values.put("category_name", "经济类");
                db.insert("Category", null, values);
                values.clear();

                values.put("id", 2);
                values.put("category_name", "战斗类");
                db.insert("Category", null, values);
                values.clear();

            }
        });
    }
}