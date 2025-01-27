import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {

    final int size = 3;
    Cell[][] board;
    Player currentPlayer;
    Player player1;
    Player player2;


    // construct pour initializer board
    public TicTacToe() {
        board = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }

        // choix de l'adversaire
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play against a human or AI?");
        System.out.println("Enter 'human' for human or 'ai' for artificial: ");
        String playerType = scanner.nextLine();

        if (playerType.equals("human")) {
            player1 = new HumanPlayer("| X ");  // human player
            player2 = new HumanPlayer("| O ");  //  human player
        } else if (playerType.equals("ai")) {
            player2 = new ArtificialPlayer("| O "); // artificial player
            player1 = new HumanPlayer("| X ");  // human player
        }
        currentPlayer = player1;
    }

    // representation graphique du tableau de jeu
    public void ticTacToe() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    // la methode display appelle la methode ticTacToe pour montrer le tableau du jeu
//    public void display() {
//
//        TicTacToe t = new TicTacToe();
//        t.ticTacToe();
//        //getMoveFromPlayer();
//    }

    // methode pour jouer un tour
//    public void getMoveFromPlayer() {
//        Scanner sc = new Scanner(System.in);
//        int row, col;
//        System.out.println("Enter the row number");
//        row = sc.nextInt();
//        System.out.println("Enter the column number");
//        col = sc.nextInt();
//
//        setOwner(row, col, player);
//        ticTacToe();
//    }

//    // methode pour faire jouer le joueur
//    public void setOwner(int row, int col, Player player) {
//        // si la celle est valide et libre
//        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col].getRepresentation().equals("|   ")) {
//            // je remplace la celle vide par la representation du joueur
//            board[row][col].setCell(player.getRepresentation());
//        // sinon
//        } else {
//            // l'action n'est pas valide
//            System.out.println("Invalid row or column number");
//        }
//    }

    // methode pour alterner les joueurs
    public void play() {
        //Scanner scanner = new Scanner(System.in);

        for (int k = 0; k < 9; k++) {
            if (isOver()) {
                break;
            }
            // montre le tableau à chaque jeu
            ticTacToe();

            // le joueur jeu
            currentPlayer.makeMove(board);

            if (isOver()) {
                break;
            }

//            if (Objects.equals(player.getRepresentation(), "| X ")) {
//                player.setRepresentation("| O ");
//            } else if (Objects.equals(player.getRepresentation(), "| O ")) {
//                player.setRepresentation("| X ");
//            }

            // operation ternaire pour alterner les joueurs
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    // methode pour verifier les chances de gagner
    public boolean isOver() {
        // verification lignes et colonnes
        for (int i = 0; i < size; i++) {
            if ((board[i][0].getRepresentation().equals(currentPlayer.getRepresentation()) && board[i][1].getRepresentation().equals(currentPlayer.getRepresentation()) && board[i][2].getRepresentation().equals(currentPlayer.getRepresentation()) ) ||
                    (board[0][i].getRepresentation().equals(currentPlayer.getRepresentation()) && board[1][i].getRepresentation().equals(currentPlayer.getRepresentation()) && board[2][i].getRepresentation().equals(currentPlayer.getRepresentation()) )) {
                ticTacToe();
                System.out.println("Player " + currentPlayer.getRepresentation() + " à gagné! It's over");
                return true;
            }
        }
        // verification des deux diagonales
        if ((board[0][0].getRepresentation().equals(currentPlayer.getRepresentation()) && board[1][1].getRepresentation().equals(currentPlayer.getRepresentation()) && board[2][2].getRepresentation().equals(currentPlayer.getRepresentation()) ) ||
                (board[0][2].getRepresentation().equals(currentPlayer.getRepresentation()) && board[1][1].getRepresentation().equals(currentPlayer.getRepresentation()) && board[2][0].getRepresentation().equals(currentPlayer.getRepresentation()) )) {
            ticTacToe();
            System.out.println("Player " + currentPlayer.getRepresentation() + " à gagné! It's over");
            return true;
        }
        // verification du tableau rempli: s'il y a des cases vides, return false donc le jeu continue
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getRepresentation().equals("|   ")) {
                    return false;
                }
            }
        }
        ticTacToe();
        // si les cases sont toutes remplies et il n'y a pas un gagnant, print égalité et arrête le jeu
        System.out.println("It's a tie!");
        return true;
    }

}
