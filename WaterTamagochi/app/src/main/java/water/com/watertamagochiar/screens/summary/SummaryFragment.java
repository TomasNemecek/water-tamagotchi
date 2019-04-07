package water.com.watertamagochiar.screens.summary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import water.com.watertamagochiar.screens.common.controllers.BaseFragment;

public class SummaryFragment extends BaseFragment {

    public static SummaryFragment newInstance() {

        Bundle args = new Bundle();

        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private SummaryController mSummaryController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        SummaryViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getSummaryViewMvc(container);
        mSummaryController = getCompositionRoot().getSummaryController();
        mSummaryController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mSummaryController.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mSummaryController.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mSummaryController.onStop();
    }
}
