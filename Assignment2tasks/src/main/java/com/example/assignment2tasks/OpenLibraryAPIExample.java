package com.example.assignment2tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenLibraryAPIExample {
    public static void main(String[] args) {
        try {
            // Open Library API URL
            String urlString = "https://openlibrary.org/search.json?q=the+lord+of+the+rings";
            URL url = new URL(urlString);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();

                // Parse the response data as JSON
                JSONObject jsonResponse = new JSONObject(content.toString());
                JSONArray docs = jsonResponse.getJSONArray("docs");

                // Show details of the first 2 books
                for (int i = 0; i < 2 && i < docs.length(); i++) {
                    JSONObject book = docs.getJSONObject(i);

                    String title = book.optString("title", "N/A");
                    String author = book.optString("author_name", "Unknown Author");
                    int firstPublishYear = book.optInt("first_publish_year", -1);

                    System.out.println("Book " + (i + 1) + ":");
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("First Published Year: " + (firstPublishYear != -1 ? firstPublishYear : "N/A"));
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("Request failed with code " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
