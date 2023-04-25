package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Voldemort;
import utils.MathUtils;

public class AvadaKedavra extends ForbiddenSpell {
    public AvadaKedavra() {
        super("Avada Kedavra");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof Voldemort voldemort) {
            castOnVoldemort(wizard, voldemort);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    public void castOnVoldemort(Wizard wizard, Voldemort voldemort) {
        int chanceOfSuccess;
        System.out.println("Vous utilisez AvadaKedavra sur Voldemort!");
        chanceOfSuccess = getChanceOfSuccess(wizard, voldemort);
        System.out.println("Vous êtes à " + voldemort.getDistance() + " mètres de Voldemort. Votre chance de réussite est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            System.out.println("Votre sort atteint Voldemort, il perd " + (30 + (30 * wizard.getPowerBonus()) / 100) + " points de vie.");
            int damage = 30 + (30 * wizard.getPowerBonus()) / 100;
            voldemort.takeDamage(damage);
        } else {
            System.out.println("Vous ratez votre sort de justesse.");
        }
    }
}
