package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.PeterPettigrew;
import GameElement.characters.enemies.Troll;
import utils.MathUtils;

public class WindgardiumLeviosa extends Spell {
    public WindgardiumLeviosa() {
        super("Windgardium Leviosa");
    }

    @Override
    public void cast(Wizard wizard, Character target) {
        if (target instanceof Troll troll) {
            castOnTroll(wizard, troll);
        } else if (target instanceof PeterPettigrew peterPettigrew) {
            castOnPeterPettigrew(wizard, peterPettigrew);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }
    }

    private void castOnTroll(Wizard wizard, Troll troll) {
        int chanceOfSuccess = 0;
        if (troll.getDistance() <= 7) {
            System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
            chanceOfSuccess = getChanceOfSuccess(wizard, troll);
            System.out.println("Vous êtes à " + troll.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
                troll.die();
            } else {
                System.out.println("Vous ratez votre sort de justesse.");
            }
        } else {
            System.out.println("Vous êtes à " + troll.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
        }
    }

    private void castOnPeterPettigrew(Wizard wizard, PeterPettigrew peterPettigrew) {
        int chanceOfSuccess = 0;
        if (peterPettigrew.getDistance() <= 7) {
            System.out.println("Vous utilisez Windgardium Leviosa sur le portolion!");
            chanceOfSuccess = getChanceOfSuccess(wizard, peterPettigrew);
            System.out.println("Vous êtes à " + peterPettigrew.getDistance() + " mètres du portolion. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Votre sort atteint le portolion, vous l'amenez à vous et l'utiliser pour vous enfuir.");
                peterPettigrew.die();
            } else {
                System.out.println("Vous ratez votre sort de justesse.");
            }
        } else {
            System.out.println("Vous êtes à " + peterPettigrew.getDistance() + " mètres du portolion. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
        }
    }
}
