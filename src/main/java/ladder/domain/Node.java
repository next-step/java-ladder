package ladder.domain;

public class Node {

    private static final int ZERO = 0;

    private final int index;
    private final Way way;

    public Node(final int index, final Way way) {
        this.index = index;
        this.way = way;
    }

    public static Node createFirst(final boolean isMovableRight) {
        return new Node(ZERO, new Way(false, isMovableRight));
    }

    public Node createLast() {
        return new Node(this.index + 1, new Way(this.isMovableRight(), false));
    }

    public Node createNextNode(final boolean isMovableRight) {
        if (isMovableRight()) {
            return new Node(this.index + 1, Way.nextWay(this.way.isMovableRight(), false));
        }
        return new Node(this.index + 1, Way.nextWay(this.way.isMovableRight(), isMovableRight));
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

    public int getIndex() {
        return index;
    }
}
