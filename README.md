# Configurations
## Google Analytics
	* values/analytics.xml
  
		<?xml version="1.0" encoding="utf-8" ?>
		<resources
			xmlns:tools="http://schemas.android.com/tools"
			tools:ignore="TypographyDashes">
	
			<!--Replace placeholder ID with your tracking ID-->
			<string name="ga_trackingId">???</string>
	
			<!--Enable automatic activity tracking-->
			<bool name="ga_autoActivityTracking">true</bool>
	
			<!--Enable automatic exception tracking-->
			<bool name="ga_reportUncaughtExceptions">true</bool>
		</resources>

## Flurry
	* libs/Flurry_Android_SDK_vAndroid_3.3.2/projectApiKey.txt

## Crashlytics
	* AndroidManifest.xml

	<meta-data
            android:name="com.crashlytics.ApiKey"
            android:value="abcd" />


# Parse - Sending push notifications to clients from Parse.com

* Use "JSON" type
* When you want to send push notifications to only devices with debug app, change "Send to" to "Segment" from "Everyone", and put "debug" at "channels contains one of".

## Push Type 1 - Just simple launching app
    {
      "title": "title goes here",
      "alert": "content goes here",
      "data": {
        "type": "app_launch",
        "code": "you can put any string to distinguished statistics of pushes at Flurry"
      }
    }

This push notification just opens your app. Simplest way. You can poke users with any message you want.

## Push Type 2 - Open specific url
    {
      "title": "title goes here",
      "alert": "content goes here",
      "data": {
        "type": "url_link",
        "code": "you can put any string to distinguished statistics of pushes at Flurry"
        "url": "primary url",
        "url2": "secondary url"
      }
    }

"url" can be either a web url or a url scheme like "twitter://".
If "url" is a url scheme, there could be an exception if the app doesn't exist.
For that case, you can set "url2" to lead users to another url like Google Play Store or promotion web url.

If you're not using "url2", you can just send push like:

    {
      "title": "title goes here",
      "alert": "content goes here",
      "data": {
        "type": "url_link",
        "code": "you can put any string to distinguished statistics of pushes at Flurry"
        "url": "primary url"
      }
    }