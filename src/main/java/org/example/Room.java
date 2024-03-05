package org.example;
public class Room {
    private String roomNumber;
    private String roomDescription;
    private Room roomNorth;
    private Room roomEast;
    private Room roomSouth;
    private Room roomWest;


    //Constructor
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
}
