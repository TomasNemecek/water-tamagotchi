package water.com.watertamagochiar.common.views;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

public class MaterialSpinner extends AppCompatSpinner {

    public interface OnSpinnerEventsListener {
        void onSpinnerOpened();
        void onSpinnerClosed(int position, Object selectedObject);
    }

    private static final String TAG = "CustomSpinner";

    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated = false;

    public MaterialSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public MaterialSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MaterialSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialSpinner(Context context, int mode) {
        super(context, mode);
    }

    public MaterialSpinner(Context context) {
        super(context);
    }

    @Override
    public boolean performClick() {
        // register that the Spinner was opened so we have a status
        // indicator for the activity(which may lose focus for some other
        // reasons)
        mOpenInitiated = true;
        if (mListener != null) {
            mListener.onSpinnerOpened();
        }
        return super.performClick();
    }

    public void setSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        mListener = onSpinnerEventsListener;
    }

    /**
     * Propagate the closed Spinner event to the listener from outside.
     */
    public void performClosedEvent() {
        mOpenInitiated = false;
        if (mListener != null) {
            mListener.onSpinnerClosed(getSelectedItemPosition(), getSelectedItem());
        }
    }

    /**
     * A boolean flag indicating that the Spinner triggered an open event.
     *
     * @return true for opened Spinner
     */
    public boolean hasBeenOpened() {
        return mOpenInitiated;
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        android.util.Log.d(TAG, "onWindowFocusChanged");
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasBeenOpened() && hasWindowFocus) {
            android.util.Log.i(TAG, "closing popup");
            performClosedEvent();
        }
    }
}
