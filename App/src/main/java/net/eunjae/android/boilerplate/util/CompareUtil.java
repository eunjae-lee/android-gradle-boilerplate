package net.eunjae.android.boilerplate.util;

public class CompareUtil {
	public static boolean isSame(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj1 != null && obj2 != null) {
			return obj1.equals(obj2);
		} else {
			return false;
		}
	}

	public static boolean isSame(Object[] obj1, Object[] obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj1 != null && obj2 != null) {
			if (obj1.length == obj2.length) {
				for (int i = 0; i < obj1.length; i++) {
					if (!obj1[i].equals(obj2[i])) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
