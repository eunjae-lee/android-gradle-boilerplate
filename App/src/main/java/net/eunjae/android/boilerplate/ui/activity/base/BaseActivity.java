package net.eunjae.android.boilerplate.ui.activity.base;

import android.app.Activity;

public class BaseActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        VActivityLifeCycleHelper.onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        VActivityLifeCycleHelper.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        VActivityLifeCycleHelper.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        VActivityLifeCycleHelper.onStop(this);
    }
}
