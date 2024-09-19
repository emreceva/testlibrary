package com.example.testlibrary.helper;

import com.example.testlibrary.api.HttpClient;
import com.example.testlibrary.context.ScenarioRunContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractHelper {

    @Value("${dataservice.accuweather.base.url}")
    protected String url;

    @Value("${accuweather.api.token}")
    protected String apiKey;

    @Autowired
    protected HttpClient httpClient;

    @Autowired
    protected ScenarioRunContext runContext;

}
