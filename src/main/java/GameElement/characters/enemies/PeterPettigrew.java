package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class PeterPettigrew extends Enemy {

    public PeterPettigrew() {
        super("Peter Pettigrew", "Humain", 10, 20);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            System.out.println("PeterPettigrew et Voldemort, vous touche et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! PeterPettigrew et Voldemort vous ont vaincu.");
            }
        } else {
            System.out.println("PeterPettigrew et Voldemort lance leurs sort mais vous arrivez à l'éviter.");
        }

    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 0 + (0 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des plaques funéraire sur le Peter Pettigrew. Il perd " + damage + " points de vie");
        this.takeDamage(damage);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des plaques funéraires";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return new ArrayList<>();

    }
}

