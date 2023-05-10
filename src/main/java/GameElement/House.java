package GameElement;

import GameElement.characters.Wizard;
import utils.ConsoleColors;

public enum House {
    GRYFFINDOR("Gryffondor"),
    HUFFLEPUFF("Poufsouffle"),
    RAVENCLAW("Serdaigle"),
    SLYTHERIN("Serpentard");


    final String name;

    House(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setHouseBonus(Wizard wizard) {
        House house = wizard.getHouse();
        switch (house) {
            case HUFFLEPUFF -> wizard.setEfficiencyPotionsBonus(10);
            case SLYTHERIN -> wizard.setPowerBonus(10);
            case GRYFFINDOR -> wizard.setResistanceBonus(10);
            case RAVENCLAW -> wizard.setAccuracyBonus(10);
        }
    }


}
