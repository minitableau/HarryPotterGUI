package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.BellatrixLestrange;
import Level.Level7;
import utils.MathUtils;

public class PetrificusTotalus extends Spell {
    public PetrificusTotalus() {
        super("Petrificus Totalus");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof BellatrixLestrange bellatrixLestrange) {
            castOnBellatrixLestrange(wizard, bellatrixLestrange);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnBellatrixLestrange(Wizard wizard, BellatrixLestrange bellatrixLestrange) {
        int chanceOfSuccess = 0;
        if (bellatrixLestrange.getDistance() <= 7) {
            System.out.println("Vous utilisez Petrificus Totalus pour immobiliser Bellatrix Lestrange !");
            chanceOfSuccess = getChanceOfSuccess(wizard, bellatrixLestrange);
            System.out.println("Vous êtes à " + bellatrixLestrange.getDistance() + " mètres de Bellatrix Lestrange. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Vous sort atteint Bellatrix Lestrange et la rend immobile");
                Level7.petrificusTotalus = true;
            } else {
                System.out.println("Vous ratez votre sort.");
            }
        }else {
            System.out.println("Vous êtes à " + bellatrixLestrange.getDistance() + " mètres de Bellatrix Lestrange. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Petrificus Totalus et qu'il touche quelqu'un \nil faut être à 7 mètres ou moins pour que le sort est une chance de réussir et que plus vous êtes proche plus vous augmenter vos chances.");
        }
    }
}
