package github.racolin.dagger.dagger.practice_1;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import github.racolin.dagger.MainActivity;

@Singleton
@Component
        (
                modules = {
                        AppModule.class,
                }
        )
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder setContext(Context context);
        AppComponent build();
    }

    AppSubComponent.Factory appSubComponentFactory();
}
