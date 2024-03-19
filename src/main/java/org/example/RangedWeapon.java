package org.example;

public class RangedWeapon extends Weapon{
    private int ammo;
    public RangedWeapon(String longName, String shortName, int ammo) {
        super(longName,shortName);
        this.ammo = ammo;
    }

    @Override
    public void uses() {
        if (ammo > 0) {
            ammo--;
            System.out.println("Ammo: " + ammo);
        } else {
                System.out.println("You are out of ammo");
            }
        }

    public int getAmmo() {
        return ammo;
    }
}
