package MiniGame.TicTacToe;

import java.util.Scanner;

public class CheckCase {

    public static double[] chooseCase(char[][] board, char player) {
        Scanner sc = new Scanner(System.in);
        double[] coord = new double[2];
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Le joueur ayant les " + player + ", doit choisir une case (une ligne puis une colonne): ");


            while (!sc.hasNextDouble()) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre valide.");
                sc.next();
            }
            coord[0] = sc.nextDouble();

            while (!sc.hasNextDouble()) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre valide.");
                sc.next();
            }
            coord[1] = sc.nextDouble();

            if (coord[0] < 0 || coord[0] > 2 || coord[1] < 0 || coord[1] > 2) {
                System.out.println("Case invalide. Veuillez choisir une case entre 0 et 2.");
            } else if (board[(int) coord[0]][(int) coord[1]] != ' ') {
                System.out.println("Case déjà occupée. Veuillez choisir une autre case.");
            } else {
                isValidInput = true;
            }
        }
        return coord;
    }

    public static boolean checkCase(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Case invalide. Veuillez choisir une case entre 0 et 2.");
            return false;
        }

        return board[row][col] == ' ';
    }
}
