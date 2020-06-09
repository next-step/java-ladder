package ladder.domain.player;

public class Position {
    private static final int START_HEIGHT = 1;
    private final int height;
    private final int column;

    public Position(int column) {
        this.height = START_HEIGHT;
        this.column = column;
    }

    public int getHeight() {
        return this.height;
    }

    public int getColumn() {
        return this.column;
    }
}
