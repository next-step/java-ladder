package ladder.domain;

public class Node {

    private final int index;
    private final Way way;

    public Node(final int index, final Way way) {
        this.index = index;
        this.way = way;
    }

    public int move() {
        if (isMovableLeft()) {
            return this.index - 1;
        }
        if (isMovableRight()) {
            return this.index + 1;
        }
        return this.index;
    }

    public boolean isMovableLeft() {
        return this.way.isMovableLeft();
    }

    public boolean isMovableRight() {
        return this.way.isMovableRight();
    }
}
