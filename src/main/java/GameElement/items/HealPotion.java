package GameElement.items;

import GameElement.characters.Wizard;

public class HealPotion extends Potion {

    public HealPotion() {
        super("Potion de soin", "soin", 40, 10);
    }

    @Override
    public void use(Wizard wizard) {
        if (wizard.getLifePoint() >= 60) {
            wizard.setLifePoint(wizard.getMaxLifePoint());
        } else
            wizard.setLifePoint(wizard.getLifePoint() + this.getValue() + (this.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
    }

    @Override
    public String toString() {
        return "La potion de soin, vous ajoute : " + this.getValue() + " de vie, son coût est de " + this.getCost() + " mornilles.";
    }
}
