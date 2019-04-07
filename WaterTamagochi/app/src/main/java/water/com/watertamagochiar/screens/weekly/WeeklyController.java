package water.com.watertamagochiar.screens.weekly;

import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.controllers.BackPressListener;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;
import water.com.watertamagochiar.screens.summary.SummaryViewMvc;

public class WeeklyController implements WeeklyViewMvc.Listener, BackPressListener {

    private final ScreensNavigator mScreensNavigator;
    private final BackPressDispatcher mBackPressDispatcher;

    private WeeklyViewMvc mViewMvc;

    public WeeklyController(ScreensNavigator screensNavigator,  BackPressDispatcher backPressDispatcher) {
        mScreensNavigator = screensNavigator;
        mBackPressDispatcher = backPressDispatcher;
    }

    public void bindView(WeeklyViewMvc viewMvc){
        this.mViewMvc = viewMvc;
    }

    public void onStart(){
        mViewMvc.registerListener(this);
        mBackPressDispatcher.registerListener(this);
    }

    public void onResume(){
        mViewMvc.closeDrawer();
    }

    public void onStop(){
        mViewMvc.unregisterListener(this);
        mBackPressDispatcher.unregisterListener(this);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDrawerItemClicked(DrawerItems item) {
        switch (item) {
            case DAILY:
                mScreensNavigator.toMain();
                break;
            case WEEKLY:
                mViewMvc.closeDrawer();
                break;
            case SUMMARY:
                mScreensNavigator.toSummary();
                break;
            case AR:
                mScreensNavigator.toAR();
                break;
        }
    }
}
