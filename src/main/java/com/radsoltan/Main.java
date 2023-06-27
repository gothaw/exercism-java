package com.radsoltan;

import com.radsoltan.chars.RotationalCipher;

public class Main {
    public static void main(String[] args) {
        RotationalCipher rotationalCipher = new RotationalCipher(5);

        System.out.println(rotationalCipher.rotate("OMG"));
    }
}