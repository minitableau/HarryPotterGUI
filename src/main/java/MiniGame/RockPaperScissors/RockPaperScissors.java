package MiniGame.RockPaperScissors;

import GameElement.House;
import GameElement.characters.Wizard;
import utils.ConsoleColors;
import utils.InteractionUtils;

import java.util.Random;

public class RockPaperScissors {

    // règle du jeu Bienvenue dans un match de Quidditch :
//    Il s'agit d'une variante du jeu "Pierre-Feuille-Ciseaux". Au lieu des trois objets classiques,
//    les joueurs doivent choisir entre trois personnages : le Batteur, le Poursuiveur et l'Attrapeur. Les règles du jeu sont simples :
//    le Batteur bat l'Attrapeur, l'Attrapeur bat le Poursuiveur, et le Poursuiveur bat le Batteur.
//    Le premier joueur à atteindre un score de 3 points gagne la partie. Pour jouer, chaque joueur choisit secrètement un personnage,
//    puis les deux choix sont révélés simultanément. Le joueur qui a choisi le personnage qui bat l'autre remporte un point.
//    En cas d'égalité, aucun point n'est attribué. Le jeu continue jusqu'à ce qu'un joueur atteigne le score de 3 points.

    //Idée si choix Quidditch au niveau 1 alors commencé la partie avec 1-0.
    public static Boolean Quidditch(Wizard wizard) {
        System.out.println("Bienvenue au match de Quidditch les règles sont simples : Il s'agit d'une variante du jeu \"Pierre-Feuille-Ciseaux\". Au lieu des trois objets classiques, \nles joueurs doivent choisir entre trois personnages : le Batteur, le Poursuiveur et l'Attrapeur. \nLes règles du jeu sont simples : le Batteur bat l'Attrapeur, l'Attrapeur bat le Poursuiveur, et le Poursuiveur bat le Batteur. \nLe premier joueur à atteindre un score de 3 points gagne la partie. Pour jouer, chaque joueur choisit secrètement un personnage, puis les deux choix sont révélés simultanément. \nLe joueur qui a choisi le personnage qui bat l'autre remporte un point. En cas d'égalité, aucun point n'est attribué. Le jeu continue jusqu'à ce qu'un joueur atteigne le score de 3 points.");
        Random rand = new Random();

        House otherHouse;
        do {
            otherHouse = House.values()[rand.nextInt(House.values().length)];
        } while (otherHouse == wizard.getHouse());

        String[] choix = {"Batteur", "Poursuiveur", "Attrapeur"};
        int scoreJoueur = 0;
        int scoreOrdinateur = 0;

        while (scoreJoueur < 3 && scoreOrdinateur < 3) {
            int ordi = rand.nextInt(3);

            System.out.print(ConsoleColors.BLUE + "\nEntrez votre choix" + ConsoleColors.RESET + " \n1 : Batteur \n2 : Poursuiveur \n3 : Attrapeur");
            int joueur = InteractionUtils.askForInt(1, 3);
            joueur--;

            System.out.println("\n" + otherHouse + " : " + choix[ordi]);
            System.out.println(wizard.getHouse() + " : " + choix[joueur]);

            if (joueur == ordi) {
                System.out.println("Egalite !");
            } else if ((joueur == 0 && ordi == 2) ||
                    (joueur == 1 && ordi == 0) ||
                    (joueur == 2 && ordi == 1)) {
                System.out.println(wizard.getHouse() + " gagne un point !");
                scoreJoueur++;

            } else {
                System.out.println(otherHouse + " gagne un point !");
                scoreOrdinateur++;

            }

            System.out.println("Score : " + wizard.getHouse() + " " + scoreJoueur + " - " + scoreOrdinateur + " " + otherHouse);
        }

        if (scoreJoueur > scoreOrdinateur) {
            System.out.println(wizard.getHouse() + " gagne la partie !");
            return true;
        } else {
            System.out.println(otherHouse + " gagne la partie !");
            return false;
        }
    }
}



