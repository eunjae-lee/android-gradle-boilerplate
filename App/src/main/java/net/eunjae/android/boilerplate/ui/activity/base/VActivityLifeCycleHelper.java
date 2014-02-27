package net.eunjae.android.boilerplate.ui.activity.base;

import android.app.Activity;

import com.flurry.android.FlurryAgent;
import com.google.analytics.tracking.android.EasyTracker;

import net.eunjae.android.aevent.manager.AEventManager;
import net.eunjae.android.aevent.manager.AStickyEventManager;

public class VActivityLifeCycleHelper {

    public static void onStart(Activity activity) {
        EasyTracker.getInstance(activity).activityStart(activity);
        FlurryAgent.onStartSession(activity, "???");   // FIXME
    }

    public static void onResume(Activity activity) {
        AStickyEventManager.getInstance().firePendingEvents(activity);
        AEventManager.getInstance().register(activity);
    }

    public static void onPause(Activity activity) {
        AEventManager.getInstance().unregister(activity);
    }

    public static void onStop(Activity activity) {
        EasyTracker.getInstance(activity).activityStop(activity);
        FlurryAgent.onEndSession(activity);
    }
}
