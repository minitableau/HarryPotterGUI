

package GameElement.characters.enemies;

import GameElement.Core;
import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.spells.AvadaKedavra;
import Level.Level7;
import utils.MathUtils;

import java.util.List;

public class Voldemort extends Boss {

    public Voldemort() {
        super("Voldemort", "Human", 10, 10);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        int chanceOfSuccessAvadaKedavra = 50;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccessAvadaKedavra) {
            if (!wizard.hasKnownSpell("Avada Kedavra")) {
                System.out.println("Voldemort vous lance Avada Kedavra ce qui vous permet d'apprendre la prononciation exact de ce sort, vous pouvez désormais l'utiliser.");
                wizard.addSpell(new AvadaKedavra());
            }
            if (!Level7.expelliarmusOn) {
                if (wizard.getWand().getCore() == Core.PhoenixFeather) {
                    System.out.println("Vous avez de la chance Voldemort aurait du vous tuer avec Avada Kedavra mais il ne peut pas car vous avez une baguette avec un coeur de Phénix.");
                } else {
                    wizard.die();
                    System.out.println("Voldemort vous a tué avec Avada Kedavra.");
                }
            } else {
                System.out.println("Vous avez très bien joué Voldemort aurait du vous tuer avec Avada Kedavra mais vous vous êtes protéger avec Expelliarmus durant le combat.");
                Level7.expelliarmusOn = false;
                System.out.println("Un conseil protéger vous à nouveau avec Expelliarmus car celui-ci ne fait donc plus effet et vous êtes donc à nouveau vulnérable.");
            }
        } else if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            System.out.println("Voldemort, vous touche et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Voldemort vous a vaincu.");
            }
        } else {
            System.out.println("Voldemort lance un sort mais vous arrivez à l'éviter.");
        }

    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des pierres";
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 1 + (1 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des pierre sur Bellatrix Lestrange. Elle perd " + damage + " points de vie");
        this.takeDamage(damage);
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return wizard.getFriendsSameHome();

    }
}

