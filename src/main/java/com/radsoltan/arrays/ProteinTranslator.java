package com.radsoltan.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProteinTranslator {
    public static final int PROTEIN_LENGTH = 3;
    public static final Map<String, String> PROTEINS = new HashMap<>();
    public static final List<String> STOP_CODES = new ArrayList<>(List.of("UAA", "UAG", "UGA"));
    static {
        PROTEINS.put("AUG", "Methionine");
        PROTEINS.put("UGG", "Tryptophan");
        List.of("UUU", "UUC").forEach(code -> PROTEINS.put(code, "Phenylalanine"));
        List.of("UUA", "UUG").forEach(code -> PROTEINS.put(code, "Leucine"));
        List.of("UCU", "UCC", "UCA", "UCG").forEach(code -> PROTEINS.put(code, "Serine"));
        List.of("UAU", "UAC").forEach(code -> PROTEINS.put(code, "Tyrosine"));
        List.of("UGU", "UGC").forEach(code -> PROTEINS.put(code, "Cysteine"));
    }

    public List<String> translate(String rnaSequence) {
        if (rnaSequence.length() % PROTEIN_LENGTH != 0) {
            throw new IllegalArgumentException("RNA sequence must be divided by 3");
        }

        List<String> proteins = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i++) {
            if (i % PROTEIN_LENGTH == 0) {
                String code = rnaSequence.substring(i, i + PROTEIN_LENGTH);
                if (STOP_CODES.contains(code)) {
                    return proteins;
                }
                proteins.add(PROTEINS.get(code));
            }
        }
        return proteins;
    }
}
