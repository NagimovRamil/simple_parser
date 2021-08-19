package com.ramilnagimov;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        final Logger log = Logger.getLogger(App.class);
        String urlForParsing;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                urlForParsing = reader.readLine();
                log.info("Line read successfully");
                String[] schemes = {"http", "https"};
                UrlValidator urlValidator = new UrlValidator(schemes);
                if (urlValidator.isValid(urlForParsing)) {
                    log.info("Validation passed successfully");
                    Parser parser = new Parser();
                    String[] words = parser.parseURL(urlForParsing);
                    log.info("URL parsed");
                    ParsedWordsPrinter parsedWordsPrinter = new ParsedWordsPrinter();
                    parsedWordsPrinter.printParsedWords(words);
                    log.info("Parsed words printed");
                } else {
                    System.out.println("URL is invalid");
                    log.warn("URL is invalid");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getStackTrace());
        }
    }
}
