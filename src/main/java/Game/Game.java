package Game;


import GameElement.characters.Wizard;
import com.example.harrypottergui.HelloApplication;
import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.ScrollingText;


public class Game {
    private Wizard wizard;
    public static boolean gui = false;

    public static void main(String[] args) {
        Wizard wizard = new Wizard(null, null, null, null);
//        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.PhoenixFeather, 23), House.SLYTHERIN);
        playConsoleOrGui(wizard);
        //haveYouEverPlayed();
    }

    private static void playConsoleOrGui(Wizard wizard) {
//        String Question = ConsoleColors.BLUE + "\nEn quel mode voulez-vous jouer : " + ConsoleColors.RESET;
//        ScrollingText.printWithDelay(Question, 0);
//        String Choice = "1 : Console\n2 : Interface graphique";
//        ScrollingText.printWithDelay(Choice, 0);
//
//        int choice = InteractionUtils.askForInt(1, 2);
//
//        if (choice == 1) {
//            haveYouEverPlayed();
//            AbstractLevel[] levels = new AbstractLevel[]{
//                    new Level0(),
//                    new Level1(),
//                    new Level2(),
//                    new Level3(),
//                    new Level4(),
//                    new Level5(),
//                    new Level6(),
//                    new Level7()
//            };
//
//            for (AbstractLevel level : levels) {
//                level.startLevel(wizard);
//                if (!wizard.isAlive()) break;
//            }
//        }
//        if (choice == 2) {
        gui = true;
        HelloApplication.launch(HelloApplication.class);
    }
//    }

//    private static void haveYouEverPlayed() {
//        String Question = ConsoleColors.BLUE + "\nAvez-vous déjà joué : " + ConsoleColors.RESET;
//        ScrollingText.printWithDelay(Question, 0);
//        String Choice = "1 : Oui.\n2 : Non.";
//        ScrollingText.printWithDelay(Choice, 0);
//
//        int choice = InteractionUtils.askForInt(1, 2);
//
//        if (choice == 1) {
//            ScrollingText.DEFAULT_SPEED = 0;
//        }
//        if (choice == 2) {
//            ScrollingText.DEFAULT_SPEED = 15;
//        }
//
//    }
}