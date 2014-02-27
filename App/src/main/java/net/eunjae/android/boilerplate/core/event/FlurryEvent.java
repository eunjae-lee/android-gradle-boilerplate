package net.eunjae.android.boilerplate.core.event;

import com.flurry.android.FlurryAgent;
import net.eunjae.android.boilerplate.BuildConfig;

import java.util.HashMap;
import java.util.Map;

public class FlurryEvent {
	private final String flurryEventName;
	private Map<String, String> params;

	public FlurryEvent(String flurryEventName) {
		this.flurryEventName = flurryEventName;
	}

	public FlurryEvent param(String key, String value) {
		if (params == null) {
			params = new HashMap<String, String>();
		}
		params.put(key, value);
		return this;
	}

	public FlurryEvent param(String key, int value) {
		return param(key, String.valueOf(value));
	}

	public FlurryEvent param(String key, long value) {
		return param(key, String.valueOf(value));
	}

	public void log() {
		if (!BuildConfig.buildType.isRelease()) {
			return;
		}
		if (params == null) {
			FlurryAgent.logEvent(flurryEventName);
		} else {
			FlurryAgent.logEvent(flurryEventName, params);
		}
	}
}
