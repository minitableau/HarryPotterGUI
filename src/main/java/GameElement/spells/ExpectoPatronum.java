package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Dementor;
import utils.MathUtils;

public class ExpectoPatronum extends Spell {
    public ExpectoPatronum() {
        super("ExpectoPatronum");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof Dementor dementor) {
            castOnDetraqueur(wizard, dementor);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnDetraqueur(Wizard wizard, Dementor dementor) {
        int chanceOfSuccess = 0;
        if (dementor.getDistance() <= 5) {
            System.out.println("Vous utilisez Expecto Patronum pour mettre les détraqueurs en fuite !");
            chanceOfSuccess = getChanceOfSuccess(wizard, dementor);
            System.out.println("Vous êtes à " + dementor.getDistance() + " mètres des détraqueurs. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Vous arrivez à invoquer votre patronus ce qui fait fuir les détraqueurs");
                dementor.die();
            } else {
                System.out.println("Vous ratez votre sort.");
            }
        }else {
            System.out.println("Vous êtes à " + dementor.getDistance() + " mètres des détraqueurs. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser votre patronus et qu'il effraie quelqu'un \nil faut être à 5 mètres ou moins pour que le sort est une chance de réussir et que plus vous êtes proche plus vous augmenter vos chances.");
        }
    }
}
