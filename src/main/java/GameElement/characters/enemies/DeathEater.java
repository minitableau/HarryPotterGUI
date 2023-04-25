package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class DeathEater extends Enemy {

    public DeathEater() {
        super("des Mangemorts", "Humain", 5, 10);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'ils vous touchent est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            System.out.println("Les mangemorts, vous touchent et vous enlèvent " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Les mangemorts vous ont vaincu.");
            }
        } else {
            System.out.println("Les mangemorts lancent des sorts mais vous arrivez à les éviter.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 5 + (5 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des compas sur les mangemorts. Ils perdent " + damage + " points de vie");
        this.takeDamage(damage);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des compas";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return new ArrayList<>();

    }
}
