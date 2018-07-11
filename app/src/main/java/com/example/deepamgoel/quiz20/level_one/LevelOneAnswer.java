package com.example.deepamgoel.quiz20.level_one;

import android.widget.RadioGroup;

public class LevelOneAnswer {
    final LevelOneAdapter.CardViewHolder viewHolder;
    RadioGroup radioGroup;
    int checkedId;

    LevelOneAnswer(final LevelOneAdapter.CardViewHolder viewHolder, RadioGroup radioGroup, int checkedId) {
        this.viewHolder = viewHolder;
        this.radioGroup = radioGroup;
        this.checkedId = checkedId;
    }
}
