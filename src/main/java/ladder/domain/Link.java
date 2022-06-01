package ladder.domain;

public class Link {
    private final int from;
    private final Node node;

    @Override
    public String toString() {
        return "Link{" +
                "from=" + from +
                ", node=" + node +
                '}';
    }

    public Link(int from, Node node) {
        this.from = from;
        this.node = node;
    }

    public int move() {
        return this.from + this.node.variation();
    }

    public static Link firstRandom() {
        return new Link(0, Node.firstRandom());
    }

    public Link nextRandom() {
        return new Link(this.from + 1, this.node.nextRandom());
    }

    public Link next(Boolean point) {
        return new Link(this.from + 1, this.node.next(point));
    }

    public static Link first(boolean current) {
        return new Link(0, Node.first(current));
    }

    public Link last() {
        return new Link(this.from + 1, this.node.last());
    }

    public int from() {
        return this.from;
    }

    public String toShow() {
        return this.node.toShow();
    }
}
