package com.ramilnagimov;

import java.util.HashMap;
import java.util.Map;

public class ParsedWordsPrinter {
    public void printParsedWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : words) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else map.put(string, map.get(string) + 1);
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
