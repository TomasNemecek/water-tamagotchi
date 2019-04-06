package water.com.watertamagochiar.screens.about;


import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.controllers.BackPressListener;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;

public class AboutController implements AboutViewMvc.Listener, BackPressListener {

    private final ScreensNavigator mScreensNavigator;
    private final BackPressDispatcher mBackPressDispatcher;

    private AboutViewMvc mViewMvc;

    public AboutController(ScreensNavigator screensNavigator, BackPressDispatcher backPressDispatcher) {
        mScreensNavigator = screensNavigator;
        mBackPressDispatcher = backPressDispatcher;
    }

    public void bindView(AboutViewMvc viewMvc){
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
    public void onDrawerItemClicked(DrawerItems item) {
//        switch (item) {
//            case BARCODE_INPUT:
//                mScreensNavigator.toBarCodeInput();
//                break;
//            case SETTINGS:
//                mScreensNavigator.toSettings();
//                break;
//        }
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
