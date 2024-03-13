package org.example;
import java.util.ArrayList;

public class Room {
    private String roomNumber;
    private String roomDescription;
    private Room roomNorth;
    private Room roomEast;
    private Room roomSouth;
    private Room roomWest;
    private ArrayList<Item> items = new ArrayList<>();

    public Room(String roomNumber, String roomDescription) {
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Room getRoomNorth() {
        return roomNorth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(String longName, String shortName) {
        items.add(new Item(longName,shortName));
    }

    public void addFood(String longName, String shortName, int healthPoints) {
        items.add(new Food(longName, shortName, healthPoints));
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
