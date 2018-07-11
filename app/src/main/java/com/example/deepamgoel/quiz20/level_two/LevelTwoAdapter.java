package com.example.deepamgoel.quiz20.level_two;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

import java.util.Collections;
import java.util.List;

public class LevelTwoAdapter extends RecyclerView.Adapter<LevelTwoAdapter.CardViewHolder> {

    private Context context;
    private List<LevelTwoModel> list;

    LevelTwoAdapter(Context context, List<LevelTwoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_two, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {

        LevelTwoModel levelTwoModel = list.get(position);
        holder.question.setText(levelTwoModel.question);
        holder.option1.setText(levelTwoModel.option1);
        holder.option2.setText(levelTwoModel.option2);
        holder.option3.setText(levelTwoModel.option3);
        holder.option4.setText(levelTwoModel.option4);
        holder.answer = levelTwoModel.answer;

        holder.option1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addAnswer(holder);
            }
        });

        holder.option2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addAnswer(holder);
            }
        });

        holder.option3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addAnswer(holder);
            }
        });

        holder.option4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addAnswer(holder);
            }
        });
    }


    private void addAnswer(final CardViewHolder holder) {
        Boolean present = false;
        LevelTwoAnswer levelTwoAnswer = new LevelTwoAnswer(
                holder, holder.question.getText().toString(), holder.answer
        );

//              To Replace existing object, if any.
        for (LevelTwoAnswer iterator : LevelTwoActivity.answerList) {
            if (iterator.question.equals(levelTwoAnswer.question)) {
                Collections.replaceAll(LevelTwoActivity.answerList, iterator, levelTwoAnswer);
                present = true;
                break;
            }
        }

//              Adding object if not present already
        if (!present) {
            LevelTwoActivity.answerList.add(levelTwoAnswer);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        CheckBox option1;
        CheckBox option2;
        CheckBox option3;
        CheckBox option4;
        String[] answer;

        CardViewHolder(View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.level_two_question);
            option1 = itemView.findViewById(R.id.level_two_option_one);
            option2 = itemView.findViewById(R.id.level_two_option_two);
            option3 = itemView.findViewById(R.id.level_two_option_three);
            option4 = itemView.findViewById(R.id.level_two_option_four);
        }
    }
}
