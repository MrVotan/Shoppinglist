package com.example.arsonist.shoppinglist;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductShowAdapter extends ArrayAdapter {
    private int resourceId;
    public ProductShowAdapter( Context context,
                              int resource,
                               List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        Product product = (Product) getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView titleView = (TextView)view.findViewById(R.id.product_title_text_view);
        titleView.setText(product.getTitle());
        TextView priceView = (TextView)view.findViewById(R.id.product_price_text_view);
        priceView.setText(product.getPrice());
        return view;
    }
}