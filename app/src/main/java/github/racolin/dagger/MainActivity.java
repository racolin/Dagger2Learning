package github.racolin.dagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import github.racolin.dagger.dagger.practice_1.AppComponent;
import github.racolin.dagger.dagger.practice_1.AppSubComponent;
import github.racolin.dagger.dagger.practice_1.MyApplication;
import github.racolin.dagger.dagger.practice_1.WordViewModel;
import github.racolin.dagger.dagger.practice_1.adapter.WordAdapter;
import github.racolin.dagger.dagger.practice_1.database.WordDatabase;
import github.racolin.dagger.dagger.practice_1.database.model.Word;
import github.racolin.dagger.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Inject
//    private
    WordViewModel wordViewModel;

    AppSubComponent appSubComponent;

    @Inject
    WordDatabase wordDatabase;

    private ActivityMainBinding binding;
    private WordAdapter adapter;
    AppComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());
//        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        appComponent = ((MyApplication) getApplication()).appComponent;
        appSubComponent = appComponent.appSubComponentFactory().create();
        appSubComponent.inject(this);

        binding.word.setText(wordViewModel.getWord().getValue().getWord());

        binding.submit.setOnClickListener((view) -> {
//            wordViewModel.insertWord();
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
//            if (binding.word.getText().toString().equals("")) {
//                binding.word.setError("Type your word, please!");
//                binding.wordLayout.setError("Type your word, please");
//            }
        });

        Log.d("debug:repository", appSubComponent.repository().toString());
        Log.d("debug:repository", appSubComponent.repository().toString());
        Log.d("debug:appSubComponent", appSubComponent.toString());
        Log.d("debug:appComponent", appComponent.toString());

        wordViewModel.getWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                Log.d("debug", "size: " + words.size());
                adapter.submitList(wordViewModel.getWords().getValue());
            }
        });

        binding.word.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                wordViewModel.setWord(binding.word.getText().toString());
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WordAdapter(new WordAdapter.WordDiff());
        binding.recyclerView.setAdapter(adapter);
    }
}