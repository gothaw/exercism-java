package com.radsoltan.num;

import java.util.HashMap;
import java.util.Map;

public class SpaceAge {
    private final double seconds;
    private final static int SECONDS_IN_YEAR_EARTH = 31557600;
    private final static Map<String, Double> PLANET_YEARS_TO_EARTH = new HashMap<>();
    static {
        PLANET_YEARS_TO_EARTH.put("Mercury", 0.2408467);
        PLANET_YEARS_TO_EARTH.put("Venus", 0.61519726);
        PLANET_YEARS_TO_EARTH.put("Mars", 1.8808158);
        PLANET_YEARS_TO_EARTH.put("Jupiter", 11.862615);
        PLANET_YEARS_TO_EARTH.put("Saturn", 29.447498);
        PLANET_YEARS_TO_EARTH.put("Uranus", 84.016846);
        PLANET_YEARS_TO_EARTH.put("Neptune", 164.79132);
    }

    public SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    public double getSeconds() {
        return this.seconds;
    }

    public double onEarth() {
        return seconds / SECONDS_IN_YEAR_EARTH;
    }

    public double onMercury() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Mercury");
    }

    public double onVenus() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Venus");
    }

    public double onMars() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Mars");
    }

    public double onJupiter() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Jupiter");
    }

    public double onSaturn() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Saturn");
    }

    public double onUranus() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Uranus");
    }

    public double onNeptune() {
        return onEarth() / PLANET_YEARS_TO_EARTH.get("Neptune");
    }
}
