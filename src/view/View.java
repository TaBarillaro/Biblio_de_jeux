package view;

//import player.Player;

import java.util.Scanner;

public class View {

    public void userChoice() {
        System.out.println("Do you want to play against a human or AI?");
        System.out.println("Enter 'human' for human or 'ai' for artificial: ");
    }

    // methode pour montrer le tableau
    public void displayBoard(Cell[][] board) {
        // longeur ligne horizontale
        int rowLength = board.length;
        String horizontalLine = "----".repeat(rowLength);
        System.out.println(horizontalLine);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
            System.out.println(horizontalLine);
        }
    }

    public void chooseGameType() {
        System.out.println("Quel jeu veux-tu jouer? (TicTacToe, Gomoku ou Puissance4): ");
    }

    public String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        boolean validUserChoice = false;

        while (!validUserChoice) {
//            System.out.println("Quel jeu veux-tu jouer? (TicTacToe, Gomoku ou Puissance4): ");

            userChoice = scanner.nextLine().trim();
            if (userChoice.equalsIgnoreCase("TicTacToe") ||
                    userChoice.equalsIgnoreCase("Puissance4") ||
                    userChoice.equalsIgnoreCase("Gomoku")) {
                validUserChoice = true;  // Se l'input è valido, esci dal ciclo
            } else {
                System.out.println("Input invalid!");
            }
        }

        return userChoice;
    }

    // methode pour demander le mouvement
    public void choiceCell() {
        System.out.print("Enter your move (row and column, separated by space): ");
    }

    // methode pour annoncer le gagnant
    public void winner(String winner) {
        System.out.println("player: Player " + winner + " à gagné! It's over");
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
