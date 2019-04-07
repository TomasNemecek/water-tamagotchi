package water.com.watertamagochiar.screens.main;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gelitenight.waveview.library.WaveView;

import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.about.AboutViewMvc;
import water.com.watertamagochiar.screens.common.ToolBarViewMvc;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.navdrawer.BaseNavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;

public class MainViewMvcImpl extends BaseNavDrawerViewMvc<MainViewMvc.Listener> implements MainViewMvc {

    private final ToolBarViewMvc mToolBarViewMvc;
    private final Toolbar mToolBar;
//    private final WaveView mWaveView;
//
//    private final WaveHelper mWaveHelper;

    private final FloatingActionButton mBtnAR;

    public MainViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);

        setRootView(inflater.inflate(R.layout.layout_main, parent, false));

        mBtnAR = findViewById(R.id.btn_ar);
//        mWaveView = findViewById(R.id.wave);
//        mWaveHelper = new WaveHelper(mWaveView);

        mToolBar = findViewById(R.id.toolbar);
        mToolBarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolBar);
        initToolbar();
        initARButton();
    }

    private void initToolbar() {
        mToolBarViewMvc.setTitle(getContext().getString(R.string.daily_title));
        mToolBar.addView(mToolBarViewMvc.getRootView());
        mToolBarViewMvc.enableHamburgerButtonAndListen(this::openDrawer);
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
        for(MainViewMvc.Listener listener : getListeners()) {
            listener.onDrawerItemClicked(item);
        }
    }


    @Override
    public void waveStart() {
//        mWaveHelper.start();
    }

    @Override
    public void wavePause() {
//        mWaveHelper.cancel();
    }
}
