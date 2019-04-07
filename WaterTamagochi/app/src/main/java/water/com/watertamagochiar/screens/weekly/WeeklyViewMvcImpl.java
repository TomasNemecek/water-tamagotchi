package water.com.watertamagochiar.screens.weekly;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.ToolBarViewMvc;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.navdrawer.BaseNavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.summary.SummaryViewMvc;

public class WeeklyViewMvcImpl extends BaseNavDrawerViewMvc<WeeklyViewMvc.Listener> implements WeeklyViewMvc {

    private final ToolBarViewMvc mToolBarViewMvc;
    private final Toolbar mToolBar;

    public WeeklyViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);

        setRootView(inflater.inflate(R.layout.layout_weekly, parent, false));

        mToolBar = findViewById(R.id.toolbar);
        mToolBarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolBar);
        initToolbar();
    }

    private void initToolbar() {
        mToolBarViewMvc.setTitle(getContext().getString(R.string.weekly_title));
        mToolBar.addView(mToolBarViewMvc.getRootView());
        mToolBarViewMvc.enableHamburgerButtonAndListen(this::openDrawer);
    }

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for(WeeklyViewMvc.Listener listener : getListeners()) {
            listener.onDrawerItemClicked(item);
        }
    }
}
