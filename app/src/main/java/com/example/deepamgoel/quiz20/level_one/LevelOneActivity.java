package com.example.deepamgoel.quiz20.level_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepamgoel.quiz20.MainActivity;
import com.example.deepamgoel.quiz20.R;
import com.example.deepamgoel.quiz20.level_two.LevelTwoActivity;

import java.util.ArrayList;
import java.util.List;

public class LevelOneActivity extends AppCompatActivity {

    static List<LevelOneAnswer> answerList;
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
        answerList = new ArrayList<>();

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

    @Override
    public void onBackPressed() {
        Toast.makeText(LevelOneActivity.this, "Action Disabled", Toast.LENGTH_SHORT).show();//
    }

    public void submitLevelOne(View view) {
        Log.i("List size", String.valueOf(answerList.size()));
        for (int i = 0; i < answerList.size(); i++) {
            LevelOneAnswer obj = answerList.get(i);
            RadioButton radioButton = obj.radioGroup.findViewById(obj.checkedId);

            if (String.valueOf(radioButton.getText()).equals(obj.viewHolder.answer)) {
                MainActivity.score += 2;
//              TODO Add Score Indicator
//  MainActivity.scoreTextView.setText(getString(R.string.score, MainActivity.score, 30));
                radioButton.setTextColor(getResources().getColor(R.color.correct));
            } else {
                radioButton.setTextColor(getResources().getColor(R.color.incorrect));
            }
            obj.viewHolder.option1.setEnabled(false);
            obj.viewHolder.option2.setEnabled(false);
            obj.viewHolder.option3.setEnabled(false);
            obj.viewHolder.option4.setEnabled(false);

        }

        Toast.makeText(this, "Score " + MainActivity.score, Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.launch_level_two);
        button.setEnabled(true);
        view.setEnabled(false);
    }

    public void launchLevelTwo(View view) {
        Intent intent = new Intent(this, LevelTwoActivity.class);
        startActivity(intent);
    }

    private void loadData() {

        String[] questions = getResources().getStringArray(R.array.level_one_question);
        String[] optionOne = getResources().getStringArray(R.array.level_one_option_one);
        String[] optionTwo = getResources().getStringArray(R.array.level_one_option_two);
        String[] optionTree = getResources().getStringArray(R.array.level_one_option_three);
        String[] optionFour = getResources().getStringArray(R.array.level_one_option_four);
        String[] answer = getResources().getStringArray(R.array.level_one_answer);

        for (int i = 0; i < questions.length; i++) {
            LevelOneModel listItem = new LevelOneModel(
                    questions[i],
                    optionOne[i],
                    optionTwo[i],
                    optionTree[i],
                    optionFour[i],
                    answer[i]);
            listItems.add(listItem);
        }
    }
}
