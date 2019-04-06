package water.com.watertamagochiar.common.di;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import water.com.watertamagochiar.database.SharedPreferencesHelper;
import water.com.watertamagochiar.screens.about.AboutController;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.dialoghelper.DialogHelper;
import water.com.watertamagochiar.screens.common.fragmentframehelper.FragmentFrameHelper;
import water.com.watertamagochiar.screens.common.fragmentframehelper.FragmentFrameWrapper;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;
import water.com.watertamagochiar.screens.common.toastshelper.ToastsHelper;
import water.com.watertamagochiar.screens.main.MainController;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private FragmentActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        this.mCompositionRoot = compositionRoot;
        this.mActivity = activity;
    }

    public FragmentActivity getActivity() {
        return mActivity;
    }

    private Context getContext() {
        return mActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private SharedPreferencesHelper getSharedPreferencesHelper() {
        return mCompositionRoot.getSharedPreferencesHelper(getContext());
    }

    private LayoutInflater getLayoutInflator(){
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflator());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }
//
//    public BarcodeInputController getBarcodeInputController(BaseFragment fragment){
//        return new BarcodeInputController(fragment, getFetchItemInfoUseCase(), getFetchStockInfoUseCase(), getLoadWarehousesFromDatabaseUseCase(), getInsertWarehousesIntoDatabaseUseCase(), getSharedPreferencesHelper(), getScreensNavigator(), getToastHelper(), getDialogHelper(), getBackPressDispatcher());
//    }
//
//    public SettingsController getSettingsController(){
//        return new SettingsController(getTestApiCallUseCase(), getFetchWarehouseUseCase(), getInsertWarehousesIntoDatabaseUseCase(), getSharedPreferencesHelper(), getScreensNavigator(), getToastHelper(), getDialogHelper(), getBackPressDispatcher());
//    }

    public MainController getMainController(){
        return new MainController(getScreensNavigator(), getBackPressDispatcher());
    }

    public AboutController getAboutController(){
        return new AboutController(getScreensNavigator(), getBackPressDispatcher());
    }

//    public StockInfoListController getStockInfoListController(){
//        return new StockInfoListController(getScreensNavigator(), getToastHelper(), getBackPressDispatcher());
//    }

    private BackPressDispatcher getBackPressDispatcher() {
        return (BackPressDispatcher) getActivity();
    }

    private DialogHelper getDialogHelper() {
        return new DialogHelper(getContext());
    }

    private ToastsHelper getToastHelper() {
        return new ToastsHelper(getContext());
    }

//    private FetchItemInfoUseCase getFetchItemInfoUseCase() {
//        return new FetchItemInfoUseCase(getGreenCenterApi());
//    }
//
//    private FetchStockInfoUseCase getFetchStockInfoUseCase() {
//        return new FetchStockInfoUseCase(getGreenCenterApi());
//    }
//
//    private TestApiCallUseCase getTestApiCallUseCase() {
//        return new TestApiCallUseCase(getGreenCenterApi());
//    }
//
//    private FetchWarehousesUseCase getFetchWarehouseUseCase() {
//        return new FetchWarehousesUseCase(getGreenCenterApi());
//    }
//
//    private LoadWarehousesFromDatabaseUseCase getLoadWarehousesFromDatabaseUseCase() {
//        return new LoadWarehousesFromDatabaseUseCase(getWarehouseDao());
//    }
//
//    private InsertWarehousesIntoDatabaseUseCase getInsertWarehousesIntoDatabaseUseCase() {
//        return new InsertWarehousesIntoDatabaseUseCase(getWarehouseDao());
//    }

}
