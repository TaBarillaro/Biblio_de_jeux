package games;

import player.ArtificialPlayer;
import player.HumanPlayer;

public class Gomoku extends BoardGame{

    // construct pour initialiser le board
    public Gomoku() {
        super(15);
    }

    @Override
    protected void initPlayer() {
        getView().userChoice();
        String playerType = getInteractionUtilisateur().recoveryAnswer();

        if(playerType.equals("human")){
            setPlayer1(new HumanPlayer("|\uD83C\uDF88 "));
            setPlayer2(new HumanPlayer("|\uD83C\uDF83 "));
        } else if(playerType.equals("ai")){
            setPlayer1(new HumanPlayer("|\uD83C\uDF88 "));
            setPlayer2(new ArtificialPlayer("|\uD83C\uDF83 "));
        }
        setCurrentPlayer(getPlayer1());
    }

    @Override
    public void play() {
        initPlayer();
        for (int i = 0; i < 225; i++) {
            // montre le tableau à chaque fois
            getView().displayBoard(getBoard());

            // le joueur jeu
            getCurrentPlayer().makeMove(getBoard(), getSize());

            if (isOver()) {
                break;
            }
            // operation ternaire pour alterner les joueurs
            setCurrentPlayer(getCurrentPlayer() == getPlayer1() ? getPlayer2() : getPlayer1());
        }
    }
    // methode pour veirifier le joueur gagnant
    private boolean checkConsecutive(int startX, int startY, int dirX, int dirY){
        String playerRepetition = getCurrentPlayer().getRepresentation();
        for ( int k = 0; k < 5; k++) {
            int x = startX + dirX * k;
            int y = startY + dirY * k;

            if (x < 0 || x >= getSize() || y < 0 || y >= getSize() || !getBoard()[x][y].getRepresentation().equals(playerRepetition)) {
                return false; // Si la celle est invalide ou n’est pas un pion du joueur actuel
            }
        }
        return true; // Si les 5 celles sont consécutives
    }

    // methode pour verifier les chances de gagner
    @Override
    public boolean isOver() {

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                // Vérifie si l’élément (i,j) est la tête d’une séquence de 5 pions horizontaux
                if (j <= getSize() - 5 && checkConsecutive(i, j, 1, 0)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 5 pions verticales
                if (i <= getSize() - 5 && checkConsecutive(i, j, 0, 1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 5 pions en diagonales
                if (i <= getSize() - 5 && checkConsecutive(i, j, 1, 1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 5 pions en diagonales inversée
                if (i <= getSize() - 5 && checkConsecutive(i, j, 1, -1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
            }
        }

        // verification du tableau rempli
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
