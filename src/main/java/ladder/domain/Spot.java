package ladder.domain;

public class Spot {
    private final Way way;

//    @Override
//    public String toString() {
//        return "Spot{" +
//                "from=" + from +
//                ", way=" + way +
//                '}';
//    }

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

//    public Spot next(Boolean point) {
//        return new Spot(this.way.next(point));
//    }

//    public static Spot first(boolean current) {
//        return new Spot(Way.first(current));
//    }

    public Spot last() {
        return new Spot(this.way.last());
    }

//    public int from() {
//        return this.from;
//    }

    public String toShow() {
        return this.way.toShow();
    }
}
