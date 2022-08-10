package github.racolin.dagger.dagger.basic;

import github.racolin.dagger.MainActivity;
import github.racolin.dagger.dagger.practice_1.WordViewModel;

//@Component(modules = {ThirdModule.class, SubComponentModule.class})
public interface ApplicationGraph {
    UserRepository userRepository();
    UserRemoteData userRemoteData();
    void inject(MainActivity mainActivity);
    SubComponentGraph.Factory subComponentGraph();
    WordViewModel userViewModel();
}
