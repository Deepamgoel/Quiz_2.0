package com.example.deepamgoel.quiz20.level_three;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepamgoel.quiz20.MainActivity;
import com.example.deepamgoel.quiz20.R;
import com.example.deepamgoel.quiz20.ViewDialog;

import java.util.ArrayList;
import java.util.List;

public class LevelThreeActivity extends AppCompatActivity {

    static List<LevelThreeAnswer> answerList;
    List<LevelThreeModel> listItems;
    RecyclerView mRecyclerView;
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.level3);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerViewThree);
        scoreTextView = findViewById(R.id.score_text_view);
        listItems = new ArrayList<>();
        answerList = new ArrayList<>();

        scoreTextView.setText(getString(R.string.score, MainActivity.score, 30));
        loadData();

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelThreeAdapter(this, listItems));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.info) {
            ViewDialog alert = new ViewDialog();
            alert.showDialog(this, getString(R.string.dialog_message));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Action Disabled", Toast.LENGTH_SHORT).show();
    }

    public void submitLevelThree(View view) {
        ViewDialog alert = new ViewDialog();

        for (int i = 0; i < answerList.size(); i++) {
            LevelThreeAnswer obj = answerList.get(i);
            if (obj.viewHolder.answer.equals(obj.editable.toString())) {
                obj.viewHolder.editText.setTextColor(getResources().getColor(R.color.correct));
                MainActivity.score += 4;
                scoreTextView.setText(getString(R.string.score, MainActivity.score, 30));
            } else {
                obj.viewHolder.editText.setTextColor(getResources().getColor(R.color.incorrect));
            }
            obj.viewHolder.editText.setEnabled(false);
        }

        Toast.makeText(this, getString(R.string.score, MainActivity.score, 30), Toast.LENGTH_LONG).show();

        String message = "You Scored: " + MainActivity.score + " out of 30";
        if (MainActivity.score <= 10) {
            message += "\nBetter Luck Next Time!";
            alert.showDialog(this, message, ContextCompat.getDrawable(this, R.drawable.better_luck_next_time));
        } else if (MainActivity.score > 10 && MainActivity.score <= 20) {
            message += "\n Well Played!";
            alert.showDialog(this, message, ContextCompat.getDrawable(this, R.drawable.well_played));
        } else {
            message += "\n You are the real Champion!";
            alert.showDialog(this, message, ContextCompat.getDrawable(this, R.drawable.champ));
        }

        Button button = findViewById(R.id.level_three_exit);
        button.setEnabled(true);
        view.setEnabled(false);
    }

    public void exitLevelThree(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void loadData() {
        String[] questions = getResources().getStringArray(R.array.level_three_question);
        TypedArray images = getResources().obtainTypedArray(R.array.level_three_images);
        String[] answer = getResources().getStringArray(R.array.level_three_answer);

        for (int i = 0; i < questions.length; i++) {
            int id = images.getResourceId(i, 0);
            LevelThreeModel listItem = new LevelThreeModel(questions[i], ContextCompat.getDrawable(this, id), answer[i]);
            listItems.add(listItem);
        }
        images.recycle();
    }
}
