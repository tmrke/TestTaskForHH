package ru.ageev.hhgame.game;

import java.util.Random;

public class Creature {
    private final Random random = new Random();
    private final Cube cube = new Cube(random);
    private final int fullHealth;
    private final int attack;
    private final int protection;
    private int health;
    private final int[] damage;
    private boolean isDead;

    public Creature(int attack, int protection, int health) {
        if (attack < 1) {
            throw new IllegalArgumentException("attack can't be < 1");
        }

        if (protection < 0) {
            throw new IllegalArgumentException("protection can't be < 0");
        }

        if (health < 1) {
            throw new IllegalArgumentException("health can't be < 0");
        }

        this.fullHealth = health;
        this.attack = attack;
        this.protection = protection;
        this.health = health;

        int maxDamage = 10;
        this.damage = new int[maxDamage];

        for (int i = 0; i < damage.length; i++) {
            this.damage[i] = i + 1;
        }
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int[] getDamage() {
        return this.damage;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void attack(Creature protector) {
        if (protector.isDead() || isDead) {
            return;
        }

        int attackMode = getAttack() - protector.getProtection() + 1;
        boolean isSuccess = isSuccess(attackMode, cube);

        if (isSuccess) {
            int currentDamage = random.nextInt(getDamage().length) + 1;
            System.out.println("damage = " + currentDamage);
            protector.setHealth(protector.getHealth() - currentDamage);

            if (protector.getHealth() <= 0) {
                protector.setHealth(0);
                protector.setDead(true);
            }
        }
    }

    private boolean isSuccess(int attackMode, Cube cube) {
        System.out.println("attack mode = " + attackMode);

        if (attackMode < 1) {
            attackMode = 1;
        }

        int currentCubeValue;

        for (int i = 0; i < attackMode; i++) {
            currentCubeValue = cube.getCubeRandomValue();
            System.out.println("cube value = " + currentCubeValue);

            if (currentCubeValue == 5 || currentCubeValue == 6) {
                return true;
            }
        }

        return false;
    }
}
