package com.ramilnagimov;

import com.ramilnagimov.URLvalidator.URLvalidatorImpl;
import com.ramilnagimov.parser.ParserImpl;
import com.ramilnagimov.printer.ParsedWordsPrinterImpl;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleParser {
    public static void main(String[] args) {
        final Logger log = Logger.getLogger(SimpleParser.class);
        String urlForParsing;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                urlForParsing = reader.readLine();
                log.info("Line read successfully");
                URLvalidatorImpl URLvalidator = new URLvalidatorImpl(urlForParsing);
                if (URLvalidator.validateURL(urlForParsing)) {
                    log.info("Validation passed successfully");

                    ParserImpl parser = new ParserImpl();
                    String[] words = parser.parseURL(urlForParsing);
                    log.info("URL parsed");

                    ParsedWordsPrinterImpl parsedWordsPrinter = new ParsedWordsPrinterImpl();
                    parsedWordsPrinter.printWordsParsedFromURL(words);
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
