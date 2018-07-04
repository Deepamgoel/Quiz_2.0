package com.example.deepamgoel.quiz20.level_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

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

        for (int i = 0; i < 10; i++) {
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
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelOneAdapter(listItems));

    }
}
