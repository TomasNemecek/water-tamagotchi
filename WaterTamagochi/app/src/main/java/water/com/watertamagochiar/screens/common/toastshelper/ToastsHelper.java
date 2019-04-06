package water.com.watertamagochiar.screens.common.toastshelper;

import android.content.Context;
import android.widget.Toast;

import water.com.watertamagochiar.R;

public class ToastsHelper {


    private final Context mContext;

    public ToastsHelper(Context context) {
        mContext = context;
    }

    public void showUseCaseError() {
        Toast.makeText(mContext, R.string.general_error, Toast.LENGTH_LONG).show();
    }

//    public void showItemNotFound() {
//        Toast.makeText(mContext, R.string.item_not_found, Toast.LENGTH_LONG).show();
//    }
//
//    public void showNoUnitsInWarehouse() {
//        Toast.makeText(mContext, R.string.no_units_in_warehouse, Toast.LENGTH_LONG).show();
//    }
//
//    public void onCancelledScan() {
//        Toast.makeText(mContext, R.string.cancelled_scan, Toast.LENGTH_LONG).show();
//    }
//
//    public void showEmptyUrl() {
//        Toast.makeText(mContext, R.string.fill_in_api_data, Toast.LENGTH_LONG).show();
//    }
//
//    public void showEmptyLogin() {
//        Toast.makeText(mContext, R.string.fill_in_login, Toast.LENGTH_LONG).show();
//    }
//
//    public void showConnectionSettingsSet() {
//        Toast.makeText(mContext, R.string.connection_settings_set, Toast.LENGTH_LONG).show();
//    }
//
//    public void showTestApiCallSuccess() {
//        Toast.makeText(mContext, R.string.connection_successful, Toast.LENGTH_LONG).show();
//    }
//
//    public void showWarehousesRefreshed() {
//        Toast.makeText(mContext, R.string.warehouse_refreshed, Toast.LENGTH_LONG).show();
//    }
}
