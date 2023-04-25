package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;

import java.util.List;

public abstract class AbstractEnemy extends Character {
    private final String type;
    private int distance;
    private int damage;

    public AbstractEnemy(String name, String type, int distance, int damage) {
        super(name);
        this.type = type;
        this.distance = distance;
        this.damage = damage;
    }

    public abstract String whatAWizardCanDoAgainstMe();

    public abstract List<Friend> whichFriendsCanTheWizardHave(Wizard wizard);

    public abstract void onWizardAttack(Wizard wizard);

    public abstract void onWizardBackpackOpen(Wizard wizard);

    public String getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
