package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractEnemy {


    public Enemy(String name, String type, int distance, int damage, String url) {
        super(name, type, distance, damage, url);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Attaquer";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
        return new ArrayList<>();
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
    }

    @Override
    public void onWizardBackpackOpen(Wizard wizard) {
    }

    @Override
    public void attack(Character character) {
    }

}
