package com.example.deepamgoel.quiz20.level_two;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepamgoel.quiz20.MainActivity;
import com.example.deepamgoel.quiz20.R;
import com.example.deepamgoel.quiz20.ViewDialog;
import com.example.deepamgoel.quiz20.level_three.LevelThreeActivity;

import java.util.ArrayList;
import java.util.List;

public class LevelTwoActivity extends AppCompatActivity {

    static List<LevelTwoAnswer> answerList;
    List<LevelTwoModel> listItems;
    RecyclerView mRecyclerView;
    TextView scoreTextView;

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
        scoreTextView = findViewById(R.id.score_text_view);
        listItems = new ArrayList<>();
        answerList = new ArrayList<>();

        scoreTextView.setText(getString(R.string.score, MainActivity.score, 30));
        loadData();

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LevelTwoAdapter(this, listItems));

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

    public void submitLevelTwo(View view) {

        for (int i = 0; i < answerList.size(); i++) {
            LevelTwoAnswer obj = answerList.get(i);
            CheckBox option1 = obj.viewHolder.option1;
            CheckBox option2 = obj.viewHolder.option2;
            CheckBox option3 = obj.viewHolder.option3;
            CheckBox option4 = obj.viewHolder.option4;
            Boolean correct = true;

            if (option1.isChecked()) {
                if (Boolean.parseBoolean(obj.answer[0]))
                    option1.setTextColor(getResources().getColor(R.color.correct));
                else {
                    correct = false;
                    option1.setTextColor(getResources().getColor(R.color.incorrect));
                }
            } else {
                if (Boolean.parseBoolean(obj.answer[0])) {
                    option1.setTextColor(getResources().getColor(R.color.correct));
                    correct = false;
                }
            }

            if (option2.isChecked()) {
                if (Boolean.parseBoolean(obj.answer[1]))
                    option2.setTextColor(getResources().getColor(R.color.correct));
                else {
                    correct = false;
                    option2.setTextColor(getResources().getColor(R.color.incorrect));
                }
            } else {
                if (Boolean.parseBoolean(obj.answer[1])) {
                    option2.setTextColor(getResources().getColor(R.color.correct));
                    correct = false;
                }
            }

            if (option3.isChecked()) {
                if (Boolean.parseBoolean(obj.answer[2]))
                    option3.setTextColor(getResources().getColor(R.color.correct));
                else {
                    correct = false;
                    option3.setTextColor(getResources().getColor(R.color.incorrect));
                }
            } else {
                if (Boolean.parseBoolean(obj.answer[2])) {
                    option3.setTextColor(getResources().getColor(R.color.correct));
                    correct = false;
                }
            }

            if (option4.isChecked()) {
                if (Boolean.parseBoolean(obj.answer[3]))
                    option4.setTextColor(getResources().getColor(R.color.correct));
                else {
                    correct = false;
                    option4.setTextColor(getResources().getColor(R.color.incorrect));
                }
            } else {
                if (Boolean.parseBoolean(obj.answer[3])) {
                    option4.setTextColor(getResources().getColor(R.color.correct));
                    correct = false;
                }
            }


            if (correct) {
                MainActivity.score += 2;
                scoreTextView.setText(getString(R.string.score, MainActivity.score, 30));
            }

            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);

        }

        Toast.makeText(this, getString(R.string.score, MainActivity.score, 30), Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.launch_level_three);
        button.setEnabled(true);
        view.setEnabled(false);
    }

    public void launchLevelThree(View view) {
        Intent intent = new Intent(this, LevelThreeActivity.class);
        startActivity(intent);
    }

    private void loadData() {

        String[] questions = getResources().getStringArray(R.array.level_two_question);
        String[] optionOne = getResources().getStringArray(R.array.level_two_option_one);
        String[] optionTwo = getResources().getStringArray(R.array.level_two_option_two);
        String[] optionTree = getResources().getStringArray(R.array.level_two_option_three);
        String[] optionFour = getResources().getStringArray(R.array.level_two_option_four);

        //To extract answer array from an array
        TypedArray typedArray = getResources().obtainTypedArray(R.array.level_two_answer);
        String[][] answer = new String[typedArray.length()][];
        for (int i = 0; i < typedArray.length(); i++) {
            int id = typedArray.getResourceId(i, 0);
            answer[i] = getResources().getStringArray(id);
        }
        typedArray.recycle();


        for (int i = 0; i < questions.length; i++) {
            LevelTwoModel listItem = new LevelTwoModel(
                    questions[i],
                    optionOne[i],
                    optionTwo[i],
                    optionTree[i],
                    optionFour[i],
                    answer[i]
            );
            listItems.add(listItem);
        }
    }

}
