package net.eunjae.android.boilerplate.api;

import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

// FIXME
@Rest(rootUrl = "http://...", converters = {MappingJacksonHttpMessageConverter.class})
public interface RestClient {

}