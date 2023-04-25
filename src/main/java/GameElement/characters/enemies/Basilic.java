package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import Level.Level2;
import utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Basilic extends Enemy {
    public Basilic() {
        super("un Basilic de Salazar Serpentard", "Basilic", 3, 30);
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
            System.out.println("La queue du Basilic, vous frappe et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le basilic vous a vaincu.");
            }
        } else {
            System.out.println("Le basilic essaie de vous frapper avec ca queue mais vous arrivez à l'éviter.");
        }
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des pierres";
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 1 + (1 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des pierre sur le Basilic. Il perd " + damage + " points de vie");
        this.takeDamage(damage);
    }

    @Override
    public void onWizardBackpackOpen(Wizard wizard) {
        if (this.getDistance() == 1 && Level2.tooth) {
            System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
            this.takeDamage(50 + (50 * wizard.getPowerBonus()) / 100);
            if (this.isAlive()) {
                System.out.println("Cependant vous êtes repoussez d'un mètre.");
                this.setDistance(2);
            }
        }
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return new ArrayList<>();

    }
}

