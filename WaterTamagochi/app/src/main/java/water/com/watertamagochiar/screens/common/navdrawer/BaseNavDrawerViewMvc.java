package water.com.watertamagochiar.screens.common.navdrawer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.views.BaseObservableViewMvc;

public abstract class BaseNavDrawerViewMvc<ListernerType> extends BaseObservableViewMvc<ListernerType>
            implements NavDrawerViewMvc {

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;

    public BaseNavDrawerViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        super.setRootView(inflater.inflate(R.layout.layout_drawer, parent, false));

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
//                if(menuItem.getItemId() == R.id.drawer_menu_barcode_input) {
//                    onDrawerItemClicked(DrawerItems.BARCODE_INPUT);
//                } else if(menuItem.getItemId() == R.id.drawer_menu_settings) {
//                    onDrawerItemClicked(DrawerItems.SETTINGS);
//                } else
//
                 if(menuItem.getItemId() == R.id.daily) {
                    onDrawerItemClicked(DrawerItems.DAILY);
                 } else if(menuItem.getItemId() == R.id.weekly) {
                     onDrawerItemClicked(DrawerItems.WEEKLY);
                 } else if(menuItem.getItemId() == R.id.summary) {
                     onDrawerItemClicked(DrawerItems.SUMMARY);
                 } else if(menuItem.getItemId() == R.id.forrest) {
                     onDrawerItemClicked(DrawerItems.AR);
                 }
                return false;
            }
        });
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    protected abstract void onDrawerItemClicked(DrawerItems item);

    @Override
    protected void setRootView(View rootView) {
        mFrameLayout.addView(rootView);
    }
}
