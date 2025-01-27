import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(String representation) {
        super(representation);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove(Cell[][] board) {
        //Scanner sc = new Scanner(System.in);
        int row, col;
        System.out.println("Enter the row number");
        row = scanner.nextInt();
        System.out.println("Enter the column number");
        col = scanner.nextInt();

        // si la celle est valide et libre
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].getRepresentation().equals("|   ")) {
            // je remplace la celle vide par la representation du joueur
            board[row][col].setCell(this.getRepresentation());
            // sinon
        } else {
            // l'action n'est pas valide, essaye à nouveau
            System.out.println("Invalid row or column number");
            makeMove(board);
        }
    }
}
