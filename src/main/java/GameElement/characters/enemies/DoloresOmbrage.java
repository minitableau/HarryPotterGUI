package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.items.Item;
import Level.Level5;
import utils.MathUtils;

import java.util.List;

public class DoloresOmbrage extends Enemy {
    public DoloresOmbrage() {
        super("Dolores Ombrage", "Humain", 4, 10);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome();
        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (sameHomeWizardFriends.size() + 1) + " contre Dolores Ombrage. La probabilité qu'elle vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            System.out.println("Dolores Ombrage, vous touche et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Dolores Ombrage vous à vaincu.");
            }
        } else {
            System.out.println("Dolores Ombrage lance un sort mais vous arrivez à l'éviter.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 0 + (0 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des stylos sur Dolores Ombrage. Elle perd " + damage + " points de vie");
        this.takeDamage(damage);
    }

    @Override
    public void onWizardBackpackOpen(Wizard wizard) {
        if (this.getDistance() <= 3 && Level5.firework) {
            System.out.println("Vous ramassez un feu d'artifice.");
            wizard.getBackpack().addItem(Item.firework);
            Level5.firework = false;
        }
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des stylos";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return wizard.getFriendsSameHome();

    }
}
