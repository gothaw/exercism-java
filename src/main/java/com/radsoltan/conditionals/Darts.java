package com.radsoltan.conditionals;

public class Darts {
    public int score(double xOfDart, double yOfDart) {
        double radius = Math.sqrt(xOfDart * xOfDart + yOfDart * yOfDart);
        if (radius <= 1) {
            return 10;
        } else if (radius <= 5) {
            return 5;
        } else if (radius <= 10) {
            return 1;
        }
        return 0;
    }
}
