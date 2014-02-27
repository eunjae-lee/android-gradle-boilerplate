package net.eunjae.android.boilerplate.util;

public class SnsUtil {
//	public static void shareWithKakaoTalk(Context context, Verse verse) {
//		ArrayList<Map<String, String>> metaInfoArray = new ArrayList<Map<String, String>>();
//
//		// If application is support Android platform.
//		Map<String, String> metaInfoAndroid = new Hashtable<String, String>(1);
//		metaInfoAndroid.put("os", "android");
//		metaInfoAndroid.put("devicetype", "phone");
//		metaInfoAndroid.put("installurl", "market://details?id=" + context.getPackageName());
//		metaInfoAndroid.put("executeurl", "sbverse://");
//
////		// If application is support ios platform.
////		Map<String, String> metaInfoIOS = new Hashtable<String, String>(1);
////		metaInfoIOS.put("os", "ios");
////		metaInfoIOS.put("devicetype", "phone");
////		metaInfoIOS.put("installurl", "your iOS app install url");
////		metaInfoIOS.put("executeurl", "kakaoLinkTest://startActivity");
//
//		// add to array
//		metaInfoArray.add(metaInfoAndroid);
////		metaInfoArray.add(metaInfoIOS);
//
//		// Recommended: Use application context for parameter.
//		KakaoLink kakaoLink = KakaoLink.getLink(context.getApplicationContext());
//
//		// check, intent is available.
//		if(!kakaoLink.isAvailableIntent())
//			return;
//
//		try {
//			kakaoLink.openKakaoAppLink(
//					(Activity) context,
//					"http://saltybulb.com/v",
//					"\n" + verse.generateTextForShare(),
//					context.getPackageName(),
//					context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName,
//					context.getString(R.string.app_name_with_desc),
//					"UTF-8",
//					metaInfoArray);
//		} catch (PackageManager.NameNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void shareWithKakaoStory(Context context, Verse verse) {
//		Intent intent = new Intent(Intent.ACTION_SEND);
//		intent.setType("text/plain");
//		intent.putExtra(Intent.EXTRA_TEXT, verse.generateTextForShareWithUrl());
//
//		// Kakao Story로 바로 보내시려면 아래 코드를 추가합니다.
//		intent.setPackage("com.kakao.story");
//		context.startActivity(intent);
//	}
//
//	public static void shareWithKakaoStory2(Context context, Verse verse) {
//		ArrayList<Map<String, String>> metaInfoArray = new ArrayList<Map<String, String>>();
//
//		// If application is support Android platform.
//		Map<String, String> metaInfoAndroid = new Hashtable<String, String>(1);
//		metaInfoAndroid.put("os", "android");
//		metaInfoAndroid.put("devicetype", "phone");
//		metaInfoAndroid.put("installurl", "market://details?id=" + context.getPackageName());
//		metaInfoAndroid.put("executeurl", "sbverse://");
//
////		// If application is support ios platform.
////		Map<String, String> metaInfoIOS = new Hashtable<String, String>(1);
////		metaInfoIOS.put("os", "ios");
////		metaInfoIOS.put("devicetype", "phone");
////		metaInfoIOS.put("installurl", "your iOS app install url");
////		metaInfoIOS.put("executeurl", "kakaoLinkTest://startActivity");
//
//		// add to array
//		metaInfoArray.add(metaInfoAndroid);
////		metaInfoArray.add(metaInfoIOS);
//
//		// Recommended: Use application context for parameter.
//		StoryLink storyLink = StoryLink.getLink(context.getApplicationContext());
//
//		// check, intent is available.
//		if(!storyLink.isAvailableIntent())
//			return;
//
//		Map<String, Object> urlInfoAndroid = new Hashtable<String, Object>(1);
//		urlInfoAndroid.put("title", verse.getWhere());
//		urlInfoAndroid.put("desc", verse.generateTextForShare());
//		urlInfoAndroid.put("imageurl", new String[] {verse.getImgUrl()});
//		urlInfoAndroid.put("type", "article");
//
//		try {
//			storyLink.openKakaoLink(
//					(Activity) context,
//					"\n" + verse.generateTextForShare(),
//					context.getPackageName(),
//					context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName,
//					context.getString(R.string.app_name_with_desc),
//					"UTF-8",
//					urlInfoAndroid);
//		} catch (PackageManager.NameNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void shareWithFacebook(Activity context, Verse verse) {
//		Intent intent = new Intent(Intent.ACTION_SEND);
//		intent.setType("text/plain");
//		intent.putExtra(Intent.EXTRA_TEXT, verse.generateTextForShareWithUrl());
//
//		intent.setPackage("com.facebook.katana");
//		context.startActivity(intent);
//	}
}
