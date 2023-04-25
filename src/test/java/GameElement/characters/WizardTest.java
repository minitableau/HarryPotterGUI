package GameElement.characters;

import GameElement.Wand;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WizardTest {

    private Wizard wizard;

    @Before
    public void setUp() {
        wizard = new Wizard("Harry Potter", null, new Wand(), null);
    }

    @Test
    public void testConstructor() {
        assertNotNull(wizard.getBackpack());
        assertEquals(200, wizard.getHousePoints());
        assertEquals(0, wizard.getKnownSpells().size());
        assertEquals(0, wizard.getFriends().size());
        assertEquals(0, wizard.getAccuracyBonus());
        assertEquals(0, wizard.getPowerBonus());
        assertEquals(0, wizard.getEfficiencyPotionsBonus());
        assertEquals(0, wizard.getResistanceBonus());
        assertEquals(0, wizard.getMana());
        assertEquals(100, wizard.getMoney());
    }


    @Test
    void testToString() {

        Wizard wizard = new Wizard("Harry Potter", null, new Wand(), null);

        assertEquals("Statistiques de Harry Potter : " + "❤️ " + 100 + "/" + 100 + " |" + " 💧 " + 0 + "/100 |" + " 🛡️ + " + 0 + "% |" + " 💪 + " + 0 + "% |" + " 🎯 + " + 0 + "% |" + " ⚗️ + " + 0 + "% |" + " 💵 " + 100 + "$", wizard.toString());
    }

    @Test
    void testTakeDamage() {
        Wizard wizard = new Wizard("Harry Potter", null, new Wand(), null);

        wizard.takeDamage(10);

        assertEquals(90, wizard.getLifePoint());
    }

    @Test
    void setWand() {
    }
}
