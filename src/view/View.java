package view;

//import player.Player;

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
