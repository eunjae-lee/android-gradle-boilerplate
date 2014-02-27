package net.eunjae.android.boilerplate.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import net.eunjae.android.boilerplate.R;
import net.eunjae.android.boilerplate.ui.activity.StartActivity_;

public class NotificationUtil {

    public static void showNotification(Context context) {
		Context applicationContext = context.getApplicationContext();
		Intent intent = new Intent(applicationContext, StartActivity_.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(applicationContext, 0,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);

		String title = "title";//context.getString(R.string.noti_alarm_title);
		String message = "message";//context.getString(R.string.noti_alarm_message);
		Notification noti = new NotificationCompat.Builder(applicationContext)
				.setContentTitle(title)
				.setContentText(message)
				.setAutoCancel(true)
				.setOngoing(true)
				.setSmallIcon(R.drawable.ic_launcher)
				.setTicker(message)
				.setContentIntent(pendingIntent)
				.build();
		noti.flags |= Notification.FLAG_AUTO_CANCEL;
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(1, noti);

		doSoundAndVibrationIfNeed(context);
	}

    public static void doSoundAndVibrationIfNeed(Context context) {
        if (isUseVibration(context)) {
            try {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                long[] pattern = {0, 300, 50, 100, 20, 50};
                vibrator.vibrate(pattern, -1);
            } catch (Exception e) {}
        }

        if (isUseSound(context)) {
            try {
                Uri notiRingtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(context, notiRingtoneUri);
                ringtone.play();
            } catch (Exception e) {}
        }
    }

    private static boolean isUseSound(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager != null && audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
    }

    private static boolean isUseVibration(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager != null && audioManager.getRingerMode() != AudioManager.RINGER_MODE_SILENT;
    }
}
