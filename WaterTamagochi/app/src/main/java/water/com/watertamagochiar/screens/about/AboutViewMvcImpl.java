package water.com.watertamagochiar.screens.about;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import water.com.watertamagochiar.BuildConfig;
import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.ToolBarViewMvc;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.navdrawer.BaseNavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;

public class AboutViewMvcImpl extends BaseNavDrawerViewMvc<AboutViewMvc.Listener> implements AboutViewMvc {

    private final ToolBarViewMvc mToolBarViewMvc;
    private final Toolbar mToolbar;

    private final TextView mTxtBuild;

    public AboutViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);
        setRootView(inflater.inflate(R.layout.layout_about, parent, false));

        mTxtBuild = findViewById(R.id.txt_version);
        setVersionText();

        mToolbar = findViewById(R.id.toolbar);
        mToolBarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolbar);
        initToolBar();
    }

    private void initToolBar(){
        mToolbar.addView(mToolBarViewMvc.getRootView());;
        mToolBarViewMvc.enableHamburgerButtonAndListen(new ToolBarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                openDrawer();
            }
        });
    }

    private void setVersionText() {
        String version = getContext().getString(R.string.version) + " " + BuildConfig.VERSION_NAME + " (" + BuildConfig.VERSION_CODE + ")";
        mTxtBuild.setText(version);
    }

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for(Listener listener : getListeners()) {
            listener.onDrawerItemClicked(item);
        }
    }
}
