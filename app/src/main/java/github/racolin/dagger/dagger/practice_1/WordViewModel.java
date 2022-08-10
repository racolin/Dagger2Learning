package github.racolin.dagger.dagger.practice_1;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import github.racolin.dagger.dagger.practice_1.database.repository.Repository;
import github.racolin.dagger.dagger.practice_1.database.model.Word;

//@LocalSingleton
public class WordViewModel
//        extends AndroidViewModel
{
    private Repository repository;
    private MutableLiveData<Word> word = new MutableLiveData<>(new Word());

    @Inject
    public WordViewModel(Repository repository) {
//        super(application);
        this.repository = repository;
    }

    public LiveData<List<Word>> getWords() {
        return repository.getWords();
    }

    public void insertWords(Word... words) {
        repository.insertWord(words);
    }

    public void insertWord() {
        repository.insertWord(word.getValue());
    }

    public void deleteWords(Word... words) {
        repository.deleteWord(words);
    }

    public void updateWords(Word... words) {
        repository.updateWord(words);
    }

    public LiveData<Word> getWord() {
        return word;
    }

    public void setWord(String w) {
        Word ww = word.getValue();
        ww.setWord(w);
        word.setValue(ww);
    }
}
