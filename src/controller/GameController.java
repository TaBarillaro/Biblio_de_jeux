package controller;

import games.BoardGame;
import games.Gomoku;
import games.Puissance4;
import games.TicTacToe;
import view.View;

public class GameController {

    protected BoardGame game;
    private View view;

    public GameController(View view) {
        this.view = view;
    }

    public void startGame(String gameType) {
        switch (gameType) {
            case "TicTacToe":
                game = new TicTacToe(view);
                break;
            case "Gomoku":
                game = new Gomoku(view);
                break;
            case "Puissance4":
                game = new Puissance4(view);
                break;
        }

        // choix des joueurs
        game.initPlayer();

        playGame();
    }

    public void playGame() {
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());  // montre le tableau

            // currentPlayer jeu
            game.getCurrentPlayer().makeMove(game.getBoard(), game.getRows(), game.getCols());

            // Changement de joueur
            game.setCurrentPlayer(game.getCurrentPlayer() == game.getPlayer1() ? game.getPlayer2() : game.getPlayer1());
        }
    }
}
