package GameElement.items;

import GameElement.characters.Wizard;

public class DamagePotion extends Potion {

    public DamagePotion() {
        super("Potion de dégât", "dégât", 10, 30);
    }

    @Override
    public void use(Wizard wizard) {
        wizard.setPowerBonus(wizard.getPowerBonus() + this.getValue() + (this.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
    }

    @Override
    public String toString() {
        return "La potion de dégât, vous ajoute : " + this.getValue() + "% de dégât, son coût est de " + this.getCost() + " mornilles.";
    }
}
