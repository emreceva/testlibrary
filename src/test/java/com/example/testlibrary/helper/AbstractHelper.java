package com.example.testlibrary.helper;

import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.utils.json.JSONUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v85.cachestorage.model.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.http.HttpClient;

public abstract class AbstractHelper {

    @Value("${web.accuweather.base.url}")
    protected String url;

    @Autowired
    protected HttpClient httpClient;

    @Autowired
    protected ScenarioRunContext runContext;

    protected final Header header = new Header("Content-Type", "application/json");


    protected <T> T getData(Response response, Class<T> responseType) {
        JsonNode node = response.then().extract()
                .body().as(JsonNode.class);

        ObjectMapper mapper = JSONUtils.createMapper();
        return null;
    }
}
