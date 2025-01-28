
public class TicTacToe {

    final int size = 3;
    Cell[][] board;
    Player currentPlayer;
    Player player1;
    Player player2;
    InteractionUtilisateur interactionUtilisateur;
    View view;

    // construct pour initializer board
    public TicTacToe() {
        board = new Cell[size][size];
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        // choix de l'adversaire
        view.userChoice();
        String playerType = interactionUtilisateur.recoveryAnswer();

        if (playerType.equals("human")) {
            player1 = new HumanPlayer("| X ");  // human player
            player2 = new HumanPlayer("| O ");  //  human player
        } else if (playerType.equals("ai")) {
            player2 = new ArtificialPlayer("| O "); // artificial player
            player1 = new HumanPlayer("| X ");  // human player
        }
        currentPlayer = player1;
    }


    // methode pour alterner les joueurs
    public void play() {
        //Scanner scanner = new Scanner(System.in);

        for (int k = 0; k < 9; k++) {
            if (isOver()) {
                break;
            }
            // montre le tableau à chaque jeu
            //ticTacToe();
            view.displayBoard(board);

            // le joueur jeu
            currentPlayer.makeMove(board);

            if (isOver()) {
                break;
            }

            // operation ternaire pour alterner les joueurs
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    // methode pour verifier les chances de gagner
    public boolean isOver() {
        // verification lignes et colonnes
//        for (int i = 0; i < size; i++) {
//            if ((board[i][0].getRepresentation().equals(currentPlayer.getRepresentation()) && board[i][1].getRepresentation().equals(currentPlayer.getRepresentation()) &&
//                    board[i][2].getRepresentation().equals(currentPlayer.getRepresentation()) ) ||
//                    (board[0][i].getRepresentation().equals(currentPlayer.getRepresentation()) &&
//                            board[1][i].getRepresentation().equals(currentPlayer.getRepresentation()) && board[2][i].getRepresentation().equals(currentPlayer.getRepresentation()) )) {
//                view.displayBoard(board);
//                view.winner(currentPlayer);
//                return true;
//            }
//        }
        for (int i = 0; i < size; i++) {
            boolean lineok = true;
            for (int j = 0; j < size; j++) {
                lineok = lineok && board[i][j].getRepresentation().equals(currentPlayer.getRepresentation());
            }
            if (lineok) {
                view.displayBoard(board);
                view.winner(currentPlayer);
                return true;
            }
        }

        for (int j = 0; j < size; j++) {
            boolean colonne = true;
            for (int i = 0; i < size; i++) {
                colonne = colonne && board[i][j].getRepresentation().equals(currentPlayer.getRepresentation());
            }
            if (colonne) {
                view.displayBoard(board);
                view.winner(currentPlayer);
                return true;
            }
        }

        // verification des deux diagonales
//        if ((board[0][0].getRepresentation().equals(currentPlayer.getRepresentation()) && board[1][1].getRepresentation().equals(currentPlayer.getRepresentation()) &&
//                board[2][2].getRepresentation().equals(currentPlayer.getRepresentation()) ) ||
//                (board[0][2].getRepresentation().equals(currentPlayer.getRepresentation()) && board[1][1].getRepresentation().equals(currentPlayer.getRepresentation()) &&
//                        board[2][0].getRepresentation().equals(currentPlayer.getRepresentation()) )) {
//            view.displayBoard(board);
//            view.winner(currentPlayer);
//            return true;
//        }
        boolean diagok= true;
        for (int i = 0; i < size; i++) {
            diagok = diagok && board[i][i].getRepresentation().equals(currentPlayer.getRepresentation());
        }
        if (diagok) {
            view.displayBoard(board);
            view.winner(currentPlayer);
            return true;
        }

        for (int i = 0; i < size; i++) {
            boolean diagonal = true;
            for (int j = 2; j < size; j--) {
                diagonal = diagonal && board[i][j].getRepresentation().equals(currentPlayer.getRepresentation());
            }
            if (diagonal) {
                view.displayBoard(board);
                view.winner(currentPlayer);
                return true;
            }
        }

        // verification du tableau rempli: s'il y a des cases vides, return false donc le jeu continue
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getRepresentation().equals("|   ")) {
                    return false;
                }
            }
        }
        view.displayBoard(board);
        // si les cases sont toutes remplies et il n'y a pas un gagnant, print égalité et arrête le jeu
        view.equality();

        return true;
    }

}
