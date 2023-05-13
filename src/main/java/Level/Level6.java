package Level;

import GameElement.House;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.DeathEater;
import GameElement.items.Market;
import GameElement.spells.Sectumsempra;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

import static utils.ScrollingInWindow.nextButton;

public class Level6 extends AbstractLevel {
    public static boolean areYouDeathEater = false;

    @Override
    public void startLevel(Wizard wizard) {
        String MARKET_LVL6 = "Comme avant chaque rentrée vous décidez de passer au magasin de potion";
        ScrollingInWindow.printInWindow(MARKET_LVL6);
        nextButton.setOnAction(event75 -> {
            Market.market(wizard);
            nextButton.setOnAction(event76 -> {
                String INTRO_LVL3 = "Vous êtes de retour à Poudlard, pour une nouvelle année. La directrice à encore changé il s'agit cette fois de votre ancien professeur Minerva McGonagall. \nVous savez qu'elle était proche de Dumbledore et vous espérer qu'elle aura crée un programme intéressant pour cette année. L'année avance vous êtes plutôt satisfait mais \nvous avez envie d'apprendre des sorts plus puissant car vous savez que Voldemort ne va pas rester cacher toute ca vie. Vous allez donc voir votre professeur de \npotion Severus Rogue qui vous apprécie pour lui demander s'il peut vous apprendre des sorts plus puissant. Il vous apprend alors un sort que les élèves ne sont \npas censé connaitre car vraiment très puissant, il s'agit d'un sort interdit et vous met en garde du danger. Il vous fait jurer que vous ne l'utiliserai que dans \ndes conditions de nécessité absolu. Vous avez donc plusieurs cours sur le sort Sectumsempra. L'année continue de s'écouler et vous vous sentez plus puissant car vous \narrivez de mieux en mieux à maitriser ce sort. Alors que la fin de l'année approche Poudlard est attaqué par des mangemorts. Vous vous réfugiez dans la tour d'astronomie \ndu chateau. Mais les mangemorts viennent vous chercher, il tue tous les étudiants sur leur passage mais avant il propose au élève Serpentard de les rejoindres. \nIl arrive à atteindre la tour d'astronomie dans laquelle vous êtes.";
                ScrollingInWindow.printInWindow(INTRO_LVL3);
                wizard.addSpell(new Sectumsempra());
                nextButton.setOnAction(event77 -> {
                    if (wizard.getHouse() == House.SLYTHERIN) {
                        String AskDeathEater = "Mais avant d'engager le combat les mangemorts vous proposent donc des les rejoindres car vous êtes un " + wizard.getHouse();
                        ScrollingInWindow.printInWindow(AskDeathEater);
                        nextButton.setOnAction(event78 -> {
                            joinDeathEater(wizard);
                        });
                    }
                    if (areYouDeathEater) {
                        if (!wizard.isAlive()) return;
                        new Level7().startLevel(wizard);
                    }


                    String StartFight = "Vous engagez le combat avec les mangemorts";
                    ScrollingInWindow.printInWindow(StartFight);
                    nextButton.setOnAction(event79 -> {
                        StartController.enemy = new DeathEater();
                        FightBoard fightBoard = new FightBoard();
                        fightBoard.creationFenetreJeu(fightBoard);
                        fightBoard.setGame();
//        wizard.fight(enemy);
                        if (!wizard.isAlive()) return;

                        nextButton.setOnAction(event80 -> {
                            if (!wizard.isAlive()) return;
                            new Level7().startLevel(wizard);
                        });
                    });
                });
            });
        });

    }

    private void joinDeathEater(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nSouhaitez vous rejoindre les mangemorts  : " +
                "\n1 : Oui.\n2 : Non.", 1, 2);
        if (choice == 1) {
            String CHOICE1 = "\nVous rejoignez les mangemorts !";
            areYouDeathEater = true;
            ScrollingInWindow.printInWindow(CHOICE1, 0);


        }
        if (choice == 2) {
            String CHOICE2 = "\nVous ne rejoignez pas les mangemorts.\n";
            ScrollingInWindow.printInWindow(CHOICE2, 0);

        }

    }
}
