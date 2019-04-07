package water.com.watertamagochiar.screens.weekly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import water.com.watertamagochiar.screens.common.controllers.BaseFragment;

public class WeeklyFragment extends BaseFragment {

    public static WeeklyFragment newInstance() {

        Bundle args = new Bundle();

        WeeklyFragment fragment = new WeeklyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private WeeklyController mWeeklyController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        WeeklyViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getWeeklyViewMvc(container);
        mWeeklyController = getCompositionRoot().getWeeklyController();
        mWeeklyController.bindView(viewMvc);
        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mWeeklyController.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mWeeklyController.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mWeeklyController.onStop();
    }
}
