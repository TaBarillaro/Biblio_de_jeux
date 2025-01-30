package games;

import player.ArtificialPlayer;
import player.HumanPlayer;

public class Puissance4 extends BoardGame{

    // construct pour initialiser le board
    public Puissance4() {
        super(6, 7);
    }

    @Override
    protected void initPlayer() {
        getView().userChoice();
        String playerType = getInteractionUtilisateur().recoveryAnswer();

        if(playerType.equals("human")) {
            setPlayer1(new HumanPlayer("| \uD83D\uDFE0"));
            setPlayer2(new HumanPlayer("| \uD83D\uDFE2"));
        } else if(playerType.equals("ai")) {
            setPlayer1(new HumanPlayer("| \uD83D\uDFE0"));
            setPlayer2(new ArtificialPlayer("| \uD83D\uDFE2"));
        }
        setCurrentPlayer(getPlayer1());
    }

    @Override
    public void play() {
        initPlayer();
        for (int i = 0; i < 42; i++) {
            // montre le tableau à chaque fois
            getView().displayBoard(getBoard());

            // le joueur jeu
            getCurrentPlayer().makeMovePuiss4(getBoard(), getCols());

            if (isOver()) {
                break;
            }
            // operation ternaire pour alterner les joueurs
            setCurrentPlayer(getCurrentPlayer() == getPlayer1() ? getPlayer2() : getPlayer1());
        }
    }

    // methode pour verifier le joueur gagnant
    private boolean checkConsecutive(int StartX, int StartY, int dirX, int dirY) {
        String playerRepetition = getCurrentPlayer().getRepresentation();
        for (int k = 0; k < 4; k++) {
            int x = StartX + dirX * k;
            int y = StartY + dirY * k;

            // Si la celle est invalide
            if(x < 0 || x >= getRows() || y < 0 || y >= getCols()) {
                return false;
            }
            // si la celle ne contient pas un pion du joueur actuel
            if (!getBoard()[x][y].getRepresentation().equals(playerRepetition)) {
                return false;
            }
        }
        return true; // Si les 4 celles sont consecutives
    }

    // methode pour verifier les chances de gagner
    @Override
    public boolean isOver() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                // Vérifie si l’élément (i,j) est la tête d’une séquence de 4 pions horizontaux
                if (j <= getCols() - 4 && checkConsecutive(i, j, 1, 0)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 4 pions verticales
                if (i <= getRows() - 4 && checkConsecutive(i, j, 0, 1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 4 pions en diagonales
                if (i <= getRows() - 4 && checkConsecutive(i, j, 1, 1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
                // Vérifie si l'élément (i,j) est la tete d'une sequence de 4 pions en diagonales inversée
                if (i <= getRows() - 4 && checkConsecutive(i, j, 1, -1)) {
                    getView().displayBoard(getBoard());
                    getView().winner(getCurrentPlayer());
                    return true;
                }
            }
        }
        // verification du tableau rempli
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
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
