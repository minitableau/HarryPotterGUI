package GameElement.items;

import GameElement.characters.Wizard;

public class ResistancePotion extends Potion {

    public ResistancePotion() {
        super("Potion de résistance", "résistance", 5, 30);
    }

    @Override
    public void use(Wizard wizard) {
        wizard.setResistanceBonus(wizard.getResistanceBonus() + this.getValue() + (this.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
    }

    @Override
    public String toString() {
        return "La potion de résistance, vous ajoute : " + this.getValue() + "% de résistance, son coût est de " + this.getCost() + " mornilles.";
    }
}
