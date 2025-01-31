package player;

import view.Cell;

public abstract class Player {

    protected String representation;

    public Player(String representation) {

        this.representation = representation;
    }

    public String getRepresentation() {

        return representation;
    }

    public abstract void makeMove(Cell[][] board, int rows, int cols);

    public abstract void makeMovePuiss4(Cell[][] board, int cols);
}
