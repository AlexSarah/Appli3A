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

        //mMessageEditText = (EditText) findViewById(R.id.editText_main);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }

    public void showList(final List<Api> input){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new Click(getApplicationContext(), recyclerView, new Click.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Api api= input.get(position);
                //Toast.makeText(getApplicationContext(), ((Api) api).getName(), Toast.LENGTH_SHORT).show();
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

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    //public static final String EXTRA_MESSAGE ="com.example.appli3a.extra.MESSAGE";

    //private EditText mMessageEditText;

    public void launchSecondActivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);
        //String message = mMessageEditText.getText().toString();

        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
