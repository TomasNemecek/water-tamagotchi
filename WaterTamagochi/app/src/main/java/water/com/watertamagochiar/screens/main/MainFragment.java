package water.com.watertamagochiar.screens.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import water.com.watertamagochiar.screens.about.AboutViewMvc;
import water.com.watertamagochiar.screens.common.controllers.BaseFragment;

public class MainFragment extends BaseFragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainController mMainController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        MainViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getMainViewMvc(container);
        mMainController = getCompositionRoot().getMainController();
        mMainController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMainController.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMainController.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMainController.onStop();
    }

}
