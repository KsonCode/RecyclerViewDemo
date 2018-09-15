package com.example.kson.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kson.recyclerviewdemo.adapter.RecyAdapter;
import com.example.kson.recyclerviewdemo.bean.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyAdapter.ClickListener{
    private RecyclerView recyclerView;
    private RecyAdapter recyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     *
     */
    private void initView() {
        recyclerView = findViewById(R.id.recylerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Product product = new Product();
            product.title = "kson"+i;
            list.add(product);
        }

        recyAdapter = new RecyAdapter(this, list);
        recyclerView.setAdapter(recyAdapter);
        //为RecycleView添加ItemTouchHelper
        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(recyAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(recyclerView);
        if (recyAdapter!=null){
            recyAdapter.setClickListener(this);
        }

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    @Override
    public void onItemClickListener(View view,int pos) {

        Toast.makeText(this, pos+"", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onItemLongClickListener(View view,int pos) {
        Toast.makeText(this, pos+"", Toast.LENGTH_SHORT).show();
    }
}
