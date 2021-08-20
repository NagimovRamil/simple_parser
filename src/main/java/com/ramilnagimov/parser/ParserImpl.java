package com.ramilnagimov.parser;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ParserImpl implements Parser {
    private static final Logger log = Logger.getLogger(ParserImpl.class);

    @Override
    public String[] parseURL(String url) {
        String text = null;
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:91.0) Gecko/20100101 Firefox/91.0")
                    .referrer("http://www.google.com")
                    .get();
            text = doc.body().text();
        } catch (
                IOException e) {
            e.printStackTrace();
            log.error(e.getStackTrace());
        }
        ArrayList<String> listOfSeparators = new ArrayList<>();
        listOfSeparators.add(" ");
        listOfSeparators.add(",");
        listOfSeparators.add(".");
        listOfSeparators.add("!");
        listOfSeparators.add("?");
        listOfSeparators.add(";");
        listOfSeparators.add(":");
        listOfSeparators.add("[");
        listOfSeparators.add("]");
        listOfSeparators.add("(");
        listOfSeparators.add(")");
        listOfSeparators.add("-");
        listOfSeparators.add("\n");
        listOfSeparators.add("\r");
        listOfSeparators.add("\t");
        String separatorsString = String.join("|\\", listOfSeparators);
        String[] words = text.split(separatorsString);
        return words;
    }
}
