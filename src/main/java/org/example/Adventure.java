package org.example;
public class Adventure {
    private MapConstruction map = new MapConstruction();

    public void look() {
        System.out.println(map.getCurrentRoom().getRoomDescription());
        System.out.println("You look around and notice:");
        for (Item item : map.getCurrentRoom().getItems()) {
            System.out.println("- " + item.getLongName());
        }
    }

    public MapConstruction getMap() {
        return map;
    }
}