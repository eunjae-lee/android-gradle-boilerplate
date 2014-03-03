package net.eunjae.android.boilerplate.ui.activity;

import android.os.Bundle;

import net.eunjae.android.boilerplate.R;
import net.eunjae.android.boilerplate.core.Const;
import net.eunjae.android.boilerplate.ui.activity.base.BaseFragmentActivity;

import net.eunjae.android.boilerplate.util.NotiHandler;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityFragment(savedInstanceState, R.id.container, R.layout.fragment_splash);
		handleNotification();
	}

	private void handleNotification() {
		if (Const.USE_PARSE_PUSH) {
			NotiHandler.handle(this, new NotiHandler.HandleListener() {

				@Override
				public void notHandled() {

				}

				@Override
				public void requestToLaunchApp() {

				}
			});
		}
	}
}
