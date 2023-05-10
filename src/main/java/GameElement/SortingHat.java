package GameElement;

import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.MathUtils;
import utils.ScrollingInWindow;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SortingHat {

    public final House[] houses = {House.RAVENCLAW, House.SLYTHERIN, House.GRYFFINDOR, House.HUFFLEPUFF};

    //methode pour Eloise Midgen & Vincent Crabbe
    public House sort() {
        int index = MathUtils.random(houses.length - 1);
        return houses[index];

    }

    //methode pour notre perso
    public House sort(int a) {
        ScrollingInWindow.printInWindow("\t- " + "Choixpeau" + " : \"Humm, difficile, très difficile, beaucoup de courage, des facilités, une soif de faire tes preuves. Où puis je te mettre ?\"");
        for (int i = 0; i < houses.length; i++) {
            System.out.println((i + 1) + ". " + houses[i]);
        }

        int excludedHouseIndex = 0;
        boolean isExcludedHouseValid = false;
        while (!isExcludedHouseValid) {
            try {
                excludedHouseIndex = InteractionUtils.askForInt(
                        "Choisissez le numéro de la maison que vous ne souhaitez pas :"+"\n1 - Gryffondor\n2- Poufsouffle\n3 - Serdaigle\n4 - Serpentard", 1, 4);
                if (excludedHouseIndex < 1 || excludedHouseIndex > houses.length) {
                    System.out.println("Numéro de maison invalide !");
                } else {
                    isExcludedHouseValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Numéro de maison invalide !");
            }
        }
        int index = MathUtils.random(houses.length - 2);
        if (index >= excludedHouseIndex - 1) {
            index++;
        }
        return houses[index];
    }

}

