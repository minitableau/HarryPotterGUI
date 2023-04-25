package GameElement.characters;

public abstract class Character {
    private final String name;
    private int lifePoint = 100;

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);


    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getMaxLifePoint() {
        return 100;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        lifePoint -= damage;
    }

    public void heal(int heal) {
        lifePoint += heal;
    }

    public boolean isAlive() {
        return lifePoint > 0;
    }

    public void die() {
        lifePoint = 0;
    }



}
