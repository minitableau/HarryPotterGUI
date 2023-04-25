package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractEnemy {


    public Enemy(String name, String type, int distance, int damage) {
        super(name, type, distance, damage);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Attaquer";
    }

    @Override
    public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {return new ArrayList<>();}

    @Override
    public void onWizardAttack(Wizard wizard) {

    }

    @Override
    public void onWizardBackpackOpen(Wizard wizard) {
    }

    @Override
    public void attack(Character character) {
    }

//    public static Enemy troll = new Enemy("Troll des montagnes", "Troll", 10, 5);//30
//    public static Enemy basilic = new Enemy("Basilic de Salazar Serpentard", "Basilic", 3, 5);//30
//    public static Enemy dementors = new Enemy("Détraqueurs", "Détraqueurs", 8, 5);//20
//    public static Enemy peterPettigrew = new Enemy("Peter Pettigrew", "Humain", 10, 5);//20
//    public static Enemy doloresOmbrage = new Enemy("Dolores Ombrage", "Humain", 4, 5);//10
//    public static Enemy deathEater = new Enemy("DeathEater", "Humain", 5, 5);//10
}
