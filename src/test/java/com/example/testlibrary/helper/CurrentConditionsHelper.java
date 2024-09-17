package com.example.testlibrary.helper;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CurrentConditionsHelper extends AbstractHelper{


    public String getCurrentWeather(String locationKey) {
        JsonNode node = httpClient.get(url + "/currentconditions/v1/"
        + locationKey + "?apikey=" + apiKey)
                .then().extract().body().as(JsonNode.class);
        return node.get(0).get("Temperature").get("Metric").get("Value").asText();
    }

    public static void main(String[] args) throws Exception {
        String apiKey = "gDZ40wELJLcPg1j3XmffdzB2Y8vz3z6e";  // Replace with your actual API key
        String city = "318251";  // Replace with your desired city
        

        // Build the request URL
        String requestUrl = "http://dataservice.accuweather.com/currentconditions/v1/"
                + city + "?apikey=" + apiKey;

        System.out.println("requestUrl = " + requestUrl);

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
