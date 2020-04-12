package ladder.domain;

public class Node {

    private static final int ZERO = 0;
    private static final int PLUS_NEXT_INDEX = 1;

    private final int index;
    private final Way way;

    public Node(final int index, final Way way) {
        this.index = index;
        this.way = way;
    }

    public Node(final boolean isMovableRight) {
        this(ZERO, new Way(false, isMovableRight));
    }

    public Node(final LadderMoveStrategy strategy) {
        this(ZERO, Way.from(strategy));
    }

    public Node createLast() {
        return new Node(this.index + PLUS_NEXT_INDEX, new Way(this.isMovableRight(), false));
    }

    public Node createNextNode(final boolean isMovableRight) {
        int nextIndex = this.index + PLUS_NEXT_INDEX;

        if (isMovableRight()) {
            return new Node(nextIndex, new Way(this.way.isMovableRight(), false));
        }
        return new Node(nextIndex, new Way(this.way.isMovableRight(), isMovableRight));
    }

    public Node createNextNode(final LadderMoveStrategy strategy) {
        int nextIndex = this.index + PLUS_NEXT_INDEX;
        return new Node(nextIndex, way.next(strategy));
    }

    public int move() {
        if (isMovableLeft()) {
            return this.index - PLUS_NEXT_INDEX;
        }
        if (isMovableRight()) {
            return this.index + PLUS_NEXT_INDEX;
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
