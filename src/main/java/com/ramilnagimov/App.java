package com.ramilnagimov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{
    public static void main( String[] args )
    {
        String urlForParsing = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        urlForParsing = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        Document doc = Jsoup.connect(urlForParsing)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
