package github.racolin.dagger.dagger.basic;

import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Scope;
import javax.inject.Singleton;


public class UserRemoteData {
    @Inject
    public UserRemoteData(Third third) {
        Log.d("debug", "UserRemoteData:(" + third.getKey() + ", " + third.getValue());
    }
}
