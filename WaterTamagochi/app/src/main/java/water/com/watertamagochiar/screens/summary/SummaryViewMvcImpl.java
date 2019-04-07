package water.com.watertamagochiar.screens.summary;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.ToolBarViewMvc;
import water.com.watertamagochiar.screens.common.ViewMvcFactory;
import water.com.watertamagochiar.screens.common.navdrawer.BaseNavDrawerViewMvc;
import water.com.watertamagochiar.screens.common.navdrawer.DrawerItems;

public class SummaryViewMvcImpl extends BaseNavDrawerViewMvc<SummaryViewMvc.Listener> implements SummaryViewMvc  {

    private final ToolBarViewMvc mToolBarViewMvc;
    private final Toolbar mToolBar;

    private final TextView mTextView;

    private final ImageButton mBtnApple;
    private final ImageButton mBtnCricket;
    private final ImageButton mBtnChicken;
    private final ImageButton mBtnShower;
    private final ImageButton mBtnDishes;
    private final ImageButton mBtnLaundry;

    public SummaryViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);
        setRootView(inflater.inflate(R.layout.layout_summary, parent, false));

        mToolBar = findViewById(R.id.toolbar);
        mTextView = findViewById(R.id.text_func);
        mToolBarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolBar);
        initToolbar();

        mBtnApple = findViewById(R.id.img_apple);
        mBtnCricket = findViewById(R.id.img_cricket);
        mBtnChicken = findViewById(R.id.img_chicken);
        mBtnShower = findViewById(R.id.img_shower);
        mBtnDishes = findViewById(R.id.img_dishes);
        mBtnLaundry = findViewById(R.id.img_laundry);

        mBtnApple.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onAppleClicked();
            }
        });

        mBtnCricket.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onCricketClicked();
            }
        });

        mBtnChicken.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onChickenClicked();
            }
        });

        mBtnShower.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onShowerClicked();
            }
        });

        mBtnDishes.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onDishesClicked();
            }
        });

        mBtnLaundry.setOnClickListener(view -> {
            for(Listener listener : getListeners()) {
                listener.onLaundryClicked();
            }
        });
    }

    private void initToolbar() {
        mToolBarViewMvc.setTitle(getContext().getString(R.string.summary_title));
        mToolBar.addView(mToolBarViewMvc.getRootView());
        mToolBarViewMvc.enableHamburgerButtonAndListen(this::openDrawer);
    }

    @Override
    public void setText(String text) {
        mTextView.setText(text);
    }

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for(SummaryViewMvc.Listener listener : getListeners()) {
            listener.onDrawerItemClicked(item);
        }
    }

}
