package nextstep.ladder.domain;

public class Point1 {
    private int index;
    private Direction1 direction1;

    public Point1(int index, Direction1 direction1) {
        this.index = index;
        this.direction1 = direction1;
    }

    public Point1 next() {
        return new Point1(index + 1, direction1.next());
    }

    public static Point1 first(boolean nextPoint) {
        return new Point1(0, Direction1.init(nextPoint));
    }
}
