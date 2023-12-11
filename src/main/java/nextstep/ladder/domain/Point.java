package nextstep.ladder.domain;

public class Point {
    private final Boolean isStair;

    public Point(boolean isStair) {
        this.isStair = isStair;
    }

    public Boolean getIsStair() {
        return isStair;
    }
}
