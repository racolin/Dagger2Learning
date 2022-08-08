package github.racolin.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;
import github.racolin.dagger.dagger.basic.ApplicationGraph;
import github.racolin.dagger.dagger.basic.DaggerApplicationGraph;
import github.racolin.dagger.dagger.basic.HyperData;
import github.racolin.dagger.dagger.basic.SubComponentGraph;
import github.racolin.dagger.dagger.basic.Third;
import github.racolin.dagger.dagger.basic.UserRemoteData;
import github.racolin.dagger.dagger.basic.UserRepository;
import github.racolin.dagger.dagger.basic.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Inject
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationGraph applicationGraph = DaggerApplicationGraph.create();
        UserRepository u1 = applicationGraph.userRepository();
        UserRepository u2 = applicationGraph.userRepository();
        Log.d("debug", "" + (u1 == u2));
        Log.d("debug", "" + (userViewModel == null));
        applicationGraph.inject(this);
        Log.d("debug", "" + (userViewModel == null));
        SubComponentGraph subComponentGraph = applicationGraph.subComponentGraph().create();
        HyperData hyperData = subComponentGraph.hyperData();
    }
}