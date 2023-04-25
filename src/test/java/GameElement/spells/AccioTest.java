package GameElement.spells;

import GameElement.Core;
import GameElement.House;
import GameElement.Pet;
import GameElement.Wand;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Basilic;
import Level.Level2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccioTest {

    @Test
    public void testCastOnBasilic_success() {
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        Basilic basilic = new Basilic();
        basilic.setDistance(10);

        Accio accio = new Accio();
        accio.castOnBasilic(wizard, basilic);

        assertTrue(Level2.tooth);
    }

    @Test
    public void testCastOnBasilic_failure() {
        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        Basilic basilic = new Basilic();
        basilic.setDistance(50);

        Accio accio = new Accio();
        accio.castOnBasilic(wizard, basilic);

        assertFalse(Level2.tooth);
    }


    @Test
    public void testName() {
        Accio accio = new Accio();
        assertEquals("Accio", accio.getName());
    }
}
