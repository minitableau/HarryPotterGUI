package GameElement;

import GameElement.characters.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseTest {

    Wizard wizard1;
    Wizard wizard2;
    Wizard wizard3;
    Wizard wizard4;

    @BeforeEach
    void setUp() {
        wizard1 = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.HUFFLEPUFF);
        wizard2 = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        wizard3 = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.GRYFFINDOR);
        wizard4 = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.RAVENCLAW);
    }

    @Test
    void setHouseBonus() {
        House house = wizard1.getHouse();
        switch (house) {
            case HUFFLEPUFF -> wizard1.setEfficiencyPotionsBonus(10);
            case SLYTHERIN -> wizard1.setPowerBonus(10);
            case GRYFFINDOR -> wizard1.setResistanceBonus(10);
            case RAVENCLAW -> wizard1.setAccuracyBonus(10);
        }
        assertEquals(10, wizard1.getPowerBonus());

        House house2 = wizard2.getHouse();
        switch (house2) {
            case HUFFLEPUFF -> wizard2.setEfficiencyPotionsBonus(10);
            case SLYTHERIN -> wizard2.setPowerBonus(10);
            case GRYFFINDOR -> wizard2.setResistanceBonus(10);
            case RAVENCLAW -> wizard2.setAccuracyBonus(10);
        }

        assertEquals(10, wizard2.getPowerBonus());

        House house3 = wizard3.getHouse();
        switch (house3) {
            case HUFFLEPUFF -> wizard3.setEfficiencyPotionsBonus(10);
            case SLYTHERIN -> wizard3.setPowerBonus(10);
            case GRYFFINDOR -> wizard3.setResistanceBonus(10);
            case RAVENCLAW -> wizard3.setAccuracyBonus(10);
        }

        assertEquals(10, wizard3.getPowerBonus());

        House house4 = wizard4.getHouse();

        switch (house4) {
            case HUFFLEPUFF -> wizard4.setEfficiencyPotionsBonus(10);
            case SLYTHERIN -> wizard4.setPowerBonus(10);
            case GRYFFINDOR -> wizard4.setResistanceBonus(10);
            case RAVENCLAW -> wizard4.setAccuracyBonus(10);
        }

        assertEquals(10, wizard4.getPowerBonus());
    }
}