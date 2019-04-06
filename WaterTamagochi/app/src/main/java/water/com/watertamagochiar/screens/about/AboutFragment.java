package water.com.watertamagochiar.screens.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import water.com.watertamagochiar.screens.common.controllers.BaseFragment;


public class AboutFragment extends BaseFragment {

    private AboutController mAboutController;

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        AboutViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getAboutViewMvc(container);

        mAboutController = getCompositionRoot().getAboutController();
        mAboutController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAboutController.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAboutController.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAboutController.onStop();
    }
}
