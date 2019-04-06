package water.com.watertamagochiar.screens.main;

import water.com.watertamagochiar.screens.common.navdrawer.NavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.views.ObservableViewMvc;

public interface MainViewMvc extends ObservableViewMvc<MainViewMvc.Listener>, NavDrawerViewMvc {

    interface Listener {
        void onGoToARClicked();
    }
}
