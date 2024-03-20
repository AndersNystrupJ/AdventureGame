package org.example;

import java.util.ArrayList;

public class Adventure {

    private MapConstruction map = new MapConstruction();

    Player player = new Player("", getMap().getCurrentRoom(), null, 100, null);

    public void look() {
        Room currentRoom = map.getCurrentRoom();
        if (currentRoom != null) {
            System.out.println(currentRoom.getRoomDescription());
            System.out.println("You look around and notice:");
            ArrayList<Item> items = currentRoom.getItems();
            if (items != null) {
                for (Item item : items) {
                    System.out.println("- " + item.getLongName());
                }
            } else {
                System.out.println("There are no items in this room.");
            }
        } else {
            System.out.println("You are not in any room.");
        }
    }

   // MAP METHODS:

    public MapConstruction getMap() {
        return map;
    }

    public void equip(String weaponName){
        player.equip(weaponName);
    }

    public void attack() {
        player.attack();
    }

    public void eat(String foodName){
        player.eat(foodName);
    }

    public void viewInventory() {
        player.viewInventory();
    }

    public void playerHealth() {
        player.playerHealth();
    }

    public void dropItem(Room room, String itemName){
        player.dropItem(room, itemName);
    }

    public void takeItem(Room room, String itemToTake) {
        player.takeItem(room, itemToTake);
    }

    // ENEMIES:
    Enemy enemy1 = new Enemy("Lvl 10 crook", "Human - bandit", 20, (new MeleeWeapon("Broken dagger", "dagger", 5, 1)));

}