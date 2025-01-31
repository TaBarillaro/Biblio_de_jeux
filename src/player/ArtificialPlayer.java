package player;

import view.Cell;

import java.util.ArrayList;
import java.util.Random;

public class ArtificialPlayer extends Player {

    private final Random random;
    //Random random = new Random();

    // constructeur
    public ArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public void makeMove(Cell[][] board, int rows, int cols) {

        // création d'une liste
        ArrayList<Object> emptyCells = new ArrayList<>();

        // trouve les cases vides
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                // si la case est vide
                if (board[i][j].getRepresentation().equals("|   ")) {
                    // on l'ajoute à la liste emptyCells
                    emptyCells.add(new int[] {i, j});
                }
            }
        }

        // choix d'une case vide que la machine peut jouer
        if (!emptyCells.isEmpty()) {
            int[] randomCell = (int[]) emptyCells.get(random.nextInt(emptyCells.size()));
            int row = randomCell[0];
            int col = randomCell[1];

            board[row][col].setCell(this.getRepresentation());
        }

    }

    @Override
    public void makeMovePuiss4(Cell[][] board, int cols) {

        // création d'une liste
        ArrayList<int[]> validColumns = new ArrayList<>();

        // on trouve les colonnes avec au moins une case vide
        for (int j = 0; j < cols; j ++) {
            if (board[0][j].getRepresentation().equals("|   ")) {
                validColumns.add(new int[] {0, j});
            }
        }
        // s'il y a des colonnes valides, l'IA choisi une colonne au hazard
        if (!validColumns.isEmpty()) {
            int[] col = validColumns.get(random.nextInt(validColumns.size()));
            int colIndex = col[1];

            int row = -1;
            for (int i = board.length - 1; i >= 0; i --) {
                if (board[i][colIndex].getRepresentation().equals("|   ")) {
                    row = i;
                    break;
                }
            }
           if (row != -1) {
               board[row][colIndex].setCell(this.getRepresentation());
           }
        }
    }
}
