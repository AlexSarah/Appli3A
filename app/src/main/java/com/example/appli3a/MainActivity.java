package com.example.appli3a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();
    }

    public void showList(final List<Api> input){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new Click(getApplicationContext(), recyclerView, new Click.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Api api= input.get(position);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("description",api.getDescription());
                intent.putExtra("name",api.getName());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}
