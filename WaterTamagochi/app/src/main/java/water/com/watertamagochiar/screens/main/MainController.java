package water.com.watertamagochiar.screens.main;

import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.controllers.BackPressListener;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;

public class MainController implements MainViewMvc.Listener, BackPressListener {

    private final ScreensNavigator mScreensNavigator;
    private final BackPressDispatcher mBackPressDispatcher;

    private MainViewMvc mViewMvc;

    public MainController(ScreensNavigator screensNavigator, BackPressDispatcher backPressDispatcher) {
        mScreensNavigator = screensNavigator;
        mBackPressDispatcher = backPressDispatcher;
    }


    public void bindView(MainViewMvc viewMvc){
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
    public void onGoToARClicked() {
        mScreensNavigator.toAR();
    }

    @Override
    public boolean onBackPressed() {
        if (mViewMvc.isDrawerOpen()) {
            mViewMvc.closeDrawer();
            return true;
        } else {
            return false;
        }
    }
}
