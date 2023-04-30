package com.radsoltan.conditionals;

public class DartsCommunity {
    public int score(double x, double y) {
        double distance = Math.sqrt(x * x + y * y);
        return distance <= 1 ? 10
                : distance <= 5 ? 5
                : distance <= 10 ? 1
                : 0;
    }
}
