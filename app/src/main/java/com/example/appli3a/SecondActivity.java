package com.example.appli3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        description.setText((intent.getStringExtra("description")));
    }


}
