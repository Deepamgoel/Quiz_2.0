package com.example.deepamgoel.quiz20.level_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepamgoel.quiz20.R;
import com.example.deepamgoel.quiz20.level_two.LevelTwoActivity;

import java.util.ArrayList;
import java.util.List;

public class LevelOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.level1);
        setSupportActionBar(toolbar);

        List<LevelOneModel> listItems = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            LevelOneModel listItem = new LevelOneModel(
                    "Question " + (i + 1),
                    "Lorem Ipsum",
                    "Lorem Ipsum",
                    "Lorem Ipsum",
                    "Lorem Ipsum"
            );
            listItems.add(listItem);
        }

        RecyclerView mRecyclerView = findViewById(R.id.recyclerViewOne);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelOneAdapter(listItems));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.info) {
            Toast.makeText(LevelOneActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void launchLevelTwo(View view) {
        Intent intent = new Intent(this, LevelTwoActivity.class);
        startActivity(intent);
    }
}
