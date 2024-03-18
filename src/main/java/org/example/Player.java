package org.example;
import java.util.ArrayList;

public class Player {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private Room inRoom;
    private ArrayList<Item> inventory;
    private int health;

    public Player(String playerName, Room inRoom, ArrayList<Item> inventory, int health) {
        this.playerName = playerName;
        this.inRoom = inRoom;
        this.inventory = inventory;
        this.health = health;
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
    public void unequipWeapon (Room room, String weaponName) {
        Weapon weaponToRemove = null;
        for (Item weapon : weaponSlot) {
            if (weapon.getShortName().equalsIgnoreCase(weaponName)) {
                weaponToRemove = (Weapon) weapon;
                break;
            }
        }
        if (weaponToRemove != null) {
            inventory.add(weaponToRemove);
            weaponSlot.remove(weaponToRemove);
            System.out.println("You have put " + weaponToRemove.getLongName() + " in your inventory");
        } else {
            System.out.println("You don't have a " + weaponName + " equipped");
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

    public void eat(Room room, String foodName) {
        Item itemToEat = null;
        for (Item food : inventory) {
            if (food.getShortName().equals(foodName) && food instanceof Food) {
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

    ArrayList<Weapon> weaponSlot = new ArrayList<>(1);

    public void equip(Room room, String weaponName) {
        try {
            Item itemToEquip = null;
            for (Item weapon : inventory) {
                if (weapon instanceof Weapon) {
                    if (weapon.getShortName().equalsIgnoreCase(weaponName)) {
                        itemToEquip = weapon;
                        weaponSlot.add((Weapon) weapon);
                        inventory.remove(weapon);
                        System.out.println("You have equipped " + weapon.getLongName());
                        break;
                    } else {
                        System.out.println("You don't have a " + weaponName + " in your inventory");
                        break;
                    }

                } else {
                    System.out.println("Only weapon items can be equipped");
                }

            }
        } catch (Exception e) {
            System.out.println("You already have a weapon equipped");
        }
    }
    public void attack() {
        while (!weaponSlot.isEmpty()) {
            weaponSlot.get(0).uses();
            System.out.println("You swing your " + weaponSlot.get(0).getShortName());
            break;
        }
    }
}