package github.racolin.dagger.dagger.practice_1;

import android.app.Application;

public class MyApplication extends Application {
    public AppComponent appComponent = DaggerAppComponent.builder().setContext(this).build();
}
