package github.racolin.dagger.dagger.practice_1.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import github.racolin.dagger.dagger.practice_1.database.model.Word;

@Dao
public interface WordDao {
    @Insert
    void insert(Word... words);

    @Delete
    void delete(Word... words);

    @Update
    void update(Word... words);

    @Query("SELECT * FROM word ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}

