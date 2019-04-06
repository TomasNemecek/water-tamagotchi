package water.com.watertamagochiar.screens.common.controllers;

import android.support.v4.app.Fragment;

import water.com.watertamagochiar.App;
import water.com.watertamagochiar.common.di.ControllerCompositionRoot;


public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if(mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(((App) requireActivity().getApplication()).getCompositionRoot(), requireActivity());
        }
        return mControllerCompositionRoot;
    }
}
