package github.racolin.dagger.dagger.basic;

import android.util.Log;

import javax.inject.Inject;

public class UserViewModel {
    @Inject
    public UserViewModel() {
        Log.d("debug", "UserViewModel");
    }
}
