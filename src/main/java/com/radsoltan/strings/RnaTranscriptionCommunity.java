package com.radsoltan.strings;

public class RnaTranscriptionCommunity {
    private static int nucleotideMap(int c) {
        switch (c) {
            case 'G' : return 'C';
            case 'C' : return 'G';
            case 'T' : return 'A';
            case 'A' : return 'U';
        }
        throw new IllegalArgumentException("Invalid input");
    }

    public String transcribe(String dnaStrand) {
        return dnaStrand
                .codePoints()
                .map(Character::toUpperCase)
                .map(RnaTranscriptionCommunity::nucleotideMap)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
