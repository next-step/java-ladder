package ladder.domain;

public class Link {
    private final int from;
    private final Node node;

    public Link(int from, Node node) {
        this.from = from;
        this.node = node;
    }

    public int move() {
        if (this.node.move() == Direction.LEFT && this.from < 1) { // move logic to From class?
            throw new RuntimeException("Cannot move to negative");
        }
        if (this.node.move() == Direction.LEFT) {
            return this.from - 1;
        }
        if (this.node.move() == Direction.RIGHT) {
            return this.from + 1;
        }
        return this.from;
    }
}
