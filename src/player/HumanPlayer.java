package player;

import games.Cell;
import view.InteractionUtilisateur;
import view.View;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;
    View view;
    InteractionUtilisateur interactionUtilisateur;

    public HumanPlayer(String representation) {
        super(representation);
        this.scanner = new Scanner(System.in);
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();
    }

    @Override
    public void makeMove(Cell[][] board, int rows, int cols) {
        int row, col;
        view.choiceCell();
        int[] coordinates = interactionUtilisateur.recoveryAnswerInt();
        row = coordinates[0];
        col = coordinates[1];

        // si la celle est valide et libre
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col].getRepresentation().equals("|   ")) {
            // je remplace la celle vide par la representation du joueur
            board[row][col].setCell(this.getRepresentation());
            // sinon
        } else {
            // l'action n'est pas valide, essaye à nouveau
            view.invalidChoice();
            makeMove(board, rows, cols);
        }
    }

    @Override
    public void makeMovePuiss4(Cell[][] board, int cols) {
        int col;
        view.choiceCell();
        int[] coordinates = interactionUtilisateur.recoveryAnswerInt();
        col = coordinates[0];

        // verification si la colonne est valide
        if (col >= 0 && col < cols) {
            // trouve la première celle vide dans la colonne
            int row = -1;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][col].getRepresentation().equals("|   ")) {
                    row = i;
                    break;
                }
            }

            if (row != -1) {
                // on met le poin dans la première celle vide trouvé
                board[row][col].setCell(this.getRepresentation());
            } else {
                // si la celle est pleine, invalidChoice et le joueur choisi une autre celle
                view.invalidChoice();
                makeMovePuiss4(board, cols);
            }
        } else {
            // colonne pas valide
            view.invalidChoice();
            makeMovePuiss4(board, cols);
        }
    }

}
