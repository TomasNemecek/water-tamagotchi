package water.com.watertamagochiar.screens.summary;

import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;
import water.com.watertamagochiar.screens.common.navdrawer.NavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.views.ObservableViewMvc;

public interface SummaryViewMvc extends ObservableViewMvc<SummaryViewMvc.Listener>, NavDrawerViewMvc {

    interface Listener {
        void onDrawerItemClicked(DrawerItems item);

        void onShowerClicked();
        void onDishesClicked();
        void onLaundryClicked();

        void onAppleClicked();
        void onCricketClicked();
        void onChickenClicked();
    }

    void setText(String text);

}
