package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import com.example.harrypottergui.vue.CharacterRepresentation;
import com.example.harrypottergui.vue.FightBoard;
import javafx.animation.Timeline;
import utils.MathUtils;
import utils.ScrollingInWindow;

import java.util.List;

public class Dementor extends Enemy {
    public Dementor() {
        super("des Détraqueurs", "Détraqueurs", 8, 20, "/images/Dementor.png");
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome();

        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (sameHomeWizardFriends.size() + 1) + " contre le détraqueur. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");

        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            Timeline task = FightBoard.setBarWizard((wizard), ((CharacterRepresentation) FightBoard.HBhero.getChildren().get(0)).getBarreDeVie());
            task.playFromStart();
            System.out.println("Le détraqueur reveille en vous des souvenirs très douloureux vous perdez " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le détraqueur vous a vaincu.");
                FightBoard.gameStage.close();
                ScrollingInWindow.stagetext.close();
            }
        } else {
            System.out.println("Le détraqueur essaie de vous rappelez de mauvais souvenir mais vous arrivez à résister.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 0 + (0 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des bouts de bois sur le détraqueur. Il perd " + damage + " points de vie");
        this.takeDamage(damage);
        Timeline task = FightBoard.setBarEnemy((this), ((CharacterRepresentation) FightBoard.HBenemy.getChildren().get(0)).getBarreDeVie());
        task.playFromStart();
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des bouts de bois";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return wizard.getFriendsSameHome();

    }

}
