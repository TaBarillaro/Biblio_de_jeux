package games;

import player.Player;
import view.InteractionUtilisateur;
import view.View;

public abstract class BoardGame {

    // attributs avec leurs getters and setters
    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    private Cell[][] board;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private Player currentPlayer;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    private Player player1;

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    private Player player2;

    public InteractionUtilisateur getInteractionUtilisateur() {
        return interactionUtilisateur;
    }

    public void setInteractionUtilisateur(InteractionUtilisateur interactionUtilisateur) {
        this.interactionUtilisateur = interactionUtilisateur;
    }

    private InteractionUtilisateur interactionUtilisateur;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    private View view;

    public int getSize() {
        return size;
    }

    private int size;

    protected BoardGame(int size) {
        this.size = size;
        board = new Cell[size][size];
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    // methode play commun à tous les jeux
    public abstract void play();

    // methode isOver commun à tous les jeux
    public abstract boolean isOver();



}
