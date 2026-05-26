package ua.khpi.oop.lab12.model;

public class GameItem {
    private String name;
    private Rarity rarity;
    private double value;

    public GameItem(String name, Rarity rarity, double value) {
        this.name = name;
        this.rarity = rarity;
        this.value = value;
    }

    public String getName() { return name; }
    public Rarity getRarity() { return rarity; }
    public double getValue() { return value; }

    public String toString() {
        return String.format("%s рідкість %s  вартість %.1f", name, rarity, value);
    }
}