package org.example;

public abstract class Weapon extends Item{
    /*private*/ int damage;
    /*private*/ int ammo;

    public Weapon (String longName, String shortName, int damage, int ammo) {
        super(longName,shortName);
        this.ammo = ammo;
        this.damage = damage;
    }

    public abstract void uses();

    public int getAmmo() {
        return ammo;
    }

    public int getDamage() {
        return damage;
    }
}
