package net.eunjae.android.boilerplate.util;

import android.content.Context;

import net.eunjae.android.boilerplate.core.MyApplication_;

public class StringTemplate {

	private String template = "";

	public StringTemplate(int stringResourceId) {
		Context context = MyApplication_.getInstance().getApplicationContext();
		this.template = context.getResources().getString(stringResourceId);
	}

	public String eval(Object ... values) {
		if (values == null || values.length == 0) {
			return template;
		}

		String str = template;
		try {
			for (Object value : values) {
				str = str.replaceFirst("\\{#\\}", value.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public String evalWithOrder(Object ... values) {
		String str = null;
		try {
			if (values == null || values.length == 0) {
				return template;
			}

			str = template;
			int idx = 1;
			for (Object value : values) {
				str = str.replaceFirst("\\{#" + idx + "\\}", value.toString());
				idx += 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
