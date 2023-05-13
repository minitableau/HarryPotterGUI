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

public class BellatrixLestrange extends Boss {

    public BellatrixLestrange() {
        super("Bellatrix Lestrange", "Human", 10, 20,"/images/BellatrixLestrange.png");
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
            Timeline task = FightBoard.setBarWizard((wizard), ((CharacterRepresentation) FightBoard.HBhero.getChildren().get(0)).getBarreDeVie());
            task.playFromStart();
            System.out.println("Bellatrix Lestrange, vous touche et vous enlève " + damage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Bellatrix Lestrange vous a vaincu.");
                FightBoard.gameStage.close();
                ScrollingInWindow.stagetext.close();
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
        Timeline task = FightBoard.setBarEnemy((this), ((CharacterRepresentation) FightBoard.HBenemy.getChildren().get(0)).getBarreDeVie());
        task.playFromStart();
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return wizard.getFriendsSameHome();

    }
}

