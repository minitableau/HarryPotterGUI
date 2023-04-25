package GameElement.items;

import GameElement.characters.Wizard;

public abstract class Potion {
    private final String name;
    private final String type;
    private final int value;
    private int cost;

    public Potion(String name, String type, int value, int cost) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.cost = cost;
    }

    public abstract void use(Wizard wizard);

    public abstract String toString();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}

