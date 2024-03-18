package org.example;

public abstract class Weapon extends Item{
    //private int damage;

    public Weapon (String longName, String shortName) {
        super(longName,shortName);
    }

    public abstract void uses();
}
