package net.eunjae.android.boilerplate.ui.activity;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.parse.ParseAnalytics;
import net.eunjae.android.boilerplate.BuildConfig;
import net.eunjae.android.boilerplate.R;
import net.eunjae.android.boilerplate.core.Const;
import net.eunjae.android.boilerplate.core.PrefHelper;
import net.eunjae.android.boilerplate.ui.activity.base.BaseFragmentActivity;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseFragmentActivity {

    @Bean
    PrefHelper prefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initThirdParty();
        setActivityFragment(savedInstanceState, R.id.container, R.layout.fragment_main);
    }

    private void initThirdParty() {
        ParseAnalytics.trackAppOpened(getIntent());
        if (Const.USE_CRASHLYTICS && BuildConfig.buildType.isRelease()) {
            Crashlytics.start(this);
        }
    }

    private void showDialogFragment(DialogFragment dialogFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment.show(ft, "dialog");
    }

    private void hideDialogFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev;
        prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        ft.commit();
    }
}
