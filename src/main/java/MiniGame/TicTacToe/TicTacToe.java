package MiniGame.TicTacToe;

import java.util.Random;

public class TicTacToe {

    public static boolean TicTacToe() {

        boolean restartdraw = true;
        while (restartdraw) {
            restartdraw = false;
            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            char player = 'X';
            boolean end = true;
            Random random = new Random();

            while (end) {
                GameBoard.gameBoard(board);

                double[] coord;
                if (player == 'X') {
                    do {
                        coord = CheckCase.chooseCase(board, player);
                        if (!CheckCase.checkCase(board, (int) coord[0], (int) coord[1])) {
                            System.out.println("Case occupée. Veuillez choisir une case vide.");
                        }
                        if (!CheckWin.draw(board, (int) coord[0], (int) coord[1], player)) {
                            break;
                        }
                    } while ((!CheckCase.checkCase(board, (int) coord[0], (int) coord[1])));
                } else {
                    System.out.println("\nLe joueur ayant les O, à choisi une case : \n");
                    do {
                        coord = new double[]{random.nextInt(3), random.nextInt(3)};
                    } while (!CheckCase.checkCase(board, (int) coord[0], (int) coord[1]));
                }

                // on place le symbole du joueur sur la case choisie
                board[(int) coord[0]][(int) coord[1]] = player;
                Object[] tuple = CheckWin.victory(board, (int) coord[0], (int) coord[1], player);
                boolean end1 = (boolean) tuple[0];
                char winner = (char) tuple[1];
                boolean end2 = CheckWin.draw(board, (int) coord[0], (int) coord[1], player);
                if (!end1) {
                    if (winner == 'X') {
                        return true;
                    } else return false;
                } else if (!end2) {
                    System.out.println("Match nul ! Nouvelle essai");
                    restartdraw = true;
                    break;
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            }
        }
        return restartdraw;
    }
}
