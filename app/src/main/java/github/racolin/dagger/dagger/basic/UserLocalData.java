package github.racolin.dagger.dagger.basic;

import android.util.Log;

import javax.inject.Inject;

public class UserLocalData {
    @Inject
    public UserLocalData() {
        Log.d("debug", "UserLocalData");
    }
}
