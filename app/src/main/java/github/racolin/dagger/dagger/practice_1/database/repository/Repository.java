package github.racolin.dagger.dagger.practice_1.database.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

//import github.racolin.dagger.dagger.practice_1.LocalSingleton;
import github.racolin.dagger.dagger.practice_1.LocalSingleton;
import github.racolin.dagger.dagger.practice_1.database.WordDatabase;
import github.racolin.dagger.dagger.practice_1.database.dao.WordDao;
import github.racolin.dagger.dagger.practice_1.database.model.Word;

@LocalSingleton
public class Repository {

    private WordDao wordDao;
    private LiveData<List<Word>> words;

    @Inject
    public Repository(WordDatabase wordDatabase) {

        wordDao = wordDatabase.wordDao();

        words = wordDao.getAllWords();

    }

    public LiveData<List<Word>> getWords() {
        return words;
    }

    public void insertWord(Word... words) {
        WordDatabase.executorService.execute(() -> {
            wordDao.insert(words);
        });
    }

    public void deleteWord(Word... words) {
        WordDatabase.executorService.execute(() -> {
            wordDao.delete(words);
        });
    }

    public void updateWord(Word... words) {
        WordDatabase.executorService.execute(() -> {
            wordDao.update(words);
        });
    }
}
