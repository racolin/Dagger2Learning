package github.racolin.dagger.dagger.practice_1.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import github.racolin.dagger.MainActivity2;
import github.racolin.dagger.R;
import github.racolin.dagger.dagger.practice_1.database.model.Word;
import github.racolin.dagger.databinding.WordItemBinding;

public class WordAdapter extends ListAdapter<Word, WordHolder> {
    public WordAdapter(@NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, int position) {
        holder.binding.setWord(getItem(position));
        holder.binding.getRoot().setOnClickListener((view) -> {
            Intent i = new Intent(holder.binding.getRoot().getContext(), MainActivity2.class);
            holder.binding.getRoot().getContext().startActivity(i);
        });
    }

    public static class WordDiff extends DiffUtil.ItemCallback<Word> {

        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }
}
