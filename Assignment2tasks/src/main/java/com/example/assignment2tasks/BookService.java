package com.example.assignment2tasks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookService {
    private static final String API_KEY = "YOUR_NYT_API_KEY";
    private static final String BASE_URL = "https://api.nytimes.com/svc/books/v3";

    public String getBestSellers() throws IOException, InterruptedException {
        String url = BASE_URL + "/lists/current/hardcover-fiction.json?api-key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Add similar methods for other endpoints
}
