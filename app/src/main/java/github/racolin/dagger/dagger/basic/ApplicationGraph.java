package github.racolin.dagger.dagger.basic;

import javax.inject.Singleton;

import dagger.Component;
import github.racolin.dagger.MainActivity;

@Singleton
@Component(modules = {ThirdModule.class, SubComponentModule.class})
public interface ApplicationGraph {
    UserRepository userRepository();
    UserRemoteData userRemoteData();
    void inject(MainActivity mainActivity);
    SubComponentGraph.Factory subComponentGraph();
}
