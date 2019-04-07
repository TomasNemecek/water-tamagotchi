package water.com.watertamagochiar.screens.summary;

import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.controllers.BackPressListener;
import water.com.watertamagochiar.screens.common.dialoghelper.DialogHelper;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;

public class SummaryController implements SummaryViewMvc.Listener, BackPressListener {

    private final ScreensNavigator mScreensNavigator;
    private final BackPressDispatcher mBackPressDispatcher;
    private final DialogHelper mDialogHelper;

    private SummaryViewMvc mViewMvc;

    public SummaryController(ScreensNavigator screensNavigator, BackPressDispatcher backPressDispatcher, DialogHelper dialogHelper) {
        mScreensNavigator = screensNavigator;
        mBackPressDispatcher = backPressDispatcher;
        mDialogHelper = dialogHelper;
    }
    public void bindView(SummaryViewMvc viewMvc){
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
    public void onShowerClicked() {
        mDialogHelper.showAlertDecreaseShower();
    }

    @Override
    public void onDishesClicked() {
        mDialogHelper.showAlertDecreaseDishwashing();
    }

    @Override
    public void onLaundryClicked() {
        mDialogHelper.showAlertDecreaseWashingMachine();
    }

    @Override
    public void onDrawerItemClicked(DrawerItems item) {
        switch (item) {
            case DAILY:
                mScreensNavigator.toMain();
                break;
            case WEEKLY:
                mScreensNavigator.toWeekly();
                break;
            case SUMMARY:
                mViewMvc.closeDrawer();
                break;
            case AR:
                mScreensNavigator.toAR();
                break;
        }
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
