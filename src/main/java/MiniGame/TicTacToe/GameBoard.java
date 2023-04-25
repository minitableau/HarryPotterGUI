package MiniGame.TicTacToe;

public class GameBoard {
    public static void gameBoard(char[][] board) {
        System.out.println("    0   1   2");
        System.out.println("   ------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   ------------");
        }
    }
}
