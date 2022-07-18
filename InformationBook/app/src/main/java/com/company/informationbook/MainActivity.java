package com.company.informationbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelClass> arrayList;
    private AdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reclyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        arrayList = new ArrayList<>();

        ModelClass mc1 = new ModelClass("The Countries", "countries");
        ModelClass mc2 = new ModelClass("Seven Wonders of the World", "wonders");
        ModelClass mc3 = new ModelClass("The Museums", "museums");
        ModelClass mc4 = new ModelClass("The Leaders", "leaders");
        ModelClass mc5 = new ModelClass("The Music", "music");
        ModelClass mc6 = new ModelClass("The Art", "art");

        arrayList.add(mc1);
        arrayList.add(mc2);
        arrayList.add(mc3);
        arrayList.add(mc4);
        arrayList.add(mc5);
        arrayList.add(mc6);

        //in order to use reclycler view you need an adapter.

        adapter = new AdapterClass(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
}