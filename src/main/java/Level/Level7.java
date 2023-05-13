package Level;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.BellatrixLestrange;
import GameElement.characters.enemies.Boss;
import GameElement.characters.enemies.MinervaMcGonagall;
import GameElement.characters.enemies.Voldemort;
import GameElement.spells.Confringo;
import GameElement.spells.Expelliarmus;
import GameElement.spells.PetrificusTotalus;
import com.example.harrypottergui.vue.StartController;
import utils.ScrollingText;


public class Level7 extends AbstractLevel {

    public static boolean expelliarmusOn = false;
    public static boolean petrificusTotalus = false;

    @Override
    public void startLevel(Wizard wizard) {
        Boss enemy;
        String LearnSpell = "Depuis la tour, vous pouvez apercevoir et entendre des étudiants ce battre dans les jardins ceux-ci utilisent des sorts dont vous avez déjà entendu parler mais pas \npratiqué : PetrificusTotalus qui permet d'immobiliser quelqu'un, Confringo qui permet de faire exploser quelque chose ou quelqu'un et pour finir Expelliarmus qui permet \nde se protéger du sort Avada Kedavra . Vous les retenez car ils pourraient vous être utile.";
        ScrollingText.printWithDelay(LearnSpell);
        wizard.addSpell(new Confringo());
        wizard.addSpell(new PetrificusTotalus());
        wizard.addSpell(new Expelliarmus());
        if (Level6.areYouDeathEater) {
            String NewFight = "Vous descendez dans la cours de Poudlard dans laquelle vous trouvez le professeur McGonagall qui essaie de vous arretez. Vous engagez le combat seul contre elle \npour montrer de quoi vous etes capable.";
            ScrollingText.printWithDelay(NewFight);
            StartController.enemy = new MinervaMcGonagall();
//            wizard.fight(enemy);
        } else {
            String NewFight = "Vous descendez dans la cours de Poudlard dans laquelle vous trouvez Voldmort et Bellatrix Lestrange. Bellatrix Lestrange se place alors devant Voldemort. \nVous allez donc devoir vaincre Bellatrix Lestrange pour pouvoir atteindre Voldemort.";
            ScrollingText.printWithDelay(NewFight);
            StartController.enemy = new BellatrixLestrange();
//            wizard.fight(enemy);
            if (!wizard.isAlive()) return;
            String FightContinue = "Vous pouvez désormais attaquer Voldemort.";
            ScrollingText.printWithDelay(FightContinue);
            StartController.enemy = new Voldemort();
//            wizard.fight(enemy);
        }
        if (!wizard.isAlive()) return;
        String Victory = "Vous avez réussi à survive à tous les niveaux, vous avez fini le jeu. Bravo !";
        ScrollingText.printWithDelay(Victory);
    }
}