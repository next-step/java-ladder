package nextstep.ladder.domain;

public class Point {

    private PointStatus status;

    public Point(PointStatus status) {
        this.status = status;
    }

    public PointStatus getStatus() {
        return status;
    }

}
