package github.racolin.dagger.dagger.practice_1;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import github.racolin.dagger.dagger.practice_1.database.WordDatabase;
@Module
        (
                subcomponents = {
                        AppSubComponent.class
                }
        )
public class AppModule {
    @Provides
    WordDatabase wordDatabase(Context context) {
        return WordDatabase.getInstance(context);
    }
}
