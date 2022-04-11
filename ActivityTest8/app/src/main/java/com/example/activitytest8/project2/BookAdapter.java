package com.example.activitytest8.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.activitytest8.R;

import java.util.List;

public class BookAdapter extends ArrayAdapter<BookView> {
    private int resourceId;

    public BookAdapter(Context context, int resource, List<BookView> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        BookView book = getItem(position);//获取当前项的Bookview实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView name = (TextView) view.findViewById(R.id.Bookview_name);
        TextView price = (TextView) view.findViewById(R.id.Bookview_price);
        TextView category_name = (TextView) view.findViewById(R.id.category_name);

        name.setText(book.getName());
        price.setText(book.getPrice());
        category_name.setText(book.getCategory_name());
        return view;
    }
}
