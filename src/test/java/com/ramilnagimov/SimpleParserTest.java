package com.ramilnagimov;


import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleParserTest {
    @Test
    public void validatorTest() {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        String validUrlForParsing = "https://yandex.ru/";
        assertTrue(urlValidator.isValid(validUrlForParsing));
        String invalidUrlForParsing = "yandex.ru/";
        assertFalse(urlValidator.isValid(invalidUrlForParsing));
        String invalidUrlForParsing2 = "123@123";
        assertFalse(urlValidator.isValid(invalidUrlForParsing2));
    }

    @Test
    public void parserTest() {
        String text = null;
        try {
            Document doc = Jsoup.connect("https://yandex.ru/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:91.0) Gecko/20100101 Firefox/91.0")
                    .referrer("http://www.google.com")
                    .get();
            text = doc.body().text();
        } catch (
                IOException e) {
            e.printStackTrace();
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
        List<String> listOfWords = Arrays.asList(words);
        assertTrue(listOfWords.contains("Яндекс"));
    }

    @Test
    public void printerTest() {
        String[] words = new String[5];

        words[0] = "one";
        words[1] = "one";
        words[2] = "two";
        words[3] = "three";
        words[4] = "four";

        Map<String, Integer> map = new HashMap<>();
        for (String string : words) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else map.put(string, map.get(string) + 1);
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        assertTrue(map.containsKey("one"));
        assertEquals(2, map.get("one"));
    }

}
