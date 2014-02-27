# 데이터 채우기
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


# 푸시 보내기

* 꼭 JSON 타입으로 보낼 것.
* 개발 빌드에게만 전송하고 싶다면, "Send to" 항목을 "Everyone" 에서 "Segment" 로 바꾸고, "channels contains one of" 값을 debug 로 세팅한다.

## 종류1 - 앱 실행시키기
    {
      "title": "제목",
      "alert": "내용",
      "data": {
        "type": "app_launch",
        "code": "나중에 통계에서 구분해보기 위해 넣는 임의의 내용"
      }
    }
그냥 앱으로 튕겨준다. 앱 사용을 유도하기 위해 원하는 메시지를 담아 푸시할 때 사용할 수 있다.

## 종류2 - 특정 URL 로 튕기기
    {
      "title": "제목",
      "alert": "내용",
      "data": {
        "type": "url_link",
        "code": "나중에 통계에서 구분해보기 위해 넣는 임의의 내용"
        "url": "첫번째 URL",
        "url2": "두번째 URL"
      }
    }

title, alert 부분을 채워넣고, url 과 url2 를 채워 넣는다.
url 은 웹 url 일수도 있고, sbverse:// 와 같은 url scheme 일수도 있다.
url 로 튕기려다가 실패했을때, 보조적으로 url2 로 튕길 수 있도록 되어 있다.
url 로 튕기려다가 실패하는 케이스는, 예를 들면 특정 url scheme 으로 튕기도록 하였으나,
해당 앱이 설치되어 있지 않는 경우에 url2 가 가리키는 마켓으로 튕기는 등의 경우이다.

url2 없이 그냥 보내는 경우에는 아래와 같이 보낸다.

    {
      "title": "제목",
      "alert": "내용",
      "data": {
        "type": "url_link",
        "code": "나중에 통계에서 구분해보기 위해 넣는 임의의 내용"
        "url": "첫번째 URL"
      }
    }