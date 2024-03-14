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

    public void dropItem(Room room, String itemName) {
        Item itemToRemove = null;
        for (Item item : inventory) {
            if (item.getShortName().equals(itemName)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            room.addItem(itemToRemove.getLongName(), itemToRemove.getShortName());
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
}