package com.example.deepamgoel.quiz20.level_one;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

import java.util.List;

public class LevelOneAdapter extends RecyclerView.Adapter<LevelOneAdapter.CardViewHolder> {

    private Context context;
    private List<LevelOneModel> list;


    LevelOneAdapter(Context context, List<LevelOneModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_one, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        LevelOneModel levelOneModel = list.get(position);
        holder.question.setText(levelOneModel.question);
        holder.option1.setText(levelOneModel.option1);
        holder.option2.setText(levelOneModel.option2);
        holder.option3.setText(levelOneModel.option3);
        holder.option4.setText(levelOneModel.option4);
        holder.answer = levelOneModel.answer;

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                LevelOneActivity.answerList.add(new LevelOneAnswer(holder, holder.getAdapterPosition(), group, checkedId));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        RadioGroup radioGroup;
        RadioButton option1;
        RadioButton option2;
        RadioButton option3;
        RadioButton option4;
        String answer;

        CardViewHolder(View itemView) {
            super(itemView);

            radioGroup = itemView.findViewById(R.id.level_one_radio_group);
            question = itemView.findViewById(R.id.level_one_question);
            option1 = itemView.findViewById(R.id.level_one_option_one);
            option2 = itemView.findViewById(R.id.level_one_option_two);
            option3 = itemView.findViewById(R.id.level_one_option_three);
            option4 = itemView.findViewById(R.id.level_one_option_four);
        }
    }
}
