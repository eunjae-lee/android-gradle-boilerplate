package net.eunjae.android.boilerplate.core;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EBean
public class PrefHelper {

    @Pref
    Prefs_ prefs;
}
