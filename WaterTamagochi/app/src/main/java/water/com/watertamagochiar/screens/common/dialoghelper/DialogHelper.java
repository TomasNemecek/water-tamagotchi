package water.com.watertamagochiar.screens.common.dialoghelper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import water.com.watertamagochiar.R;


public class DialogHelper {

    private final Context mContext;

    public DialogHelper(Context context) {
        mContext = context;
    }

//    public void showAlertUnsuccessfulConnection() {
//        getBasicAlertDialog(mContext.getString(R.string.connection_unsuccessful), mContext.getString(R.string.check_url_port)).show();
//    }
//
//    public void showAlertUnsuccessfulConnectionBadLogin() {
//        getBasicAlertDialog(mContext.getString(R.string.connection_unsuccessful), mContext.getString(R.string.check_login)).show();
//    }
//
//    public void showItemNotFound() {
//        getBasicAlertDialog(mContext.getString(R.string.item_not_found), null).show();
//    }
//
//    public void showNoUnitsInWarehouse() {
//        getBasicAlertDialog(mContext.getString(R.string.no_units_in_warehouse), null).show();
//    }
//
//    public void showAlertCouldNotLoadWarehouses() {
//        getBasicAlertDialog(mContext.getString(R.string.could_not_load_warehouses), null).show();
//    }
//
//    public void showAlertCouldNotRefreshWarehouses() {
//        getBasicAlertDialog(mContext.getString(R.string.warehouse_not_refreshed), null).show();
//    }

    private AlertDialog getBasicAlertDialog(String title, String message) {
        return new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
