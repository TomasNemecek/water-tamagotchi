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

    private String text = "You are awesome! You saved 1400 liters this month, that is equivalent to ";

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
        mViewMvc.setText("An average 5 minute shower uses 6 liters of water per minute. Your showers this month took on average 17.5 minutes. Every minute counts!");
    }

    @Override
    public void onDishesClicked() {
        mViewMvc.setText("An average dishwasher load uses 15 liters of water. You used your dishwasher 12 times this month. Every dish counts!");
    }

    @Override
    public void onLaundryClicked() {
        mViewMvc.setText("An average laundry machine load uses 75 liters of water. You used your dishwasher 6 times this month. Every load counts!");
    }

    @Override
    public void onAppleClicked() {
        mViewMvc.setText(text + " 6 Apples ");
    }

    @Override
    public void onCricketClicked() {
        mViewMvc.setText(text + " 7,5 Million Grasshoppers ");
    }

    @Override
    public void onChickenClicked() {
        mViewMvc.setText(text + " 3 chicken legs ");
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
