package ru.ageev.hhgame.game;

import java.util.Random;

public class Cube {
    private static final int[] values = {1, 2, 3, 4, 5, 6};
    private final Random random;

    public Cube(Random random) {
        this.random = random;
    }

    public int getCubeRandomValue() {
        return random.nextInt(values.length) + 1;
    }
}
