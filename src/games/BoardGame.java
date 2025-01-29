package games;

import player.Player;
import view.InteractionUtilisateur;
import view.View;

public abstract class BoardGame {

    //attributs communes aux jeux
    protected Cell[][] board;
    protected Player currentPlayer;
    InteractionUtilisateur interactionUtilisateur;
    View view;
}
