package org.example;

public class RangedWeapon extends Weapon{
    private int ammo;
    public RangedWeapon(String longName, String shortName, int ammo) {
        super(longName,shortName);
        this.ammo = ammo;
    }

    @Override
    public void uses() {
        while (ammo > 0) {
            ammo--;
            if (ammo == 0) {
                System.out.println("You are out of ammo");
                break;
            } else {
                System.out.println("Ammo: " + ammo);
            }
        }
    }

    public int getAmmo() {
        return ammo;
    }
}
