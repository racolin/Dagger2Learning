package github.racolin.dagger.dagger.basic;

import javax.inject.Inject;

import dagger.Component;
import dagger.Subcomponent;
import github.racolin.dagger.MainActivity;

@Subcomponent
public interface SubComponentGraph {

    @Subcomponent.Factory
    interface Factory {
        SubComponentGraph create();
    }

    HyperData hyperData();

    void inject(MainActivity mainActivity);
}
