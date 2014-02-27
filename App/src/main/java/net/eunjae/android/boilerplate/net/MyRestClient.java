package net.eunjae.android.boilerplate.net;

import org.androidannotations.annotations.rest.Rest;

@Rest(rootUrl = "http://www.myserver.com", converters = {MyJsonToModelConverter.class}, interceptors = {MyInterceptor.class})
public interface MyRestClient {
}
