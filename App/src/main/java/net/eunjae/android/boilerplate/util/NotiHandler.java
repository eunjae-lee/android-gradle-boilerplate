package net.eunjae.android.boilerplate.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import net.eunjae.android.boilerplate.core.Const;
import net.eunjae.android.boilerplate.core.event.FlurryEvent;
import net.eunjae.android.boilerplate.core.event.constants.F;
import org.json.JSONObject;

public class NotiHandler {
	private static final String DATA_KEY = "com.parse.Data";

	private static final String TYPE_URL_LINK = "url_link";
	private static final String TYPE_APP_LAUNCH = "app_launch";

	public static void handle(final Activity activity, HandleListener handleListener) {
		Intent data = activity.getIntent();

		if (hasNotiData(data)) {
			String json = data.getStringExtra(DATA_KEY);
			try {
				JSONObject jsonObj = new JSONObject(json);
				JSONObject dataObj = jsonObj.getJSONObject("data");
				String type = dataObj.optString("type");
				String code = dataObj.optString("code");
				if (Const.USE_FLURRY) {
					new FlurryEvent(F.PUSH_HANDLED).param("code", code).param("type", type).log();
				}
				handleTypes(activity, type, dataObj, handleListener);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		handleListener.notHandled();
	}

	private static void handleTypes(final Activity activity, String type, JSONObject dataObj, HandleListener handleListener) {
		if (type == null) {
			handleListener.notHandled();
			return;
		}

		if (type.equals(TYPE_URL_LINK)) {
			String url = dataObj.optString("url");
			String url2 = dataObj.optString("url2");
			try {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				activity.startActivity(intent);
				activity.finish();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(url2));
					activity.startActivity(intent);
					activity.finish();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (type.equals(TYPE_APP_LAUNCH)) {
			handleListener.requestToLaunchApp();
		} else {
			handleListener.notHandled();
		}
	}

	private static boolean hasNotiData(Intent data) {
		return data != null && data.getStringExtra(DATA_KEY) != null;
	}

	public interface HandleListener {
		public void notHandled();
		public void requestToLaunchApp();
	}
}
