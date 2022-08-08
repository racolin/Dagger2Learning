package github.racolin.dagger.dagger.basic;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    @Inject
    public UserRepository(UserLocalData userLocalData, UserRemoteData userRemoteData) {
        Log.d("debug", "UserRepository");
    }
}
