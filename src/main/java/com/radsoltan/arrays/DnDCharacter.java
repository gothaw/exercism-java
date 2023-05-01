package com.radsoltan.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DnDCharacter {
    private final int ABILITY_ROLLS = 4;
    private final int DICE_TYPE_USED = 6;
    private final int BASE_HITPOINTS = 10;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    public DnDCharacter() {
        strength = ability(rollDice());
        dexterity = ability(rollDice());
        constitution = ability(rollDice());
        intelligence = ability(rollDice());
        wisdom = ability(rollDice());
        charisma = ability(rollDice());
        hitpoints = BASE_HITPOINTS + modifier(constitution);
    }

    public int ability(List<Integer> scores) {
        List<Integer> sortedScores = new ArrayList<>(scores);
        sortedScores.sort(Collections.reverseOrder());
        return sortedScores.stream().limit(ABILITY_ROLLS - 1).reduce(0, Integer::sum);
    }

    public List<Integer> rollDice() {
        List<Integer> diceRolls = new ArrayList<>();
        for (int i = 0; i < ABILITY_ROLLS; i++) {
            diceRolls.add((int) (Math.random() * DICE_TYPE_USED + 1));
        }
        return diceRolls;
    }

    public int modifier(int input) {
        return (int) Math.floor((input - 10) * 0.5);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
