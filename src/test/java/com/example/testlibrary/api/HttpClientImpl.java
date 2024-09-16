package com.example.testlibrary.api;

import com.example.testlibrary.context.ScenarioRunContext;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Component
@Slf4j
public class HttpClientImpl implements HttpClient{

    @Autowired
    protected ScenarioRunContext runContext;

    private final RestAssuredConfig restAssuredConfig;


    public HttpClientImpl(@Value("${http.connection.timeout:5000}") int connectionTimeout) {
        this.restAssuredConfig = RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", connectionTimeout));
    }


    @Override
    public Response get(String path) {
        return get(path, null, null);
    }

    @Override
    public Response get(String path, Header header) {
        return get(path, new Headers(header), null);
    }

    @Override
    public Response get(String path, Headers headers) {
        return get(path, headers,null);
    }

    @Override
    public Response get(String path, Headers headers, Map<String, ?> parameters) {
        RequestSpecification requestSpecification = createRequestSpecification(headers);
        requestSpecification.params(parameters != null ? parameters : Map.of());

        return logAndExecuteRequest(requestSpecification, path, null, HttpMethod.GET);
    }

    private RequestSpecification createRequestSpecification() {
        return createRequestSpecification(null, null);
    }

    private RequestSpecification createRequestSpecification(Headers headers) {
        return createRequestSpecification(headers, null);
    }

    private RequestSpecification createRequestSpecification(Headers headers, Object body) {
        RequestSpecification requestSpecification = given().config(restAssuredConfig).relaxedHTTPSValidation()
                .contentType(ContentType.JSON);

        if(body != null) {
            requestSpecification.body(body);
        }

        if(headers != null) {
            return requestSpecification.headers(headers);
        }

        return requestSpecification;
    }

    private Response logAndExecuteRequest(RequestSpecification requestSpecification, String path, Object body, HttpMethod method) {
        requestSpecification.log().all();

        Response response = executeRequest(method, requestSpecification, path);

        logRequestDetails(requestSpecification, body, response);

        return response;
    }

    private Response executeRequest(HttpMethod method, RequestSpecification requestSpecification, String path) {
        if(method.equals(HttpMethod.GET)) {
            return executeRequestWithLogging(requestSpecification.get(path));
        }
        throw new UnsupportedOperationException("Unsupported HTTP method: " + method);
    }

    private Response executeRequestWithLogging(Response response) {
        return response.then().log().all().extract().response();
    }

    private void logRequestDetails(RequestSpecification requestSpecification, Object body, Response response) {
        RequestSpecificationImpl requestSpecificationImpl = (RequestSpecificationImpl) requestSpecification;
        runContext.setProperty(ScenarioRunContext.ContextProperties.API.REQUEST_HEADERS, requestSpecificationImpl.getHeaders());
        runContext.setProperty(ScenarioRunContext.ContextProperties.API.RESPONSE_HEADERS, response.getHeaders());

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpecification);

        log.info(queryRequest.getURI(), body, response);
    }
}
