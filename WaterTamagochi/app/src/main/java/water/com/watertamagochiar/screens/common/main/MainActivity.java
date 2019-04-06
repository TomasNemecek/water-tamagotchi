package water.com.watertamagochiar.screens.common.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import water.com.watertamagochiar.R;
import water.com.watertamagochiar.screens.common.controllers.BackPressDispatcher;
import water.com.watertamagochiar.screens.common.controllers.BackPressListener;
import water.com.watertamagochiar.screens.common.controllers.BaseActivity;
import water.com.watertamagochiar.screens.common.fragmentframehelper.FragmentFrameWrapper;
import water.com.watertamagochiar.screens.common.screensnavigator.ScreensNavigator;


public class MainActivity extends BaseActivity implements BackPressDispatcher, FragmentFrameWrapper {

    private static final int WRITE_STORAGE_PERM = 123;

    public static void startClearTop(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    private Set<BackPressListener> mBackPressListeners = new HashSet<>();
    private ScreensNavigator mScreensNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_content_frame);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();

        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_STORAGE_PERM);
        } else {

            if (savedInstanceState == null) {
                mScreensNavigator.toMain();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == WRITE_STORAGE_PERM) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Write storage permission permission granted", Toast.LENGTH_LONG).show();
                mScreensNavigator.toMain();
            } else {
                Toast.makeText(this, "Write storage permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }//end onRequestPermissionsResult

    @Override
    public void onBackPressed() {
        boolean isBackPressedConsumedByListener = false;
        for (BackPressListener listener : mBackPressListeners) {
            if (listener.onBackPressed()) {
                isBackPressedConsumedByListener = true;
            }
        }
        if (!isBackPressedConsumedByListener) {
            super.onBackPressed();
        }
    }

    @Override
    public void registerListener(BackPressListener listener) {
        mBackPressListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressListener listener) {
        mBackPressListeners.remove(listener);
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return findViewById(R.id.frame_content);
    }
}
