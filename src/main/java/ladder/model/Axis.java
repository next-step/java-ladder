package ladder.model;

public class Axis {
    private final int row;
    private final int col;

    public Axis(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public Axis add(Direction direction) {
        return add(direction.getAxis());
    }
    public Axis add(Axis other) {
        return new Axis(row + other.row, col + other.col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
