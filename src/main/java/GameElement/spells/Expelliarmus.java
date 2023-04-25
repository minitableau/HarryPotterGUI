package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Voldemort;
import Level.Level7;

public class Expelliarmus extends Spell {
    public Expelliarmus() {
        super("Expelliarmus");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof Voldemort voldemort) {
            castOnVoldemort(wizard, voldemort);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnVoldemort(Wizard wizard, Voldemort voldemort) {
        System.out.println("Vous utilisez Expelliarmus de manière à vous protéger des potentiels Avada Kedavra !");
        Level7.expelliarmusOn = true;
    }
}
