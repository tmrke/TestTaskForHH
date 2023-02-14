package ru.ageev.hhgame.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Gamer gamer;
    private final List<Monster> monsters;

    public Game() {
        this.gamer = new Gamer(10, 10, 100);
        this.monsters = new ArrayList<>();

        int MONSTERS_COUNT = 3;
        for (int i = 0; i < MONSTERS_COUNT; i++) {
            monsters.add(new Monster(10, 10, 30));
        }
    }

    public Gamer getGamer() {
        return gamer;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
