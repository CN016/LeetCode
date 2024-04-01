package com.my016.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class StringToMap {
    public static void main(String[] args) {
        Map<String , String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println(map);
        map = parseString(map.toString());
        System.out.println(map);
    }

    public static Map<String,String> parseString(String resources){
        if (resources == null || "".equals(resources)){
            return null;
        }
        Map<String,String> map = new HashMap<>();
        String replace = resources.replace("{", "").replace("}", "");
        String[] keyValuePairs = replace.split(", ");
        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            map.put(entry[0],entry[1]);
        }
        return map;
    }
}
