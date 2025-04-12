package house;

import house.generics.House;

public class HousePatternMain{
    public static void main(String[] args) {
        // Building a simple house
        House simpleHouse = new House.HouseBuilder("Concrete", "Wood", "Tiles")
        .build();
        System.out.println(simpleHouse);
        
        // chiamo i metodi opzionali e flaggo con true se lo voglio nel mio object
        // si conclude sempre con .build();
        House luxuryHouse = new House.HouseBuilder("Concrete", "Brick", "Shingles")
        .setGarage(true)
        .setSwimmingPool(true)
        .setGarden(true)
        .build();
        System.out.println(luxuryHouse);
    }
}