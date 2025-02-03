package games;

import player.ArtificialPlayer;
import player.HumanPlayer;
import view.View;

public class TicTacToe extends BoardGame {

//    final int size = 3;
//    private Cell[][] board;
//    private Player currentPlayer;
//    private Player player1;
//    private Player player2;
//    private InteractionUtilisateur interactionUtilisateur;
    private View view;

    // construct pour initializer board
    public TicTacToe(View view) {
        super(3, 3);
        this.view = view;
    }

    public void initPlayer() {
        // choix de l'adversaire
        view.userChoice();
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
        initPlayer();
        for (int k = 0; k < 9; k++) {
            // montre le tableau à chaque fois
            view.displayBoard(getBoard());

            // le joueur jeu
            getCurrentPlayer().makeMove(getBoard(), getRows(), getCols());

            if (isOver()) {
                break;
            }

            // operation ternaire pour alterner les joueurs
            setCurrentPlayer(getCurrentPlayer() == getPlayer1() ? getPlayer2() : getPlayer1());
        }
    }

    // methode pour verifier les chances de gagner
    public boolean isOver() {
        // verification lignes et colonnes
        for (int i = 0; i < getRows(); i++) {
            boolean lineok = true;
            for (int j = 0; j < getCols(); j++) {
                lineok = lineok && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (lineok) {
                view.displayBoard(getBoard());
                view.winner(getCurrentPlayer().getRepresentation());
                return true;
            }
        }

        for (int j = 0; j < getCols(); j++) {
            boolean colonne = true;
            for (int i = 0; i < getRows(); i++) {
                colonne = colonne && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (colonne) {
//                getView().displayBoard(getBoard());
                view.winner(getCurrentPlayer().getRepresentation());
                return true;
            }
        }

        // verification des deux diagonales
        boolean diagok= true;
        for (int i = 0; i < getRows(); i++) {
            diagok = diagok && getBoard()[i][i].getRepresentation().equals(getCurrentPlayer().getRepresentation());
        }
        if (diagok) {
//            getView().displayBoard(getBoard());
            view.winner(getCurrentPlayer().getRepresentation());
            return true;
        }

        for (int i = 0; i < getRows(); i++) {
            boolean diagonal = true;
            for (int j = getCols()-1; j>=0; j--) {
                diagonal = diagonal && getBoard()[i][j].getRepresentation().equals(getCurrentPlayer().getRepresentation());
            }
            if (diagonal) {
//                getView().displayBoard(getBoard());
                view.winner(getCurrentPlayer().getRepresentation());
                return true;
            }
        }

        // verification du tableau rempli: s'il y a des cases vides, return false donc le jeu continue
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (getBoard()[i][j].getRepresentation().equals("|   ")) {
                    return false;
                }
            }
        }
//        getView().displayBoard(getBoard());
        // si les cases sont toutes remplies et il n'y a pas un gagnant, print égalité et arrête le jeu
        view.equality();

        return true;
    }

}
