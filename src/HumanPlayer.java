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
    public void makeMove(Cell[][] board) {
        int row, col;
        view.choiceCell();
        int[] coordinates = interactionUtilisateur.recoveryAnswerInt();
        row = coordinates[0];
        col = coordinates[1];

        // si la celle est valide et libre
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].getRepresentation().equals("|   ")) {
            // je remplace la celle vide par la representation du joueur
            board[row][col].setCell(this.getRepresentation());
            // sinon
        } else {
            // l'action n'est pas valide, essaye à nouveau
            view.invalidChoice();
            makeMove(board);
        }
    }
}
