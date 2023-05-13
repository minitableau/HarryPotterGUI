package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.BellatrixLestrange;
import Level.Level7;
import com.example.harrypottergui.vue.CharacterRepresentation;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import javafx.animation.Timeline;
import utils.MathUtils;

public class Confringo extends Spell {
    public Confringo() {
        super("Confringo");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof BellatrixLestrange bellatrixLestrange) {
            castOnBellatrixLestrange(wizard, bellatrixLestrange);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnBellatrixLestrange(Wizard wizard, BellatrixLestrange bellatrixLestrange) {
        int chanceOfSuccess = 0;
        if (Level7.petrificusTotalus) {
            System.out.println("Vous utilisez Confringo pour faire exploser Bellatrix Lestrange !");
            chanceOfSuccess = getChanceOfSuccess(wizard, bellatrixLestrange);
            System.out.println("Vous êtes à " + bellatrixLestrange.getDistance() + " mètres de Bellatrix Lestrange. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Vous sort atteint Bellatrix Lestrange et la tue");
                bellatrixLestrange.die();
                Timeline task = FightBoard.setBarEnemy((StartController.enemy), ((CharacterRepresentation) FightBoard.HBenemy.getChildren().get(0)).getBarreDeVie());
                task.playFromStart();
            } else {
                System.out.println("Vous ratez votre sort.");
            }
        }else {
            System.out.println("Vous êtes à " + bellatrixLestrange.getDistance() + " mètres de Bellatrix Lestrange. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Confringo et qu'il touche quelqu'un \nil faut que Bellatrix Lestrange soit immobilisé par Petrificus Totalus et que plus vous êtes proche plus vous augmenter vos chances.");
        }
    }
}
