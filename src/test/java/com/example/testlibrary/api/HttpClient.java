package com.example.testlibrary.api;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

public interface HttpClient {


    Response get(String path);

    Response get(String path, Header header);

    Response get(String path, Headers headers);

    Response get(String path, Headers headers, Map<String, ?> parameters);

}
