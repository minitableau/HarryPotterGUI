package GameElement;

import utils.ConsoleColors;
import utils.MathUtils;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SortingHat {

    public final House[] houses = {House.RAVENCLAW, House.SLYTHERIN, House.GRYFFINDOR, House.HUFFLEPUFF};

    //methode pour Eloise Midgen & Vincent Crabbe
    public House sort() {
        int index = MathUtils.random(houses.length-1);
        return houses[index];

    }

    //methode pour notre perso
    public House sort(Scanner scanner) {
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Humm, difficile, très difficile, beaucoup de courage, des facilités, une soif de faire tes preuves. Où puis je te mettre ?\"");
        System.out.println(ConsoleColors.BLUE + "\nChoisissez le numéro de la maison que vous ne souhaitez pas :" + ConsoleColors.RESET);
        for (int i = 0; i < houses.length; i++) {
            System.out.println((i + 1) + ". " + houses[i]);
        }

        int excludedHouseIndex = 0;
        boolean isExcludedHouseValid = false;
        while (!isExcludedHouseValid) {
            try {
                excludedHouseIndex = scanner.nextInt();
                scanner.nextLine();
                if (excludedHouseIndex < 1 || excludedHouseIndex > houses.length) {
                    System.out.println("Numéro de maison invalide !");
                } else {
                    isExcludedHouseValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Numéro de maison invalide !");
                scanner.nextLine();
            }
        }
        int index = MathUtils.random(houses.length - 2);
        if (index >= excludedHouseIndex - 1) {
            index++;
        }
        return houses[index];
    }

}

