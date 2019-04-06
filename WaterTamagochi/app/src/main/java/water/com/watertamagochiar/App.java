package water.com.watertamagochiar;

import android.app.Application;
import timber.log.Timber;
import water.com.watertamagochiar.common.di.CompositionRoot;

public class App extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();

        mCompositionRoot = new CompositionRoot();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }

}
