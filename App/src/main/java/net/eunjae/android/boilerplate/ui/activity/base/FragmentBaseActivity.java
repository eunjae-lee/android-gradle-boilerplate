package net.eunjae.android.boilerplate.ui.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import net.eunjae.android.boilerplate.ui.fragment.SimplePlaceholderFragment;

public class FragmentBaseActivity extends FragmentActivity {

    protected void setActivityFragment(Bundle savedInstanceState, int containerResId, int layoutResId) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(containerResId, new SimplePlaceholderFragment(layoutResId))
                    .commit();
        }
    }

    protected void setActivityFragment(Bundle savedInstanceState, int containerResId, Fragment fragment) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(containerResId, fragment)
                    .commit();
        }
    }

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
