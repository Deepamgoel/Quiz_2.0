package com.example.deepamgoel.quiz20.level_two;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

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
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        LevelTwoModel levelTwoModel = list.get(position);
        holder.question.setText(levelTwoModel.question);
        holder.option1.setText(levelTwoModel.option1);
        holder.option2.setText(levelTwoModel.option2);
        holder.option3.setText(levelTwoModel.option3);
        holder.option4.setText(levelTwoModel.option4);
        holder.attempted = levelTwoModel.attempted;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView question;
        CheckBox option1;
        CheckBox option2;
        CheckBox option3;
        CheckBox option4;

        Boolean attempted;

        CardViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.level_two_card_view);
            question = itemView.findViewById(R.id.level_two_question);
            option1 = itemView.findViewById(R.id.level_two_option_one);
            option2 = itemView.findViewById(R.id.level_two_option_two);
            option3 = itemView.findViewById(R.id.level_two_option_three);
            option4 = itemView.findViewById(R.id.level_two_option_four);
        }
    }
}
