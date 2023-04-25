package GameElement.characters.enemies;

import GameElement.Core;
import GameElement.House;
import GameElement.Pet;
import GameElement.Wand;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrollTest {

    @Test
    void testAttack_Successful() {
        // Arrange
        Troll troll = new Troll();
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        int expectedWizardHealth = wizard.getLifePoint() - troll.getDamage();

        // Act
        troll.attack(wizard);

        // Assert
        assertTrue(wizard.getLifePoint() < expectedWizardHealth);
    }

    @Test
    void testAttack_Unsuccessful() {
        // Arrange
        Troll troll = new Troll();
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        wizard.setResistanceBonus(100);
        int expectedWizardHealth = wizard.getLifePoint();

        // Act
        troll.attack(wizard);

        // Assert
        assertEquals(expectedWizardHealth, wizard.getLifePoint());
    }



    @Test
    void testWhatAWizardCanDoAgainstMe() {
        // Arrange
        Troll troll = new Troll();

        // Act
        String expectedAction = "Jeter des bouts de bois";
        String actualAction = troll.whatAWizardCanDoAgainstMe();

        // Assert
        assertEquals(expectedAction, actualAction);
    }

    @Test
    void testWhichFriendsCanTheWizardHave() {
        // Arrange
        Troll troll = new Troll();
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);

        // Act
        int expectedFriends = 0;
        int actualFriends = troll.whichFriendsCanTheWizardHave(wizard).size();

        // Assert
        assertEquals(expectedFriends, actualFriends);
    }

}
