package org.example;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String longName, String shortName, int damage, int ammo) {
        super(longName,shortName, damage, ammo);
    }

    @Override
    public void uses() {
    }
}
