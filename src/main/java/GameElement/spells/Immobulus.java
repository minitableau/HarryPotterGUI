
package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;

public class Immobulus extends Spell {
    public Immobulus() {
        super("Immobulus");
    }

    @Override
    public void cast(Wizard wizard, Character target) {
        System.out.println("Le sort n'a eu aucun effet sur " + target.getName());
    }
}
