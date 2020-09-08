package nextstep.entity;

public class Point {

    private final boolean hasPedal;

    private Point(boolean hasPedal) {
        this.hasPedal = hasPedal;
    }

    public boolean isPedalExist() {
        return this.hasPedal;
    }

    public static Point of(boolean hasPedal) {
        return new Point(hasPedal);
    }
}
