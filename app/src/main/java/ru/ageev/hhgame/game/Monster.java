package ru.ageev.hhgame.game;

public class Monster extends Creature {
    public Monster(int attack, int protection, int health) {
        super(attack, protection, health);
    }
}

//Наследую этот класс от класса Creature, т.к. по условию обязательно должен быть класс Monster,
//а наследовать класс Gamer от класса Monster нельзя, т.к. игрок не является частью монстра.
//Так же при дальнейшей доработке класса Monster можно будет добавить методы присущие только этому классу.
