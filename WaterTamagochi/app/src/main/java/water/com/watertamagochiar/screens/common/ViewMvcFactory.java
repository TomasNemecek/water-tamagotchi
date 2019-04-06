package water.com.watertamagochiar.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import water.com.watertamagochiar.screens.about.AboutViewMvc;
import water.com.watertamagochiar.screens.about.AboutViewMvcImpl;
import water.com.watertamagochiar.screens.main.MainViewMvc;
import water.com.watertamagochiar.screens.main.MainViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public MainViewMvc getMainViewMvc(@Nullable ViewGroup parent) {
        return new MainViewMvcImpl(mLayoutInflater, parent, this);
    }

    public AboutViewMvc getAboutViewMvc(@Nullable ViewGroup parent){
        return new AboutViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolBarViewMvc getToolBarViewMvc(@Nullable ViewGroup parent) {
        return new ToolBarViewMvc(mLayoutInflater, parent);
    }
}
