package com.example.testlibrary.helper;

import com.example.testlibrary.api.HttpClient;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.utils.json.JSONUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v85.cachestorage.model.Header;
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
