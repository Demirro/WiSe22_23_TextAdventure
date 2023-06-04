package de.uk.java.utils;

import java.util.Random;

public class RandomNumberGenerator {
    public static int getRndInteger(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max - min) + 1) + min;
    }
}
