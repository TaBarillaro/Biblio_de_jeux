package games;

import player.ArtificialPlayer;
import player.HumanPlayer;
import player.Player;
import view.InteractionUtilisateur;
import view.View;

public class TicTacToe extends BoardGame {

//    final int size = 3;
//    private Cell[][] board;
//    private Player currentPlayer;
//    private Player player1;
//    private Player player2;
//    private InteractionUtilisateur interactionUtilisateur;
//    private View view;

    // construct pour initializer board
    public TicTacToe() {
        super(3);
//        board = new Cell[size][size];
//        view = new View();
//        interactionUtilisateur = new InteractionUtilisateur();
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = new Cell();
//            }
//        }
        initPlayer();
    }

    private void initPlayer() {
        // choix de l'adversaire
        getView().userChoice();
        String playerType = getInteractionUtilisateur().recoveryAnswer();

        if (playerType.equals("human")) {
            setPlayer1(new HumanPlayer("| X "));  // human player
            setPlayer2(new HumanPlayer("| O "));  //  human player
        } else if (playerType.equals("ai")) {
            setPlayer2(new ArtificialPlayer("| O ")); // artificial player
            setPlayer1(new HumanPlayer("| X "));  // human player
        }
        setCurrentPlayer(getPlayer1());
    }

    // methode pour alterner les joueurs
    public void play() {

        for (int k = 0; k < 9; k++) {
            // montre le tableau à chaque fois
            getView().displayBoard(getBoard());

            // le joueur jeu
            getCurrentPlayer().makeMove(getBoard());

            if (isOver()) {
                break;
            }

            // operation ternaire pour alterner les joueurs
//            currentPlayer() = (getCurrentPlayer() == player1) ? player2 : player1;
            setCurrentPlayer(getCurrentPlayer() == getPlayer1() ? getPlayer2() : getPlayer1());
        }
    }

    // methode pour verifier les chances de gagner
    public boolean isOver() {
        // verification lignes et colonnes
        for (int i = 0; i < getSize(); i++) {
            boolean lineok = true;
            for (int j = 0; j < getSize(); j++) {
                lineok = lineok && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (lineok) {
                getView().displayBoard(getBoard());
                getView().winner(getCurrentPlayer());
                return true;
            }
        }

        for (int j = 0; j < getSize(); j++) {
            boolean colonne = true;
            for (int i = 0; i < getSize(); i++) {
                colonne = colonne && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (colonne) {
                getView().displayBoard(getBoard());
                getView().winner(getCurrentPlayer());
                return true;
            }
        }

        // verification des deux diagonales
        boolean diagok= true;
        for (int i = 0; i < getSize(); i++) {
            diagok = diagok && getBoard()[i][i].getRepresentation().equals(getCurrentPlayer().getRepresentation());
        }
        if (diagok) {
            getView().displayBoard(getBoard());
            getView().winner(getCurrentPlayer());
            return true;
        }

        for (int i = 0; i < getSize(); i++) {
            boolean diagonal = true;
            for (int j = getSize()-1; j>=0; j--) {
                diagonal = diagonal && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (diagonal) {
                getView().displayBoard(getBoard());
                getView().winner(getCurrentPlayer());
                return true;
            }
        }

        // verification du tableau rempli: s'il y a des cases vides, return false donc le jeu continue
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (getBoard()[i][j].getRepresentation().equals("|   ")) {
                    return false;
                }
            }
        }
        getView().displayBoard(getBoard());
        // si les cases sont toutes remplies et il n'y a pas un gagnant, print égalité et arrête le jeu
        getView().equality();

        return true;
    }

}
