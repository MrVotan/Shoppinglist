package com.example.arsonist.shoppinglist;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.fastjson.JSON;

import com.example.arsonist.shoppinglist.thread.ProductHttpThread;
import com.example.arsonist.shoppinglist.bean.Product;
import com.example.arsonist.shoppinglist.adapter.ProductShowAdapter;
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


        ProductHttpThread productHttpThread = new ProductHttpThread();
        productHttpThread.start();
        try {
            productHttpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> list =
                JSON.parseArray(productHttpThread.getResult(), Product.class);
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
