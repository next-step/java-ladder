package ladder.domain;

public class Spot {
    private final Way way;

    public Spot(Way way) {
        this.way = way;
    }

    public int move(int index) {
        return index + this.way.variation();
    }

    public static Spot firstRandom() {
        return new Spot(Way.firstRandom());
    }

    public Spot nextRandom() {
        return new Spot(this.way.nextRandom());
    }

    public Spot last() {
        return new Spot(this.way.last());
    }

    public String toShow() {
        return this.way.toShow();
    }
}
