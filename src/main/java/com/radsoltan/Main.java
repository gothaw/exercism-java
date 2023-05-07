package com.radsoltan;

import com.radsoltan.strings.AcronymCommunity;

public class Main {
    public static void main(String[] args) {
        AcronymCommunity acronymCommunity = new AcronymCommunity("The Road _Not_ Taken");
        System.out.println(acronymCommunity.get());
    }
}