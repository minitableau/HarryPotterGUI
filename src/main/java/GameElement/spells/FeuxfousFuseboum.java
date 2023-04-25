package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.DoloresOmbrage;
import Level.Level5;
import utils.MathUtils;

public class FeuxfousFuseboum extends Spell {
    public FeuxfousFuseboum() {
        super("FeuxfousFuseboum");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof DoloresOmbrage doloresOmbrage) {
            castOnDoloresOmbrage(wizard, doloresOmbrage);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnDoloresOmbrage(Wizard wizard, DoloresOmbrage doloresOmbrage) { //same castOnBasilic dif dialogue + firework
        int chanceOfSuccess = 0;
        System.out.println("Vous utilisez Feuxfous Fuseboum sur le bureau de Dolores Ombrage!");
        chanceOfSuccess = getChanceOfSuccess(wizard, doloresOmbrage);
        System.out.println("Vous êtes à " + doloresOmbrage.getDistance() + " mètres de son bureau. Votre chance de réussite est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            System.out.println("Votre sort atteint ca cible, il crée une fusée d'artifice à ramasser à 3m devant Dolores Ombrage.");
            Level5.firework = true;
        } else {
            System.out.println("Vous ratez votre sort de justesse.");
        }
    }

}
