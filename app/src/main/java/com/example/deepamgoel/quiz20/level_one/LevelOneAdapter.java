package com.example.deepamgoel.quiz20.level_one;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

import java.util.List;

public class LevelOneAdapter extends RecyclerView.Adapter<LevelOneAdapter.CardViewHolder> {


    private List<LevelOneModel> list;

    LevelOneAdapter(List<LevelOneModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_one, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        LevelOneModel levelOneModel = list.get(position);
        holder.question.setText(levelOneModel.question);
        holder.option1.setText(levelOneModel.option1);
        holder.option2.setText(levelOneModel.option2);
        holder.option3.setText(levelOneModel.option3);
        holder.option4.setText(levelOneModel.option4);
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

            question = itemView.findViewById(R.id.ques_level_one);
            option1 = itemView.findViewById(R.id.opt1_level_one);
            option2 = itemView.findViewById(R.id.opt2_level_one);
            option3 = itemView.findViewById(R.id.opt3_level_one);
            option4 = itemView.findViewById(R.id.opt4_level_one);
        }
    }
}
