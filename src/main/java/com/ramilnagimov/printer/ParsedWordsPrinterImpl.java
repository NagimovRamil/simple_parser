package com.ramilnagimov.printer;

import java.util.HashMap;
import java.util.Map;

public class ParsedWordsPrinterImpl implements ParsedWordsPrinter {
    @Override
    public void printWordsParsedFromURL(String[] words) {
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
