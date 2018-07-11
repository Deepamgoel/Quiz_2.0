package com.example.deepamgoel.quiz20.level_three;

import android.text.Editable;

class LevelThreeAnswer {
    LevelThreeAdapter.CardViewHolder viewHolder;
    Editable editable;

    LevelThreeAnswer(LevelThreeAdapter.CardViewHolder viewHolder, Editable editable) {
        this.viewHolder = viewHolder;
        this.editable = editable;
    }
}
