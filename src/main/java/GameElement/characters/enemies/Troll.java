package GameElement.characters.enemies;

import Game.Game;
import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import com.example.harrypottergui.vue.CharacterRepresentation;
import com.example.harrypottergui.vue.FightBoard;
import javafx.animation.Timeline;
import utils.MathUtils;
import utils.ScrollingInWindow;

import java.util.List;

public class Troll extends Enemy {
    public Troll() {
        super("un Troll des montagnes", "Troll", 10, 30, "/images/troll.png");
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome(List.of("Fleur Delacour"));

        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (int) (sameHomeWizardFriends.size() + 1) + " contre le troll. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int damage = this.getDamage() - (this.getDamage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(damage);
            Timeline task = FightBoard.setBarWizard((wizard), ((CharacterRepresentation) FightBoard.HBhero.getChildren().get(0)).getBarreDeVie());
            task.playFromStart();
            System.out.println("La massue du troll, vous frappe et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le troll vous a vaincu.");
                FightBoard.gameStage.close();
                ScrollingInWindow.stagetext.close();
            }
        } else {
            System.out.println("Le troll essaie de vous frapper avec ca massue mais vous arrivez à l'éviter.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int damage = 20 + (20 * wizard.getPowerBonus()) / 100;
        if (Game.gui) {
            ScrollingInWindow.setMessage("Vous jetez des bouts de bois sur le troll. Il perd " + damage + " points de vie");
        }
        System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + damage + " points de vie");
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
        return wizard.getFriendsSameHome(List.of("Fleur Delacour"));

    }
}
