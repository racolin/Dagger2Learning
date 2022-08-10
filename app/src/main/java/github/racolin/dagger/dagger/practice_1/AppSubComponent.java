package github.racolin.dagger.dagger.practice_1;


import javax.inject.Singleton;

import dagger.Subcomponent;
import github.racolin.dagger.MainActivity;
import github.racolin.dagger.MainActivity2;
import github.racolin.dagger.dagger.practice_1.database.repository.Repository;

@LocalSingleton
@Subcomponent
public interface AppSubComponent {
    @Subcomponent.Factory
    interface Factory {
        AppSubComponent create();
    }

    void inject(MainActivity mainActivity);

    void inject(MainActivity2 mainActivity2);

    Repository repository();
}
