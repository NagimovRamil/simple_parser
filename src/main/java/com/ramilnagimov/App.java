package com.ramilnagimov;

import org.apache.commons.validator.routines.UrlValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        String urlForParsing;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                urlForParsing = reader.readLine();
                String[] schemes = {"http", "https"};
                UrlValidator urlValidator = new UrlValidator(schemes);
                if (urlValidator.isValid(urlForParsing)) {
                    Parser parser = new Parser();
                    String[] words = parser.parseURL(urlForParsing);
                    ParsedWordsPrinter parsedWordsPrinter = new ParsedWordsPrinter();
                    parsedWordsPrinter.printParsedWords(words);
                } else {
                    System.out.println("URL is invalid");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
