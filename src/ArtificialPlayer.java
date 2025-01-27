import java.util.ArrayList;
import java.util.Random;

public class ArtificialPlayer extends Player {

    private Random random;
    //Random random = new Random();

    // constructeur
    public ArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public void makeMove(Cell[][] board) {

        // création d'une liste
        ArrayList<Object> emptyCells = new ArrayList<>();

        // trouve les cases vides
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                // si la case est vide
                if (board[i][j].getRepresentation().equals("|   ")) {
                    // on l'ajout à la liste emptyCells
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
}
