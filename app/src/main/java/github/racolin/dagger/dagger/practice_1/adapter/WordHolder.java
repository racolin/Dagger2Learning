package github.racolin.dagger.dagger.practice_1.adapter;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import github.racolin.dagger.R;
import github.racolin.dagger.databinding.WordItemBinding;

public class WordHolder extends RecyclerView.ViewHolder {

    WordItemBinding binding;

    public WordHolder(WordItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public static WordHolder create(View view) {
        return new WordHolder(WordItemBinding.inflate(LayoutInflater.from(view.getContext())));
    }
}
