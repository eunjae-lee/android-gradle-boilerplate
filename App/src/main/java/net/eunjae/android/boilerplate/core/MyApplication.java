package net.eunjae.android.boilerplate.core;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;
import net.eunjae.android.boilerplate.BuildConfig;

import net.eunjae.android.boilerplate.ui.activity.SplashActivity_;
import org.androidannotations.annotations.EApplication;

import java.io.File;

@EApplication
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // FIXME
		if (Const.USE_PARSE_PUSH) {
			Parse.initialize(this, "???", "???");
			PushService.setDefaultPushCallback(this, SplashActivity_.class);
			PushService.subscribe(this, BuildConfig.buildType.toString().toLowerCase(), SplashActivity_.class);
			ParseInstallation.getCurrentInstallation().saveInBackground();
		}

		File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .discCache(new UnlimitedDiscCache(cacheDir))
                .build();
        ImageLoader.getInstance().init(config);
    }
}
