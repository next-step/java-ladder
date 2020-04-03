package ladder.domain;

public class Node {

    private final int index;
    private final Way way;

    public Node(int index, Way way) {
        this.index = index;
        this.way = way;
    }

    public boolean isMovableLeft() {
        return this.way.isMovableLeft();
    }

    public boolean isMovableRight() {
        return this.way.isMovableRight();
    }
}
