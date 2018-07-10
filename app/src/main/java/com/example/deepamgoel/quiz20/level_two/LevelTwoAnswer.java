package com.example.deepamgoel.quiz20.level_two;

public class LevelTwoAnswer {

    LevelTwoAdapter.CardViewHolder viewHolder;
    String question;
    String[] answer;

    LevelTwoAnswer(LevelTwoAdapter.CardViewHolder viewHolder, String question, String[] answer) {
        this.viewHolder = viewHolder;
        this.question = question;
        this.answer = answer;
    }
}
