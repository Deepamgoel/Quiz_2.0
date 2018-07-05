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

    List<LevelOneModel> listItems;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.level1);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerViewOne);
        listItems = new ArrayList<>();

        loadData();

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelOneAdapter(this, listItems));

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

    private void loadData() {

        LevelOneModel listItem = new LevelOneModel(
                getString(R.string.level_one_question_one),
                getString(R.string.level_one_question_one_option_one),
                getString(R.string.level_one_question_one_option_two),
                getString(R.string.level_one_question_one_option_three),
                getString(R.string.level_one_question_one_option_four),
                getString(R.string.level_one_question_one_answer),
                false
        );
        listItems.add(listItem);

        listItem = new LevelOneModel(
                getString(R.string.level_one_question_two),
                getString(R.string.level_one_question_two_option_one),
                getString(R.string.level_one_question_two_option_two),
                getString(R.string.level_one_question_two_option_three),
                getString(R.string.level_one_question_two_option_four),
                getString(R.string.level_one_question_two_answer),
                false
        );
        listItems.add(listItem);

        listItem = new LevelOneModel(
                getString(R.string.level_one_question_three),
                getString(R.string.level_one_question_three_option_one),
                getString(R.string.level_one_question_three_option_two),
                getString(R.string.level_one_question_three_option_three),
                getString(R.string.level_one_question_three_option_four),
                getString(R.string.level_one_question_three_answer),
                false
        );
        listItems.add(listItem);

        listItem = new LevelOneModel(
                getString(R.string.level_one_question_four),
                getString(R.string.level_one_question_four_option_one),
                getString(R.string.level_one_question_four_option_two),
                getString(R.string.level_one_question_four_option_three),
                getString(R.string.level_one_question_four_option_four),
                getString(R.string.level_one_question_four_answer),
                false
        );
        listItems.add(listItem);

        listItem = new LevelOneModel(
                getString(R.string.level_one_question_five),
                getString(R.string.level_one_question_five_option_one),
                getString(R.string.level_one_question_five_option_two),
                getString(R.string.level_one_question_five_option_three),
                getString(R.string.level_one_question_five_option_four),
                getString(R.string.level_one_question_five_answer),
                false
        );
        listItems.add(listItem);
    }

}
