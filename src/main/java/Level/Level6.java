package Level;

import GameElement.House;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.DeathEater;
import GameElement.characters.enemies.Enemy;
import GameElement.items.Market;
import GameElement.spells.Sectumsempra;
import com.example.harrypottergui.vue.StartController;
import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.ScrollingText;

public class Level6 extends AbstractLevel {
    public static boolean areYouDeathEater = false;

    @Override
    public void startLevel(Wizard wizard) {
        String MARKET_LVL6 = "Comme avant chaque rentrée vous décidez de passer au magasin de potion";
        ScrollingText.printWithDelay(MARKET_LVL6);
        Market.market(wizard);

        String INTRO_LVL3 = "Vous êtes de retour à Poudlard, pour une nouvelle année. La directrice à encore changé il s'agit cette fois de votre ancien professeur Minerva McGonagall. \nVous savez qu'elle était proche de Dumbledore et vous espérer qu'elle aura crée un programme intéressant pour cette année. L'année avance vous êtes plutôt satisfait mais \nvous avez envie d'apprendre des sorts plus puissant car vous savez que Voldemort ne va pas rester cacher toute ca vie. Vous allez donc voir votre professeur de \npotion Severus Rogue qui vous apprécie pour lui demander s'il peut vous apprendre des sorts plus puissant. Il vous apprend alors un sort que les élèves ne sont \npas censé connaitre car vraiment très puissant, il s'agit d'un sort interdit et vous met en garde du danger. Il vous fait jurer que vous ne l'utiliserai que dans \ndes conditions de nécessité absolu. Vous avez donc plusieurs cours sur le sort Sectumsempra. L'année continue de s'écouler et vous vous sentez plus puissant car vous \narrivez de mieux en mieux à maitriser ce sort. Alors que la fin de l'année approche Poudlard est attaqué par des mangemorts. Vous vous réfugiez dans la tour d'astronomie \ndu chateau. Mais les mangemorts viennent vous chercher, il tue tous les étudiants sur leur passage mais avant il propose au élève Serpentard de les rejoindres. \nIl arrive à atteindre la tour d'astronomie dans laquelle vous êtes.";
        ScrollingText.printWithDelay(INTRO_LVL3);
        wizard.addSpell(new Sectumsempra());

        if (wizard.getHouse() == House.SLYTHERIN) {
            String AskDeathEater = "Mais avant d'engager le combat les mangemorts vous proposent donc des les rejoindres car vous êtes un " + wizard.getHouse();
            ScrollingText.printWithDelay(AskDeathEater);
            joinDeathEater(wizard);
        }
        if (areYouDeathEater) return;

        String StartFight = "Vous engagez le combat avec les mangemorts";
        ScrollingText.printWithDelay(StartFight);

        StartController.enemy = new DeathEater();
//        wizard.fight(enemy);
        if (!wizard.isAlive()) return;


    }

    private void joinDeathEater(Wizard wizard) {
        String QUESTION = ConsoleColors.BLUE + "\nSouhaitez vous rejoindre les mangemorts  : " + ConsoleColors.RESET;
        ScrollingText.printWithDelay(QUESTION, 0);
        String CHOICE = "1 : Oui.\n2 : Non.";
        ScrollingText.printWithDelay(CHOICE, 0);

        int choice = InteractionUtils.askForInt(1, 2);

        if (choice == 1) {
            String CHOICE1 = "\nVous rejoignez les mangemorts !";
            ScrollingText.printWithDelay(CHOICE1, 0);
            areYouDeathEater = true;

        }
        if (choice == 2) {
            String CHOICE2 = "\nVous ne rejoignez pas les mangemorts.\n";
            ScrollingText.printWithDelay(CHOICE2, 0);

        }

    }
}
