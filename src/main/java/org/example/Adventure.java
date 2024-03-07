package org.example;
public class Adventure {
    private MapConstruction map = new MapConstruction();

    public void look() {
        System.out.println(map.getCurrentRoom().getRoomDescription());
    }

    public MapConstruction getMap() {
        return map;
    }
}