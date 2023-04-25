package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.AbstractEnemy;

public abstract class AbstractSpell {
    private String name;

    public AbstractSpell(String name) {
        this.name = name;
    }

    public abstract void cast(Wizard wizard, Character target);

    protected int getChanceOfSuccess(Wizard wizard, Character target) {
        if (target instanceof AbstractEnemy targetEnemy) {
            return 100 - targetEnemy.getDistance() * 5 + wizard.getAccuracyBonus() + 10;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
