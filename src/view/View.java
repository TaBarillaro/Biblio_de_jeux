package view;

import games.Cell;
import player.Player;

public class View {

    public void userChoice() {
        System.out.println("Do you want to play against a human or AI?");
        System.out.println("Enter 'human' for human or 'ai' for artificial: ");
    }

    // methode pour montrer le tableau
    public void displayBoard(Cell[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    // methode pour demander le mouvement
    public void choiceCell() {
        System.out.print("Enter your move (row and column, separated by space): ");
    }

    // methode pour annoncer le gagnant
    public void winner(Player winner) {
        System.out.println("player.Player " + winner.getRepresentation() + " à gagné! It's over");
    }

    // methode pour annoncer l'égalité
    public void equality() {
        System.out.println("It's a tie!");
    }

    // methode pour mouvement non valide
    public void invalidChoice() {
        System.out.println("Invalid row or column number");
    }

}
