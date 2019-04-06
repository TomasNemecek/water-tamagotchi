package water.com.watertamagochiar.screens.common.controllers;

import android.support.v7.app.AppCompatActivity;

import water.com.watertamagochiar.App;
import water.com.watertamagochiar.common.di.ControllerCompositionRoot;


public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if(mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(((App) getApplication()).getCompositionRoot(), this);
        }
        return mControllerCompositionRoot;
    }
}
