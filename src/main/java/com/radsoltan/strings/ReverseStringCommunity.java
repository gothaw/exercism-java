package com.radsoltan.strings;

public class ReverseStringCommunity {
    public String reverse(String inputString) {
        StringBuilder outString = new StringBuilder();
        for(char c : inputString.toCharArray()) {
            outString.insert(0, c);
        }
        return outString.toString();
    }
}
