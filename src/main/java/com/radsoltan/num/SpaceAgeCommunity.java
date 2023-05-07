package com.radsoltan.num;

public class SpaceAgeCommunity {
    private enum Planet {
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private final double orbitalPeriodInEarthYears;

        Planet(double orbitalPeriodInEarthYears) {
            this.orbitalPeriodInEarthYears = orbitalPeriodInEarthYears;
        }

        public double getOrbitalPeriodInEarthYears() {
            return orbitalPeriodInEarthYears;
        }
    }

    private static final int EARTH_YEAR_IN_SECONDS = 31557600;
    private final double seconds;

    public SpaceAgeCommunity(double seconds) {
        this.seconds = seconds;
    }
    public double getSeconds() {
        return seconds;
    }
    public double onEarth() {
        return seconds / EARTH_YEAR_IN_SECONDS;
    }
    public double onMercury() {
        return getOrbitalAge(Planet.MERCURY);
    }
    public double onVenus() {
        return getOrbitalAge(Planet.VENUS);
    }
    public double onMars() {
        return getOrbitalAge(Planet.MARS);
    }
    public double onJupiter() {
        return getOrbitalAge(Planet.JUPITER);
    }
    public double onSaturn() {
        return getOrbitalAge(Planet.SATURN);
    }
    public double onUranus() {
        return getOrbitalAge(Planet.URANUS);
    }
    public double onNeptune() {
        return getOrbitalAge(Planet.NEPTUNE);
    }
    private double getOrbitalAge(Planet planet) {
        return onEarth() / planet.getOrbitalPeriodInEarthYears();
    }
}
