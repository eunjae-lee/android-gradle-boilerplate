package net.eunjae.android.boilerplate.util;

import java.util.ArrayList;

public class StringUtil {

	public static boolean isDifferent(String str1, String str2) {
		return !equals(str1, str2);
	}

	public static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		} else if (str1 != null && str2 != null) {
			return str1.equals(str2);
		} else {
			return false;
		}
	}

	public static boolean equals(ArrayList<String> strings1, ArrayList<String> strings2) {
		int len1 = strings1 == null ? 0 : strings1.size();
		int len2 = strings2 == null ? 0 : strings2.size();
		if (len1 != len2) {
			return false;
		}
		if (len1 == 0 && len2 == 0) {
			return true;
		}
		for (int i = 0; i < strings1.size(); i++) {
			String string1 = strings1.get(i);
			String string2 = strings2.get(i);
			if (isDifferent(string1, string2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	public static boolean isNull(String str) {
		if (str == null || str.equals("null") || str.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public static String filterNull(String str) {
		return isNull(str) ? "" : str;
	}
}