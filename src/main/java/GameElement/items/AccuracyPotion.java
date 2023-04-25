package GameElement.items;

import GameElement.characters.Wizard;

public class AccuracyPotion extends Potion {

    public AccuracyPotion() {
        super("Potion de précision", "précision", 5, 30);
    }

    @Override
    public void use(Wizard wizard) {
        wizard.setAccuracyBonus(wizard.getAccuracyBonus() + this.getValue() + (this.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
    }

    @Override
    public String toString() {
        return "La potion de précision, vous ajoute : " + this.getValue() + "% de précision, son coût est de " + this.getCost() + " mornilles.";
    }
}
