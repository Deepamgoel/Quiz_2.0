package com.example.deepamgoel.quiz20.level_three;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepamgoel.quiz20.R;

import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

class LevelThreeAdapter extends RecyclerView.Adapter<LevelThreeAdapter.CardViewHolder> {

    private Context context;
    private List<LevelThreeModel> list;

    LevelThreeAdapter(Context context, List<LevelThreeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_three, parent, false);
        return new LevelThreeAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        LevelThreeModel levelThreeModel = list.get(position);
        holder.question.setText(levelThreeModel.question);
        holder.imageView.setImageDrawable(levelThreeModel.drawable);
        holder.answer = levelThreeModel.answer;

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Boolean present = false;
                LevelThreeAnswer levelThreeAnswer = new LevelThreeAnswer(holder, s);

//              To Replace existing object, if any.
                for (LevelThreeAnswer iterator : LevelThreeActivity.answerList) {
                    if (iterator.viewHolder.question.equals(holder.question)) {
                        Log.i(TAG, "Replaced");
                        Collections.replaceAll(LevelThreeActivity.answerList, iterator, levelThreeAnswer);
                        present = true;
                        break;
                    }
                }

//              Adding object if not present already
                if (!present) {
                    Log.i(TAG, "Added");
                    LevelThreeActivity.answerList.add(levelThreeAnswer);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        ImageView imageView;
        EditText editText;
        String answer;

        CardViewHolder(View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.level_three_question);
            imageView = itemView.findViewById(R.id.level_three_image);
            editText = itemView.findViewById(R.id.level_three_answer);

        }
    }

}
