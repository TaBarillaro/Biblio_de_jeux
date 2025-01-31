package games;

import player.Player;
import view.Cell;
import view.InteractionUtilisateur;
import view.View;

public abstract class BoardGame {

    // attributs avec leurs getters and setters
    private Cell[][] board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private InteractionUtilisateur interactionUtilisateur;
    private View view;
    //private int size;

    public Cell[][] getBoard() {
        return board;
    }

//    public void setBoard(Cell[][] board) {
//        this.board = board;
//    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }


    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }


    public InteractionUtilisateur getInteractionUtilisateur() {
        return interactionUtilisateur;
    }

//    public void setInteractionUtilisateur(InteractionUtilisateur interactionUtilisateur) {
//        this.interactionUtilisateur = interactionUtilisateur;
//    }


    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

//    public int getSize() {
//        return size;
//    }

    // methode pour obtenir le nombre des lignes
    public int getRows() {
        return board.length;
    }

    // methode pour obtenir le nombre des colonnes
    public int getCols() {
        return board[0].length;
    }

    protected BoardGame(int rows, int cols) {
        //this.size = size;
        board = new Cell[rows][cols];
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    // methode play commun à tous les jeux
    public abstract void play();

    // methode isOver commun à tous les jeux
    public abstract boolean isOver();

    // methode initPlayer pour choisir l'adversaire
    protected abstract void initPlayer();

}
