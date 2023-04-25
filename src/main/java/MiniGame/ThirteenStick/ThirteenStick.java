package MiniGame.ThirteenStick;

import java.util.Random;
import java.util.Scanner;

public class ThirteenStick {

    public static boolean thirteenStick() {
        System.out.println("\nBienvenue au jeu des 13 bâtons!");
        System.out.println("Les règles du jeu son simple. Le jeu commence avec 13 bâtons sur la table. Les joueurs à tour de rôle retirent 1, 2 ou 3 bâtons chacun leur tour, \njusqu'à ce qu'il ne reste plus qu'un seul bâton. Le joueur qui retire le dernier bâton perd la partie.");
        int batonsRestants = 13;
        boolean joueur1Tour = true;

        Scanner input = new Scanner(System.in);
        Random random = new Random();


        System.out.println("--------------------------------");

        while (batonsRestants > 1) {
            System.out.println("Il reste " + batonsRestants + " bâton(s) sur la table.");

            int choix;
            if (joueur1Tour) {
                choix = 0;
                boolean choixValide = false;
                while (!choixValide) {
                    System.out.print("A vous de jouer! Combien de bâtons voulez-vous prendre (1, 2 ou 3)? ");
                    String strChoix = input.nextLine();
                    try {
                        choix = Integer.parseInt(strChoix);
                    } catch (NumberFormatException e) {
                        System.out.println("Choix invalide, veuillez entrer un nombre entre 1 et " + Math.min(3, batonsRestants));
                        continue;
                    }
                    if (choix < 1 || choix > 3 || choix > batonsRestants) {
                        System.out.println("Choix invalide, veuillez entrer un nombre entre 1 et " + Math.min(3, batonsRestants));
                    } else {
                        choixValide = true;
                    }
                }

            } else {
                choix = random.nextInt(Math.min(3, batonsRestants)) + 1;
                System.out.println("L'ordinateur prend " + choix + " bâton(s).");
            }
            batonsRestants -= choix;

            joueur1Tour = !joueur1Tour;
        }

        boolean joueurGagne = joueur1Tour ? false : true;
        String gagnant = joueurGagne ? "Vous gagnez" : "Vous perdez";
        System.out.println(gagnant + " la partie!");

        return joueurGagne;
    }
}
