package github.racolin.dagger.dagger.practice_1.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import javax.inject.Inject;

@Entity(tableName = "word")
public class Word implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String word;

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }
    @Inject
    public Word() {}

    public Word(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
