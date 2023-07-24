package com.radsoltan;

import com.radsoltan.lists.SaddlePoints;
import com.radsoltan.lists.SaddlePointsCommunity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SaddlePointsCommunity saddlePoints = new SaddlePointsCommunity(List.of(List.of(9, 8, 7), List.of(5, 3, 2), List.of(6, 6, 7)));

        saddlePoints.getSaddlePoints();
    }
}