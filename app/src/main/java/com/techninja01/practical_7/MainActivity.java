package com.techninja01.practical_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,orderPlaced.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycle);
        ArrayList<IcecreamList> list = new ArrayList<>();
        list.add(new IcecreamList(R.drawable.caramel,"Caramel"));
        list.add(new IcecreamList(R.drawable.icecream,"Sugar Crush"));
        list.add(new IcecreamList(R.drawable.chocolate,"Dark Chocolate"));
        list.add(new IcecreamList(R.drawable.ice2ream,"Strawberry"));
        IcecreamAdapter adapter = new IcecreamAdapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}