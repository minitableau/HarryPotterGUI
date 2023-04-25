package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Basilic;
import Level.Level2;
import utils.MathUtils;

public class Accio extends Spell {
    public Accio() {
        super("Accio");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof Basilic basilic) {
            castOnBasilic(wizard, basilic);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    public void castOnBasilic(Wizard wizard, Basilic basilic) {
        int chanceOfSuccess = 0;

        System.out.println("Vous utilisez Accio en visant la machoire du basilic !");
        chanceOfSuccess = getChanceOfSuccess(wizard, basilic);
        System.out.println("Vous êtes à " + basilic.getDistance() + " mètres du basilic. Votre chance de réussite est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            System.out.println("Votre sort atteint les dents du basilic, une d'entre elles se décroche commence à venir vers vous mais vous la faite tomber au sol à 1m du basilic.");
            Level2.tooth = true;
        } else {
            System.out.println("Vous ratez votre sort de justesse.");
        }

    }
}
