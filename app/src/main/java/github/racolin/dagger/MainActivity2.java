package github.racolin.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import github.racolin.dagger.dagger.practice_1.AppComponent;
import github.racolin.dagger.dagger.practice_1.AppSubComponent;
import github.racolin.dagger.dagger.practice_1.MyApplication;
import github.racolin.dagger.dagger.practice_1.WordViewModel;

public class MainActivity2 extends AppCompatActivity {

    AppSubComponent appSubComponent;
    AppComponent appComponent;
    @Inject
    WordViewModel wordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        appComponent = ((MyApplication) getApplication()).appComponent;
        appSubComponent = appComponent.appSubComponentFactory().create();
        Log.d("debug.appSubComponent", appSubComponent.toString());
        Log.d("debug:appComponent", appComponent.toString());


        Log.d("debug.repository", appSubComponent.repository().toString());

        Log.d("debug:repository", appSubComponent.repository().toString());


        Log.d("debug:repository", appSubComponent.repository().toString());

        Log.d("debug:repository", appSubComponent.repository().toString());

        appSubComponent = appComponent.appSubComponentFactory().create();

        Log.d("debug:repository", appSubComponent.repository().toString());

        Log.d("debug:repository", appSubComponent.repository().toString());

        Log.d("debug:repository", appSubComponent.repository().toString());
        appSubComponent.inject(this);
        Log.d("debug", wordViewModel.toString());
        appSubComponent.inject(this);
        Log.d("debug", wordViewModel.toString());
    }
}