package com.example.testlibrary.helper;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class LocationHelper extends AbstractHelper {

    public String getLocationKey(String city){
        JsonNode node = httpClient.get(url + "/locations/v1/cities/search?apikey="
                        + apiKey + "&q=" + city)
                .then().extract().body().as(JsonNode.class);
        return node.get(0).get("Key").asText();
    }

    public static void main(String[] args) throws Exception {
        String apiKey = "gDZ40wELJLcPg1j3XmffdzB2Y8vz3z6e";  // Replace with your actual API key
        String city = "Istanbul";  // Replace with your desired city

        // Build the request URL
        String requestUrl = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                + apiKey + "&q=" + city;

        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create a request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .build();

        // Send the request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response
        System.out.println(response.body());
    }
}
