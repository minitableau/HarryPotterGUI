package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.List;

public class BellatrixLestrange extends Boss {

    public BellatrixLestrange() {
        super("Bellatrix Lestrange", "Human", 10, 20);
    }

    @Override
    public void attack(Character character) { // same McGonagall mais modif texte
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'elle vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            System.out.println("Bellatrix Lestrange, vous touche et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Bellatrix Lestrange vous a vaincu.");
            }
        } else {
            System.out.println("Bellatrix Lestrange lance un sort mais vous arrivez à l'éviter.");
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

