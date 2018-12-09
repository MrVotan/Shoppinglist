package com.example.arsonist.shoppinglist;

import android.app.Activity;
import android.os.Bundle;


import com.example.arsonist.shoppinglist.ProductShowAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //数据，适配器，xml布局
        List<Product> list = Arrays.asList(

                new Product("title", "$200"),
                new Product("tisadfstlasfea", "$2200"),
                new Product("tisaftleb", "$2030"),
                new Product("tisafstlec", "$1200")
        );
        ProductShowAdapter productShowAdapter = new ProductShowAdapter(
                this,R.layout.product_show_layout, list
        );
        ListView listView = (ListView)findViewById(R.id.product_list_view);
        listView.setAdapter(productShowAdapter);

    }













    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }














    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
