package water.com.watertamagochiar.database;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesHelper {

    private static final String PREFERENCES = "WATER_TAMAGOCHI_PREFERENCES";

    private static final String FIRST_LAUNCH = "FIRST_LAUNCH";

    private Context mContext;

    public SharedPreferencesHelper(Context context) {
        mContext = context;
    }

    private SharedPreferences getSharedPreferences() {
        return mContext.getSharedPreferences(PREFERENCES, MODE_PRIVATE);
    }

    public void setFirstLaunch(boolean isFirstLaunch) {
        SharedPreferences.Editor prefEditor = getSharedPreferences().edit();
        prefEditor.putBoolean(FIRST_LAUNCH, isFirstLaunch);
        prefEditor.commit();
    }

    public boolean isFirstLaunch() {
        return getSharedPreferences().getBoolean(FIRST_LAUNCH, true);
    }

}
