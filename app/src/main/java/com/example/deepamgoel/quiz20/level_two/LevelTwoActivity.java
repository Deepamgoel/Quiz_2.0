package com.example.deepamgoel.quiz20.level_two;

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
import com.example.deepamgoel.quiz20.level_three.LevelThreeActivity;

import java.util.ArrayList;
import java.util.List;

public class LevelTwoActivity extends AppCompatActivity {

    List<LevelTwoModel> listItems;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.level2);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerViewTwo);
        listItems = new ArrayList<>();

        loadData();

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelTwoAdapter(this, listItems));

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
            Toast.makeText(LevelTwoActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void launchLevelThree(View view) {
        Intent intent = new Intent(this, LevelThreeActivity.class);
        startActivity(intent);
    }

    private void loadData() {

    }

}
