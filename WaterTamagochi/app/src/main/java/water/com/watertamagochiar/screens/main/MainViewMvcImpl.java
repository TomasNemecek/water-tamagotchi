package water.com.watertamagochiar.screens.main;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.ToolBarViewMvc;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.navdrawer.BaseNavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;

public class MainViewMvcImpl extends BaseNavDrawerViewMvc<MainViewMvc.Listener> implements MainViewMvc {

    private final ToolBarViewMvc mToolBarViewMvc;
    private final Toolbar mToolBar;;
//    private final View mViewContent;

    private final Button mBtnAR;

    public MainViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);

        setRootView(inflater.inflate(R.layout.layout_main, parent, false));

        mBtnAR = findViewById(R.id.btn_ar);
        mToolBar = findViewById(R.id.toolbar);
        mToolBarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolBar);
        initToolbar();
        initARButton();
    }

    private void initToolbar() {
        mToolBarViewMvc.setTitle(getContext().getString(R.string.app_name));
        mToolBar.addView(mToolBarViewMvc.getRootView());
        mToolBarViewMvc.enableHamburgerButtonAndListen(() -> openDrawer());
    }

    private void initARButton() {
        mBtnAR.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onGoToARClicked();
            }
        });
    }

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {

    }


}
