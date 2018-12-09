package com.example.arsonist.shoppinglist;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
        ProductLayout productLayout = new ProductLayout();
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            productLayout.titleView =(TextView) view.findViewById(R.id.product_title_text_view);
            productLayout.priceView =(TextView) view.findViewById(R.id.product_price_text_view);
            view.setTag(productLayout);
        } else {
            view = convertView;
            productLayout = (ProductLayout) view.getTag();
        }
        productLayout.titleView.setText(product.getTitle());
        productLayout.priceView.setText(product.getPrice());
        return view;
    }

    class ProductLayout {
        TextView titleView;
        TextView priceView;
        ImageView imgView;
        Button addButton;
    }
}