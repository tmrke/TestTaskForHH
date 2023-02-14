package ru.ageev.hhgame.game;

public class Gamer extends Creature {
    private int treatmentsCount = 3;

    public Gamer(int attack, int protection, int health) {
        super(attack, protection, health);
    }

    public void treat() {
        if (treatmentsCount < 1 || getHealth() == getFullHealth() || isDead()) {
            return;
        }

        setHealth((int) Math.ceil(getHealth() * 1.5));

        if (getHealth() > getFullHealth()) {
            setHealth(getFullHealth());
        }

        treatmentsCount--;
    }

    public int getTreatmentsCount() {
        return treatmentsCount;
    }
}
