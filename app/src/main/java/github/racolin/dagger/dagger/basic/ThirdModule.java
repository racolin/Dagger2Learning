package github.racolin.dagger.dagger.basic;

import dagger.Module;
import dagger.Provides;

@Module
public class ThirdModule {
    @Provides
    public Third third() {
        return new Third.Builder().addKey("price").addValue(100).build();
    }
}
