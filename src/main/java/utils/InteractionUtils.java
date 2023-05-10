package utils;

import javafx.scene.control.TextInputDialog;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InteractionUtils {

    public static int askForInt(String message, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be lower than max");
        }

        int value;

        while (true) {
            TextInputDialog dialog = new TextInputDialog();
            if (!message.isBlank() && !message.isEmpty()) {
                dialog.setHeaderText(message);
            }

            dialog.setContentText("Saisis un nombre entre " + min + " et " + max + ":");

            Optional<String> result = dialog.showAndWait();

            try {
                value = Integer.parseInt(result.get());
                if (value < min || value > max) {
                    System.out.println("The value must be between " + min + " and " + max + ".");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The value must be a number.");
            } catch (Exception e) {
                return -1;
            }
        }

        return value;
    }

    public static int askForInt(int min, int max) {
        return askForInt("", min, max);
    }

    public static String askForString(String message) {
        String value;

        while (true) {
            TextInputDialog dialog = new TextInputDialog();
            if (!message.isBlank() && !message.isEmpty()) {
                dialog.setHeaderText(message);
            }

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                value = result.get();
                break;
            } else {
                System.out.println("No value entered.");
            }
        }

        return value;
    }

}
