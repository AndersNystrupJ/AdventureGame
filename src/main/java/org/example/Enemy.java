package org.example;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon enemyWeapon;

    public Enemy(String name, String description, int health, Weapon enemyWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.enemyWeapon = enemyWeapon;
    }

    public void enemyAttack() {
            enemyWeapon.uses();
    }

    public int getHealth() {
        return health;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
}
