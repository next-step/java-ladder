package nextstep.entity;

public class Point {

    private final boolean hasPedal;

    public Point(boolean hasPedal) {
        this.hasPedal = hasPedal;
    }

    public boolean isPedalExist() {
        return this.hasPedal;
    }
}
