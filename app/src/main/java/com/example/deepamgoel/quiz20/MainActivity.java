package com.example.deepamgoel.quiz20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.level_one.LevelOneActivity;

public class MainActivity extends AppCompatActivity {

    public static int score;
    public static TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.app_name);
        setSupportActionBar(toolbar);
        score = 0;
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

    public void launchLevelOne(View view) {
        Intent intent = new Intent(this, LevelOneActivity.class);
        startActivity(intent);
    }
}

