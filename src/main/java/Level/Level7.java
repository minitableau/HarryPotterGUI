package Level;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.BellatrixLestrange;
import GameElement.characters.enemies.MinervaMcGonagall;
import GameElement.characters.enemies.Voldemort;
import GameElement.spells.Confringo;
import GameElement.spells.Expelliarmus;
import GameElement.spells.PetrificusTotalus;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import utils.ScrollingInWindow;

import static utils.ScrollingInWindow.nextButton;


public class Level7 extends AbstractLevel {

    public static boolean expelliarmusOn = false;
    public static boolean petrificusTotalus = false;

    @Override
    public void startLevel(Wizard wizard) {
        String LearnSpell = "Depuis la tour, vous pouvez apercevoir et entendre des étudiants ce battre dans les jardins ceux-ci utilisent des sorts dont vous avez déjà entendu parler mais pas \npratiqué : PetrificusTotalus qui permet d'immobiliser quelqu'un, Confringo qui permet de faire exploser quelque chose ou quelqu'un et pour finir Expelliarmus qui permet \nde se protéger du sort Avada Kedavra . Vous les retenez car ils pourraient vous être utile.";
        ScrollingInWindow.printInWindow(LearnSpell);
        wizard.addSpell(new Confringo());
        wizard.addSpell(new PetrificusTotalus());
        wizard.addSpell(new Expelliarmus());
        nextButton.setOnAction(event81 -> {
            if (Level6.areYouDeathEater) {
                String NewFight = "Vous descendez dans la cours de Poudlard dans laquelle vous trouvez le professeur McGonagall qui essaie de vous arretez. Vous engagez le combat seul contre elle \npour montrer de quoi vous etes capable.";
                ScrollingInWindow.printInWindow(NewFight);
                nextButton.setOnAction(event82 -> {
                    StartController.enemy = new MinervaMcGonagall();
                    FightBoard fightBoard = new FightBoard();
                    fightBoard.creationFenetreJeu(fightBoard);
                    fightBoard.setGame();
                    nextButton.setOnAction(event85 -> {
                        if (!wizard.isAlive()) return;
                        String Victory = "Vous avez réussi à survive à tous les niveaux, vous avez fini le jeu. Bravo !";
                        ScrollingInWindow.printInWindow(Victory);
                        nextButton.setOnAction(event86 -> {
                            System.exit(0);
                        });
                    });
                });
//            wizard.fight(enemy);
            } else {
                String NewFight = "Vous descendez dans la cours de Poudlard dans laquelle vous trouvez Voldmort et Bellatrix Lestrange. Bellatrix Lestrange se place alors devant Voldemort. \nVous allez donc devoir vaincre Bellatrix Lestrange pour pouvoir atteindre Voldemort.";
                ScrollingInWindow.printInWindow(NewFight);
                nextButton.setOnAction(event83 -> {
                    StartController.enemy = new BellatrixLestrange();
                    FightBoard fightBoard = new FightBoard();
                    fightBoard.creationFenetreJeu(fightBoard);
                    fightBoard.setGame();
                    nextButton.setOnAction(event84 -> {
                        if (!wizard.isAlive()) return;
                        String FightContinue = "Vous pouvez désormais attaquer Voldemort.";
                        ScrollingInWindow.printInWindow(FightContinue);
                        nextButton.setOnAction(event85 -> {
                            StartController.enemy = new Voldemort();
                            FightBoard fightBoard2 = new FightBoard();
                            fightBoard2.creationFenetreJeu(fightBoard2);
                            fightBoard2.setGame();
                            nextButton.setOnAction(event86 -> {
                                if (!wizard.isAlive()) return;
                                String Victory = "Vous avez réussi à survive à tous les niveaux, vous avez fini le jeu. Bravo !";
                                ScrollingInWindow.printInWindow(Victory);
                                nextButton.setOnAction(event87 -> {
                                    System.exit(0);
                                });
                            });
                        });
                    });


                });
//            wizard.fight(enemy);

            }
        });
    }
}