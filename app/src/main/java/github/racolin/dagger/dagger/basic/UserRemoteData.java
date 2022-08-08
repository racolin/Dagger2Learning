package github.racolin.dagger.dagger.basic;

import android.util.Log;

import javax.inject.Inject;

public class UserRemoteData {
    @Inject
    public UserRemoteData(Third third) {
        Log.d("debug", "UserRemoteData:(" + third.getKey() + ", " + third.getValue());
    }
}
