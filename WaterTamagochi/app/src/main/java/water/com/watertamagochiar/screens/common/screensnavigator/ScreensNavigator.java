package water.com.watertamagochiar.screens.common.screensnavigator;

import water.com.watertamagochiar.HelloSceneformActivity;
import water.com.watertamagochiar.screens.about.AboutFragment;
import water.com.watertamagochiar.screens.common.fragmentframehelper.FragmentFrameHelper;
import water.com.watertamagochiar.screens.main.MainFragment;
import water.com.watertamagochiar.screens.summary.SummaryFragment;

public class ScreensNavigator {
    
    private final FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }

    public void toMain() {
        mFragmentFrameHelper.replaceFragment(MainFragment.newInstance());
    }

    public void toSummary() {
        mFragmentFrameHelper.replaceFragment(SummaryFragment.newInstance());
    }

    public void toWeekly() {

    }

    public void toAR() {
        mFragmentFrameHelper.startARActivity();
    }

//    public void toBarCodeInput() {
//        mFragmentFrameHelper.replaceFragmentAndClearBackstack(BarcodeInputFragment.newInstance());
//    }
//
//    public void toSettings() {
//        mFragmentFrameHelper.replaceFragment(SettingsFragment.newInstance());
//    }

    public void toAbout() {
        mFragmentFrameHelper.replaceFragment(AboutFragment.newInstance());
    }

//    public void toStockInfo(StockInfo stockInfo) {
//        mFragmentFrameHelper.replaceFragment(StockInfoListFragment.newInstance(stockInfo));
//    }

    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }
}
