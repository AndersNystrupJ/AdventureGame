package org.example;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private Room inRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon currentWeapon;


    public Player(String playerName, Room inRoom, ArrayList<Item> inventory, int health, Weapon currentWeapon) {
        this.playerName = playerName;
        this.inRoom = inRoom;
        this.inventory = new ArrayList<Item>(); //opret new inventory direkte her i stedet for i map
        this.health = health;
        this.currentWeapon = currentWeapon;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Room getInRoom() {
        return inRoom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setInRoom(Room inRoom) {
        this.inRoom = inRoom;
    }

    public void takeItem(Room room, String itemToTake) {
        boolean found = false;
        for (Item item : room.getItems()) {
            if (item.getShortName().equalsIgnoreCase(itemToTake)) {
                inventory.add(item);
                System.out.println("You picked up " + item.getLongName());
                room.getItems().remove(item);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("I don't see that anywhere.");
        }
    }

    public void dropItem(Room room, String itemName) {
        Item itemToRemove = null;
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            room.addItem(itemToRemove);
            inventory.remove(itemToRemove);
            System.out.println("You dropped " + itemToRemove.getLongName());
        } else {
            System.out.println("You don't have " + itemName + " in your inventory.");
        }
    }

    public void viewInventory() {
        if (!inventory.isEmpty()) {
            System.out.println("Inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item.getLongName());
            }
        } else {
            System.out.println("Your inventory is empty.");
        }
    }

    public void playerHealth() {
        System.out.println("HP: " + health);
        if (health <= 0) {
            System.out.println("You have died...");
            System.exit(0);
        } else if (health > 60) {
            System.out.println("You're good on health");
        } else if (health > 40) {
            System.out.println("You're good on health, but avoid fighting");
        } else if (health < 40) {
            System.out.println("You're low on health, be careful");
        }
    }

    public void eat(String foodName) {
        Item itemToEat = null;
        for (Item food : inventory) {
            if (food.getShortName().equalsIgnoreCase(foodName) && food instanceof Food) {
                itemToEat = food;
                break;
            }
        }
        if (itemToEat != null) {
            System.out.println("Eating " + itemToEat.getLongName() + "...");
            health = health + (((Food) itemToEat).getHealthPoints());
            if (((Food) itemToEat).getHealthPoints() < 0) {
                System.out.println("Food was poisonous. You've lost " + ((Food) itemToEat).getHealthPoints() + " hp");
                playerHealth();
                inventory.remove(itemToEat);
            } else {
                System.out.println("You've gained " + ((Food) itemToEat).getHealthPoints() + " hp");
                playerHealth();
                inventory.remove(itemToEat);
            }
        } else {
            System.out.println("I don't have " + foodName + " in my bag.");
        }
    }


    public void equip(String weaponName) {
        boolean weaponFound = false;
        for (Item weapon : inventory) {
            if (weapon.getShortName().equalsIgnoreCase(weaponName) && weapon instanceof Weapon) {
                currentWeapon = (Weapon) weapon;
                System.out.println("You have equipped " + currentWeapon.getLongName());
                weaponFound = true;
            } else if (weapon.getShortName().equalsIgnoreCase(weaponName) && !(weapon instanceof Weapon)) {
                System.out.println("Only weapons can be equipped");
                weaponFound = true;
            }
        }
        if (!weaponFound) {
            System.out.println("You don't have a " + weaponName + " in your inventory");
        }
    }

    public void attack(Room room, String enemyName) {
        Enemy enemyToAttack = null;
        if (currentWeapon != null && currentWeapon.getAmmo() > 0) {
             if (room.getEnemies().size() > 1) {
                for (Enemy enemy : room.getEnemies()) {
                    if (enemy.getName().equalsIgnoreCase(enemyName) && !room.getEnemies().isEmpty()) {
                        enemyToAttack = enemy;
                    }
                }
            }
             if (room.getEnemies().isEmpty()) {
                System.out.println("You attack the air with your " + currentWeapon.getShortName());
                currentWeapon.uses();
            } else if (enemyToAttack != null) {
                System.out.println("You attack " + enemyToAttack.getName() + " with your " + currentWeapon.getShortName());
                currentWeapon.uses();
                enemyToAttack.setHealth(enemyToAttack.getHealth() - currentWeapon.getDamage());
                System.out.println("Enemy health: " + enemyToAttack.getHealth());
                System.out.println();
                if (enemyToAttack.getHealth() <= 0) {
                    System.out.println("You have killed " + enemyToAttack.getName());
                    room.getItems().add(enemyToAttack.getEnemyWeapon());
                    room.getEnemies().remove(enemyToAttack);
                    System.out.println();
                } else {
                    System.out.println(enemyToAttack.getName() + " attacks you");
                    health = health - enemyToAttack.getEnemyWeapon().getDamage();
                    playerHealth();
                    System.out.println();
                }
            } else {
                enemyToAttack = room.getEnemies().get(0);
                System.out.println("You attack " + enemyToAttack.getName() + " with your " + currentWeapon.getShortName());
                currentWeapon.uses();
                enemyToAttack.setHealth(enemyToAttack.getHealth() - currentWeapon.getDamage());
                System.out.println("Enemy health: " + enemyToAttack.getHealth());
                System.out.println();
                if (enemyToAttack.getHealth() <= 0) {
                    System.out.println("You have killed " + enemyToAttack.getName());
                    room.getItems().add(enemyToAttack.getEnemyWeapon());
                    room.getEnemies().remove(enemyToAttack);
                    System.out.println();
                } else {
                    System.out.println(enemyToAttack.getName() + " attacks you");
                    health = health - enemyToAttack.getEnemyWeapon().getDamage();
                    playerHealth();
                    System.out.println();
                }
            }
        } else if (currentWeapon != null && currentWeapon.getAmmo() == 0) {
            System.out.println("You are out of ammo");
        } else {
            System.out.println("You don't have a weapon equipped");
        }
    }
}
