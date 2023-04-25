package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractionUtils {

    public static int askForInt(String message, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be lower than max");
        }

        if (!message.isBlank() && !message.isEmpty()) {
            ScrollingText.printWithDelay(message);
        }

        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            try {
                value = scanner.nextInt();
                if (value < min || value > max) {
                    System.out.println("La valeur doit être comprise entre " + min + " et " + max + ".");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La valeur doit être un nombre.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static int askForInt(int min, int max) {
        return askForInt("", min, max);
    }

    public static String askForString(String message) {
        if (!message.isBlank() && !message.isEmpty()) {
            ScrollingText.printWithDelay(message);
        }

        Scanner scanner = new Scanner(System.in);
        String value;

        while (true) {
            try {
                value = scanner.nextLine();
                if (value.isBlank() || value.isEmpty()) {
                    System.out.println("La valeur ne peut pas être vide.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La valeur doit être une chaine de caractère.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static String askForString() {
        return askForString("");
    }
}
