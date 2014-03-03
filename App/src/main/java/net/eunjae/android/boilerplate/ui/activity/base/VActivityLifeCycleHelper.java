package net.eunjae.android.boilerplate.ui.activity.base;

import android.app.Activity;

import com.flurry.android.FlurryAgent;
import com.google.analytics.tracking.android.EasyTracker;

import net.eunjae.android.aevent.manager.AEventManager;
import net.eunjae.android.aevent.manager.AStickyEventManager;
import net.eunjae.android.boilerplate.core.Const;

public class VActivityLifeCycleHelper {

    public static void onStart(Activity activity) {
		if (Const.USE_GOOGLE_ANALYTICS) {
			EasyTracker.getInstance(activity).activityStart(activity);
		}
		if (Const.USE_FLURRY) {
			FlurryAgent.onStartSession(activity, "???");   // FIXME
		}
	}

    public static void onResume(Activity activity) {
        AStickyEventManager.getInstance().firePendingEvents(activity);
        AEventManager.getInstance().register(activity);
    }

    public static void onPause(Activity activity) {
        AEventManager.getInstance().unregister(activity);
    }

    public static void onStop(Activity activity) {
		if (Const.USE_GOOGLE_ANALYTICS) {
			EasyTracker.getInstance(activity).activityStop(activity);
		}
		if (Const.USE_FLURRY) {
			FlurryAgent.onEndSession(activity);
		}
	}
}
