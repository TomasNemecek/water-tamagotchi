package water.com.watertamagochiar.screens.weekly;

import water.com.watertamagochiar.common.BaseObservable;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.navdrawer.NavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.views.ObservableViewMvc;

public interface WeeklyViewMvc extends ObservableViewMvc<WeeklyViewMvc.Listener>, NavDrawerViewMvc {

    interface Listener {
        void onDrawerItemClicked(DrawerItems item);
    }
}
