package org.example;

public class RangedWeapon extends Weapon {

    public RangedWeapon(String longName, String shortName, int damage, int ammo) {
        super(longName, shortName, damage, ammo);
    }

    @Override
    public void uses() {
        if (ammo > 0) {
            ammo--;
            if (ammo < 4) {
                System.out.println("You are low on ammo");
            }
        }

    }
}
