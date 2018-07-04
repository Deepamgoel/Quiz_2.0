package com.example.deepamgoel.quiz20.level_two;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

import java.util.List;

public class LevelTwoAdapter extends RecyclerView.Adapter<LevelTwoAdapter.CardViewHolder> {


    private List<LevelTwoModel> list;

    LevelTwoAdapter(List<LevelTwoModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_two, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        LevelTwoModel levelTwoModel = list.get(position);
        holder.question.setText(levelTwoModel.question);
        holder.option1.setText(levelTwoModel.option1);
        holder.option2.setText(levelTwoModel.option2);
        holder.option3.setText(levelTwoModel.option3);
        holder.option4.setText(levelTwoModel.option4);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        TextView option1;
        TextView option2;
        TextView option3;
        TextView option4;

        CardViewHolder(View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.ques_level_two);
            option1 = itemView.findViewById(R.id.opt1_level_two);
            option2 = itemView.findViewById(R.id.opt2_level_two);
            option3 = itemView.findViewById(R.id.opt3_level_two);
            option4 = itemView.findViewById(R.id.opt4_level_two);
        }
    }
}
