package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Hello world!
 *
 */
public class App 
{   
    private static final String api = "https://pastebin.com/raw/TytE0smz?fbclid=IwAR25BvK84-yTiBeIpdgXX3KcfbOuWB9pmE0NRqyEzkaypU9ycVGbJYFYkes";
    public static void main( String[] args )
    {
        try
        {
            // Step 1: Make HTTP request
            URL url = new URL(api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) 
            {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Convert StringBuilder to String
            String responseString = response.toString();

            // Step 2: Parse JSON with Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(responseString);

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
