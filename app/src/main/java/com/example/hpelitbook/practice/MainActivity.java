package com.example.hpelitbook.practice;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    List<Data> dataList, filteredDataList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        dataList.add(new Data("نام خوراک","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("ماکارونی","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("نام خوراک","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("پیتزا","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("عدس پلو","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("نام خوراک","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("خورشت قیمه","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("برگر","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("سبزی پلو با ماهی","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("نام خوراک","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));
        dataList.add(new Data("نام خوراک","توضیحات لازم توضیحات لازم توضیحات لازم",R.drawable.p1,0));


        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewMain);
        layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter =new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        filteredDataList = filter(dataList, newText);
        adapter.setFilter(filteredDataList);
        return true;
    }

    private List<Data> filter(List<Data> dataList, String newText) {
        newText=newText.toLowerCase();
        String text;
        filteredDataList=new ArrayList<>();
        for(Data dataFromDataList:dataList){
            text=dataFromDataList.title.toLowerCase();

            if(text.contains(newText)){
                filteredDataList.add(dataFromDataList);
            }
        }

        return filteredDataList;
    }
}
