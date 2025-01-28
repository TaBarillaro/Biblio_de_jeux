public abstract class Player {

    protected String representation;

    public Player(String representation) {

        this.representation = representation;
    }

    public String getRepresentation() {

        return representation;
    }

    public void setRepresentation(String representation) {

        this.representation = representation;
    }

    public abstract void makeMove(Cell[][] board);
}
