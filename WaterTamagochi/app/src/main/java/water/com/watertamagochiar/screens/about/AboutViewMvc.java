package water.com.watertamagochiar.screens.about;

import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.navdrawer.NavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.views.ObservableViewMvc;

public interface AboutViewMvc extends ObservableViewMvc<AboutViewMvc.Listener>, NavDrawerViewMvc {

    interface Listener {
        void onDrawerItemClicked(DrawerItems item);
    }
}
