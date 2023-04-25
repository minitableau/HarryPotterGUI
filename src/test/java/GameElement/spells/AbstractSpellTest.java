package GameElement.spells;

import GameElement.*;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.AbstractEnemy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractSpellTest {

    @Test
    public void testGetChanceOfSuccessWithEnemyTarget() {
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        AbstractEnemy enemy = new AbstractEnemy("Voldemort", "Human", 10, 5) {
            @Override
            public String whatAWizardCanDoAgainstMe() {
                return null;
            }

            @Override
            public List<Friend> whichFriendsCanTheWizardHave(Wizard wizard) {
                return null;
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
        };
        AbstractSpell spell = new AbstractSpell("Expelliarmus") {
            @Override
            public void cast(Wizard wizard, Character target) {

            }
        };

        int expected = 100 - enemy.getDistance() * 5 + wizard.getAccuracyBonus() + 10;
        int actual = spell.getChanceOfSuccess(wizard, enemy);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetChanceOfSuccessWithNonEnemyTarget() {
        Wizard wizard = new Wizard("Hermione Granger", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        Character character = new Character("Ron Weasley") {
            @Override
            public void attack(Character character) {

            }
        };
        AbstractSpell spell = new AbstractSpell("Wingardium Leviosa") {
            @Override
            public void cast(Wizard wizard, Character target) {

            }
        };

        int expected = 0;
        int actual = spell.getChanceOfSuccess(wizard, character);

        assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        AbstractSpell spell = new AbstractSpell("Lumos") {
            @Override
            public void cast(Wizard wizard, Character target) {

            }
        };

        String expected = "Nox";
        spell.setName(expected);
        String actual = spell.getName();

        assertEquals(expected, actual);
    }

}
