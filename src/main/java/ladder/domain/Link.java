package ladder.domain;

public class Link {
    private final int from;
    private final Way way;

    @Override
    public String toString() {
        return "Link{" +
                "from=" + from +
                ", way=" + way +
                '}';
    }

    public Link(int from, Way way) {
        this.from = from;
        this.way = way;
    }

    public int move() {
        return this.from + this.way.variation();
    }

    public static Link firstRandom() {
        return new Link(0, Way.firstRandom());
    }

    public Link nextRandom() {
        return new Link(this.from + 1, this.way.nextRandom());
    }

    public Link next(Boolean point) {
        return new Link(this.from + 1, this.way.next(point));
    }

    public static Link first(boolean current) {
        return new Link(0, Way.first(current));
    }

    public Link last() {
        return new Link(this.from + 1, this.way.last());
    }

    public int from() {
        return this.from;
    }

    public String toShow() {
        return this.way.toShow();
    }
}
