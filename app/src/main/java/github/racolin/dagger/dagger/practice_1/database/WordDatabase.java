package github.racolin.dagger.dagger.practice_1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import github.racolin.dagger.dagger.practice_1.database.dao.WordDao;
import github.racolin.dagger.dagger.practice_1.database.model.Word;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private volatile static WordDatabase INSTANCE;

    private static final String WORD_DATABASE = "word_database";

    private static final int THREAD_COUNT = 4;

    public static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public static WordDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, WordDatabase.class, WORD_DATABASE)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WordDao wordDao();
}
